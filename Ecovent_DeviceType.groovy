/*
 *  Ecovent 
 *
 *  Copyright 2017, Tom Forti
 *
 */

import groovy.json.JsonSlurper
import groovy.json.JsonOutput
 preferences {
  input("username", "text", title: "Username", description: 'Your Ecovent username (e-mail address)')
  input("password", "password", title: "Password", description: 'Your Ecovent password')
  input("roomname", "text", title: "Room Name", description: 'Room Name, Must be Exact from Ecovent App')
 }
 metadata {
  definition (name: "Ecovent Room", namespace: "Tomforti", author: "Tom Forti") {
    capability "Actuator"
    capability "Polling"
    capability "Relative Humidity Measurement"
    capability "Temperature Measurement"
    capability "Thermostat"
    capability "Thermostat Setpoint"
    capability "Thermostat Heating Setpoint"
    capability "Thermostat Cooling Setpoint"
    command "away"
    command "home"
    command "setignore"
    command "setpointUp"
    command "setpointDown"
    command "heat"
    command "cool"
    command "fanon"
    command "fanauto"
    command "setHeatingSetpoint"
    command "setCoolingSetpoint"
  }
     tiles(scale: 2) {
  multiAttributeTile(name:"temperature", type:"thermostat", width: 6, height: 4) {
    tileAttribute("device.temperature", key: "PRIMARY_CONTROL") {
      attributeState("default", label:'${currentValue}°', /*icon:"st.Home.home1", */backgroundColors:[
      // Celsius Color Range
      [value: 0, color: "#153591"],
      [value: 7, color: "#1e9cbb"],
      [value: 15, color: "#90d2a7"],
      [value: 23, color: "#44b621"],
      [value: 29, color: "#f1d801"],
      [value: 33, color: "#d04e00"],
      [value: 36, color: "#bc2323"],
      // Fahrenheit Color Range
      [value: 40, color: "#153591"],
      [value: 44, color: "#1e9cbb"],
      [value: 59, color: "#90d2a7"],
      [value: 74, color: "#44b621"],
      [value: 84, color: "#f1d801"],
      [value: 92, color: "#d04e00"],
      [value: 96, color: "#ff8426"]
      ]
      )
    }
    tileAttribute("device.humidity", key: "SECONDARY_CONTROL") {
      attributeState("level", label:'${currentValue}%')
    }
    tileAttribute("device.thermostatMode", key: "THERMOSTAT_MODE") {
      attributeState("heat", label:'${name}')
      attributeState("cool", label:'${name}')
    }
    tileAttribute("device.thermostatSetpoint", key: "THERMOSTAT_SETPOINT") {
      attributeState("default", label:'${currentValue}')
    }
  }

  standardTile("spacerTile", "spacerTile", decoration: "flat", width: 2, height: 1) {
  }
  standardTile("setpointUp", "device.thermostatSetpoint", decoration: "flat", width: 1, height: 1) {
    state "setpointUp", label:' Temp ', action:"setpointUp", icon:"st.thermostat.thermostat-up"
  }
  valueTile("thermostatSetpoint", "device.thermostatSetpoint", width: 2, height: 2) {
    state "default", label:'${currentValue}°', unit:"F", backgroundColor:"#44b621"
  }
  valueTile("heatingSetpoint", "device.heatingSetpoint", width: 2, height: 2) {
    state "default", label:'${currentValue}°', unit:"F", backgroundColor:"#44b621"
  }
  valueTile("coolingSetpoint", "device.coolingSetpoint", width: 2, height: 2) {
    state "default", label:'${currentValue}°', unit:"F", backgroundColor:"#44b621"
  }
  standardTile("setpointDown", "device.thermostatSetpoint", decoration: "flat", width: 1, height: 1) {
    state "setpointDown", label:' Temp ', action:"setpointDown", icon:"st.thermostat.thermostat-down"
  }
  standardTile("thermostatMode", "device.thermostatMode", decoration: "flat", width: 2, height: 2) {
    state "cool", action:"heat", icon: "st.thermostat.cool"
    state "heat", action:"cool", icon: "st.thermostat.heat"
  }
  standardTile("thermostatFanMode", "device.thermostatFanMode", decoration: "flat", width: 2, height: 2) {
    state "on", action:"fanauto", icon: "st.thermostat.fan-on"
    state "auto", action:"fanon", icon: "st.thermostat.fan-auto"
  }
  standardTile("setignore", "device.ignore", decoration: "flat", width: 2, height: 2) {
    state 'false', label:'home', action:"away", icon: "st.Home.home2"
    state 'true', label:'away', action:"home", icon: "st.Transportation.transportation5"
  }
  standardTile("refresh", "device.thermostatMode", decoration: "flat", width: 2, height: 2) {
    state "default", action:"polling.poll", icon:"st.secondary.refresh"
  }
  valueTile("humidity", "device.humidity", width: 2, height: 2) {
    state "default", label:'${currentValue}%', unit:"Humidity"
  }  
  standardTile("hiddenIconTile", "device.temperature", decoration: "flat", width: 2, height: 2, canChangeIcon: true, canChangeBackground: true) {
    state "default", label:'${currentValue}°', icon: "st.Weather.weather2", backgroundColor: "#79B821"
  }

  main("hiddenIconTile")
  details(["temperature", "spacerTile", "setpointDown", "setpointUp", "spacerTile", "thermostatMode", "thermostatSetpoint", "refresh", "setignore", "thermostatFanMode"])
     }
 }

def parse(String description) {
 }

def away() {	
  log.debug "Room Status: Away"
  sendEvent(name: 'ignore', value: true)
   def myArray=[
    id:state.roomid, 
    ignore:true,
  ]  
  def myData = [ room_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('ignore', jsonStr) 
  poll()
 }

def home() {
  log.debug "Room Status: In Use"
  sendEvent(name: 'ignore', value: false)
  def myArray=[
    id:state.roomid, 
    ignore:false,
  ]  
  def myData = [ room_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('ignore', jsonStr)
  poll()
 }

def setpointUp(){
  int newSetpoint = device.currentValue("thermostatSetpoint") + 1
  sendEvent(name: 'thermostatSetpoint', value: newSetpoint)
  sendEvent(name: 'coolingSetpoint', value: newSetpoint)
  sendEvent(name: 'heatingSetpoint', value: newSetpoint)
  log.debug "Setting set point up to: ${newSetpoint}"
  def newSetpointCel = (newSetpoint - 32) / 1.8
  def myArray=[
    id:state.roomid, 
    setpoint:newSetpointCel,
]  
def myData = [ room_prefs:[myArray]]
def builder = new groovy.json.JsonBuilder(myData)
def jsonStr = builder.toString()
api('temperature', jsonStr) 
poll()
 }

def setpointDown(){
  int newSetpoint = device.currentValue("thermostatSetpoint") - 1
  sendEvent(name: 'thermostatSetpoint', value: newSetpoint)
  sendEvent(name: 'coolingSetpoint', value: newSetpoint)
  sendEvent(name: 'heatingSetpoint', value: newSetpoint)
  log.debug "Setting set point up to: ${newSetpoint}"
  def newSetpointCel = (newSetpoint - 32) / 1.8
  def myArray=[
    id:state.roomid, 
    setpoint:newSetpointCel,
  ]  
  def myData = [ room_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('temperature', jsonStr) 
  poll()
 }

def heat() {
  sendEvent(name: 'thermostatMode', value: heat)
  log.debug "Setting Mode to heat" 
  def myArray=[
    id:state.statid, 
    mode:"heat",
  ]  
  def myData = [ thermostat_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('stat', jsonStr)
  poll()
 }

def cool() {
  sendEvent(name: 'thermostatMode', value: cool)
  log.debug "Setting Mode to cool" 
  def myArray=[
    id:state.statid, 
    mode:"cool",
  ]  
  def myData = [ thermostat_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('stat', jsonStr)
  poll()
 }

def fanon() {
  sendEvent(name: 'thermostatFanMode', value: on)
  log.debug "Setting Fan to on" 
  def myArray=[
    id:state.statid, 
    fan:"on",
  ]  
  def myData = [ thermostat_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('stat', jsonStr)
  poll()
 }

def fanauto() {
  sendEvent(name: 'thermostatFanMode', value: auto)
  log.debug "Setting Fan to auto" 
  def myArray=[
    id:state.statid, 
    fan:"auto",
  ]  
  def myData = [ thermostat_prefs:[myArray]]
  def builder = new groovy.json.JsonBuilder(myData)
  def jsonStr = builder.toString()
  api('stat', jsonStr)
  poll()
 }

def api(method, args = [], success = {}) {
  log.debug "Logged in"
  def methods = [
    'status': [uri: "https://cloud.ecovent.io/remote/v1/status", type: 'getstatus'],
    'prefs': [uri: "https://cloud.ecovent.io/remote/v1/prefs", type: 'getprefs'],
    'ignore': [uri: "https://cloud.ecovent.io/remote/v1/room_prefs", type: 'put'],
    'stat': [uri: "https://cloud.ecovent.io/remote/v1/thermostat_prefs", type: 'put'],
    'temperature': [uri: "https://cloud.ecovent.io/remote/v1/room_prefs", type: 'put']
  ]
  def request = methods.getAt(method)
  doRequest(request.uri, args, request.type, success)
 }

 // Need to be logged in before this is called. So don't call this. Call api.
def doRequest(uri, args, type, success) {
  log.debug "Calling $type : $uri : $args"
  def params = [
    uri: uri,
    requestContentType: "application/json",
    headers: ['Authorization': "token=${data.auth.cloud_authorization}"],
    body: args
  ]
    if (type == 'put') {
      httpPut(params) { resp ->
      log.debug("Put status: "+resp.status)
      }
    } else if (type == 'getstatus') {
      httpGet(params) { resp ->
        statusResponse(resp)
        }  
	 } else if (type == 'getprefs') {
      httpGet(params) { resp ->
        prefsResponse(resp)
        }
      } 
      else {
        log.debug("error")
      }
    
 }

private statusResponse(resp) {
  if(resp.status == 200) {
        log.debug("Get status: "+resp.status)
        def id = resp.data.room_status[state.roomid - 1].id //improve this
        def humid = Math.round(resp.data.room_status[state.roomid - 1].humidity)
      	def temp = Math.round((resp.data.room_status[state.roomid - 1].temp * 1.8 ) + 32)
      	sendEvent(name: 'humidity', value: humid)
      	sendEvent(name: 'thermostatFanMode', value: fanMode)
      	sendEvent(name: 'thermostatMode', value: statMode)
      	sendEvent(name: 'temperature', value: temp)
    }else{
        log.debug("Get status: "+resp.status)
    }
}

private prefsResponse(resp) {
  if(resp.status == 200) {
        log.debug("Get Prefs: "+resp.status)
    	def statMode = resp.data.mode
      	def fanMode = resp.data.thermostat_prefs[0].fan //improve this
      	def roomset = Math.round((resp.data.room_prefs[state.roomid - 1].setpoint * 1.8 ) + 32) //improves this
      	def ignore = resp.data.room_prefs[state.roomid - 1].ignore //improve this
      	sendEvent(name: 'thermostatFanMode', value: fanMode)
      	sendEvent(name: 'thermostatMode', value: statMode)
      	sendEvent(name: 'thermostatSetpoint', value: roomset)
      	sendEvent(name: 'heatingSetpoint', value: roomset)
      	sendEvent(name: 'coolingSetpoint', value: roomset)
      	sendEvent(name: 'ignore', value: ignore)
    }else{
        log.debug("Get status: "+resp.status)
    }
}  

def setCoolingSetpoint(temp) {
	log.debug "Setting set point up to: ${newSetpoint}"
    def newSetpointCel = Math.round((temp - 32) / 1.8)
  	sendEvent(name: 'thermostatSetpoint', value: temp)
    sendEvent(name: 'heatingSetpoint', value: temp)
    sendEvent(name: 'coolingSetpoint', value: temp)
    def myArray=[
      id:state.roomid, 
      setpoint:newSetpointCel,
    ]  
    def myData = [ room_prefs:[myArray]]
    def builder = new groovy.json.JsonBuilder(myData)
    def jsonStr = builder.toString()
    api('temperature', jsonStr) 
    poll()
}

def setHeatingSetpoint(temp) {
	log.debug "Setting set point up to: ${temp}"
    def newSetpointCel = Math.round((temp - 32) / 1.8)
  	sendEvent(name: 'thermostatSetpoint', value: temp)
    sendEvent(name: 'heatingSetpoint', value: temp)
    sendEvent(name: 'coolingSetpoint', value: temp)
    def myArray=[
      id:state.roomid, 
      setpoint:newSetpointCel,
    ]  
    def myData = [ room_prefs:[myArray]]
    def builder = new groovy.json.JsonBuilder(myData)
    def jsonStr = builder.toString()
    api('temperature', jsonStr) 
    poll()
}

def poll() {
  structure()
  log.debug "Executing 'poll'"
  api('status', [])
  api('prefs', [])
}

 def login(method = null, args = [], success = {}) {
  def jsonbody = new groovy.json.JsonOutput().toJson([email: settings.username, password: settings.password])
  def params = [
    uri: "https://cloud.ecovent.io/api/v1/session",
    requestContentType: "application/json",
    body: jsonbody
  ]
  httpPost(params) {response ->
    if (response.status != 200 ) {
      log.debug "Ecovent logging failed, status = ${response.status}"
    }
    else {
    data.auth = response.data
    log.debug data.auth
    structure()
    api(method, args, success)
  }
  }
 }

 def structure() {
   def params = [
    uri: "https://cloud.ecovent.io/remote/v1/structure",
    requestContentType: "application/json",
    headers: ['Authorization': "token=${data.auth.cloud_authorization}"],
    ]
   httpGet(params) {resp ->
    if (resp.status != 200 ) {
      log.debug "Failed to get structure, status = ${resp.status}"
    }
    else {
      state.statid = resp.data.home.zones[0].thermostat.id	
      def restRooms = resp.data.home.zones[0].rooms
        restRooms.each { Room -> 
        if ( Room.name == settings.roomname )
           {
                 log.debug("Room Name matches value specified in settings. Room ID is: ${Room.id}")
                 state.roomid = Room.id
           }
        }
  	}

   }
 }

