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
    state "on", action:"fanAuto", icon: "st.thermostat.fan-on"
    state "auto", action:"fanOn", icon: "st.thermostat.fan-auto"
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

def away() {
  parent.away(this)
 }

def home() {
  parent.home(this)
 }

def setpointUp(){
  parent.setpointUp(this)
 }

def setpointDown(){
  parent.setpointDown(this)
 }

def heat() {
  parent.heat()
 }

def cool() {
  parent.cool()
 }

def fanOn() {
  parent.fanOn()
 }

def fanAuto() {
  parent.fanAuto()
 }

def setCoolingSetpoint(temp) {
  parent.setCoolingSetpoint(temp, this)
}

def setHeatingSetpoint(temp) {
    parent.setHeatingSetpoint(temp, this)
}

def poll() {
  parent.devicePoll(this)
}
