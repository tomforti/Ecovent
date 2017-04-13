https://cloud.ecovent.io/api/v1/version
//No Header or body
//Get
//Response
{
  "android_latest_version": 11100,
  "android_minimum_version": 3000,
  "ios_latest_version": "0.0.0",
  "ios_minimum_version": "0.0.0",
  "tablet_latest_version": 11100,
  "tablet_minimum_version": 3000,
  "tablet_url": "https://cloud.ecovent.io/static/tablet.apk"
}

--------------
https://cloud.ecovent.io/api/v1/session
//Post
{
  "email": "Email Address",
  "password": "Password"
}

//Response
{
  "cloud_authorization": "88*************e",
  "first_name": "Owners First Name",
  "id": 1**,
  "last_name": "Owners Last Name",
  "serial_numbers": [
    "E*************9"
  ]
}

------------
https://cloud.ecovent.io/remote/v1/structure
//Get
//Header only no body
Authorization: "token=Token Goes Here"]

//Response
{
  "home": {
    "zones": [
      {
        "id": 1,
        "rooms": [
          {
            "name": "Kitchen",
            "floor": "1",
            "non_ecovents": 0,
            "air_return": null,
            "vents": [
              {
                "serial_number": "1*************c",
                "sticker_code": "8*************1",
                "hardware_id": "16*************c",
                "id": 1
              }
            ],
            "sensors": [
              {
                "serial_number": "43*************2",
                "sticker_code": "2*************9",
                "hardware_id": "4*************2",
                "id": 1
              }
            ],
            "type": "Kitchen",
            "id": 1
          },
          {
            "name": "Dining",
            "floor": "1",
            "non_ecovents": 0,
            "air_return": null,
            "vents": [
              {
                "serial_number": "0*************4c",
                "sticker_code": "2*************3",
                "hardware_id": "0*************c",
                "id": 2
              },
              {
                "serial_number": "0*************6",
                "sticker_code": "4*************9",
                "hardware_id": "0*************6",
                "id": 3
              }
            ],
            "sensors": [
              {
                "serial_number": "43*************2",
                "sticker_code": "00*************6",
                "hardware_id": "43*************2",
                "id": 2
              }
            ],
            "type": "Dining",
            "id": 2
          },
          {
            "name": "Bath",
            "floor": "1",
            "non_ecovents": 0,
            "air_return": null,
            "vents": [],
            "sensors": [
              {
                "serial_number": "43*************32",
                "sticker_code": "7*************7",
                "hardware_id": "43*************32",
                "id": 3
              }
            ],
            "type": "Bath",
            "id": 3
          },
          {
            "name": "Bed",
            "floor": "1",
            "non_ecovents": 0,
            "air_return": null,
            "vents": [
              {
                "serial_number": "0e*************a",
                "sticker_code": "49*************5",
                "hardware_id": "0e*************a",
                "id": 4
              }
            ],
            "sensors": [
              {
                "serial_number": "43*************2",
                "sticker_code": "2*************8",
                "hardware_id": "43*************32",
                "id": 4
              }
            ],
            "type": "Bed",
            "id": 4
          },
          {
            "name": "Living",
            "floor": "1",
            "non_ecovents": 0,
            "air_return": null,
            "vents": [
              {
                "serial_number": "1*************3a",
                "sticker_code": "47*************1",
                "hardware_id": "19*************3a",
                "id": 5
              },
              {
                "serial_number": "0e*************0",
                "sticker_code": "72*************1",
                "hardware_id": "0e*************0",
                "id": 6
              },
              {
                "serial_number": "0e*************0",
                "sticker_code": "7*************1",
                "hardware_id": "0e*************0",
                "id": 7
              }
            ],
            "sensors": [
              {
                "serial_number": "43*************32",
                "sticker_code": "74*************2",
                "hardware_id": "43*************2",
                "id": 5
              },
              {
                "serial_number": "43*************2",
                "sticker_code": "5*************0",
                "hardware_id": "43*************2",
                "id": 6
              }
            ],
            "type": "Living",
            "id": 5
          },
          {
            "name": "Kids",
            "floor": "1",
            "non_ecovents": 0,
            "air_return": null,
            "vents": [
              {
                "serial_number": "0d*************f",
                "sticker_code": "03*************9",
                "hardware_id": "0d*************4f",
                "id": 11
              }
            ],
            "sensors": [
              {
                "serial_number": "43*************2",
                "sticker_code": "33*************5",
                "hardware_id": "4*************32",
                "id": 7
              }
            ],
            "type": "Kids",
            "id": 6
          }
        ],
        "name": "Sensi",
        "thermostat": {
          "serial_number": "36-*************-6f",
          "hardware_id": "36-*************-6f",
          "type": "Sensi",
          "id": 2
        }
      }
    ],
    "name": "my home",
    "time_zone": "America/New_York"
  }
}

------------------
https://cloud.ecovent.io/remote/v1/status
//Get
//Header only no body
Authorization: "token=Token Goes Here"]

//Response
{
  "thermostat_status": [
    {
      "mode": "heat",
      "mode_transition": null,
      "fan": "auto",
      "remote_time": "2017-04-13 13:36:56",
      "id": 2
    }
  ],
  "sensor_status": [
    {
      "pressure": 1000.11962890625,
      "remote_time": "2017-04-13 13:36:24",
      "temp2": 18.2125,
      "temp1": 21.77989990234375,
      "humidity": 42.069000244140625,
      "id": 1
    },
    {
      "pressure": 1001.070068359375,
      "remote_time": "2017-04-13 13:36:24",
      "temp2": 22.45625,
      "temp1": 21.018417968749993,
      "humidity": 43.686431884765625,
      "id": 2
    },
    {
      "pressure": 1000.888916015625,
      "remote_time": "2017-04-13 13:36:25",
      "temp2": 22.7875,
      "temp1": 23.581716308593748,
      "humidity": 36.720794677734375,
      "id": 3
    },
    {
      "pressure": 1002.82958984375,
      "remote_time": "2017-04-13 13:36:25",
      "temp2": 23.991666666666667,
      "temp1": 21.801350097656247,
      "humidity": 44.830841064453125,
      "id": 4
    },
    {
      "pressure": 1000.4189453125,
      "remote_time": "2017-04-13 13:36:25",
      "temp2": 23.104166666666668,
      "temp1": 21.87642578125,
      "humidity": 40.161651611328125,
      "id": 5
    },
    {
      "pressure": 1003.171875,
      "remote_time": "2017-04-13 13:36:26",
      "temp2": 19.164583333333333,
      "temp1": 19.044999999999995,
      "humidity": 43.816131591796875,
      "id": 6
    },
    {
      "pressure": 1001.47900390625,
      "remote_time": "2017-04-13 13:36:26",
      "temp2": 27.577083333333334,
      "temp1": 23.764042968749997,
      "humidity": 35.271209716796875,
      "id": 7
    }
  ],
  "vent_status": [
    {
      "temp": 13.193750000000001,
      "id": 1,
      "pressure": 995.576416015625,
      "vbat": 0,
      "open": 0,
      "remote_time": "2017-04-13 13:36:24"
    },
    {
      "temp": 17.55,
      "id": 2,
      "pressure": 996.037109375,
      "vbat": 0,
      "open": 100,
      "remote_time": "2017-04-13 13:36:24"
    },
    {
      "temp": 20.854166666666668,
      "id": 3,
      "pressure": 996.129638671875,
      "vbat": 0,
      "open": 100,
      "remote_time": "2017-04-13 13:36:24"
    },
    {
      "temp": 15.006250000000001,
      "id": 4,
      "pressure": 995.943115234375,
      "vbat": 0,
      "open": 100,
      "remote_time": "2017-04-13 13:36:25"
    },
    {
      "temp": 9.635416666666664,
      "id": 5,
      "pressure": 995.094970703125,
      "vbat": 0,
      "open": 0,
      "remote_time": "2017-04-13 13:36:25"
    },
    {
      "temp": 17.541666666666668,
      "id": 6,
      "pressure": 995.443603515625,
      "vbat": 0,
      "open": 0,
      "remote_time": "2017-04-13 13:36:25"
    },
    {
      "temp": 13.641666666666666,
      "id": 7,
      "pressure": 995.603515625,
      "vbat": 0,
      "open": 0,
      "remote_time": "2017-04-13 13:36:25"
    },
    {
      "temp": 17.44375,
      "id": 11,
      "pressure": 995.7001953125,
      "vbat": 0,
      "open": 100,
      "remote_time": "2017-04-13 13:36:26"
    }
  ],
  "room_status": [
    {
      "pressure": 1000.177734375,
      "remote_time": "2017-04-13 13:36:18",
      "id": 1,
      "temp": 21.77989990234375,
      "humidity": 42.366546630859375
    },
    {
      "pressure": 1001.137451171875,
      "remote_time": "2017-04-13 13:36:18",
      "id": 2,
      "temp": 21.02914306640624,
      "humidity": 43.678802490234375
    },
    {
      "pressure": 1000.996826171875,
      "remote_time": "2017-04-13 13:36:18",
      "id": 3,
      "temp": 23.581716308593748,
      "humidity": 36.461395263671875
    },
    {
      "pressure": 1002.845458984375,
      "remote_time": "2017-04-13 13:36:18",
      "id": 4,
      "temp": 21.801350097656247,
      "humidity": 44.853729248046875
    },
    {
      "pressure": 1001.91064453125,
      "remote_time": "2017-04-13 13:36:18",
      "id": 5,
      "temp": 20.46607543945312,
      "humidity": 42.130035400390625
    },
    {
      "pressure": 1001.66162109375,
      "remote_time": "2017-04-13 13:36:18",
      "id": 6,
      "temp": 23.764042968749997,
      "humidity": 35.278839111328125
    }
  ]
}

------------------
https://cloud.ecovent.io/remote/v1/prefs
//Get
//Header only no body
Authorization: "token=Token Goes Here"]

//Response
{
  "active_scene": {
    "current_scene_id": 7,
    "scene_overridden_time": null,
    "scheduled_scene_id": 7
  },
  "away_temp_low": 15.930010000000001,
  "room_prefs": [
    {
      "ignore": false,
      "relative_setpoint": -2,
      "setpoint": 21.11111111111111,
      "priority": false,
      "ui_position": 4,
      "priority_set_timestamp": "2017-03-31 17:53:04",
      "id": 1
    },
    {
      "ignore": false,
      "relative_setpoint": -1,
      "setpoint": 21.66666666666667,
      "priority": false,
      "ui_position": 3,
      "priority_set_timestamp": "2017-04-12 20:24:16",
      "id": 2
    },
    {
      "ignore": true,
      "relative_setpoint": 0,
      "setpoint": 21.06476772732206,
      "priority": false,
      "ui_position": 5,
      "priority_set_timestamp": "2017-03-20 01:56:56",
      "id": 3
    },
    {
      "ignore": false,
      "relative_setpoint": 1,
      "setpoint": 21.66666666666667,
      "priority": false,
      "ui_position": 1,
      "priority_set_timestamp": "2017-04-06 17:29:40",
      "id": 4
    },
    {
      "ignore": false,
      "relative_setpoint": 2,
      "setpoint": 21.66666666666667,
      "priority": false,
      "ui_position": 2,
      "priority_set_timestamp": "2017-04-12 04:25:32",
      "id": 5
    },
    {
      "ignore": false,
      "relative_setpoint": -1,
      "setpoint": 22.77777777777776,
      "priority": false,
      "ui_position": 0,
      "priority_set_timestamp": "2017-04-06 17:29:33",
      "id": 6
    }
  ],
  "away": false,
  "scenes": [
    {
      "name": "Away (heat)",
      "color": "E07AB8",
      "room_prefs": [
        {
          "ignore": true,
          "id": 6
        },
        {
          "ignore": true,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 19.44444444444445,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 19.44444444444445,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 19.44444444444445,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 1
    },
    {
      "name": "Evening (heat)",
      "color": "FE956E",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 23.33333333333334,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 22.222222222222218,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "18:00",
          "day": "wednesday"
        },
        {
          "start_time": "18:00",
          "day": "sunday"
        },
        {
          "start_time": "18:00",
          "day": "friday"
        },
        {
          "start_time": "18:00",
          "day": "saturday"
        },
        {
          "start_time": "18:00",
          "day": "monday"
        },
        {
          "start_time": "18:00",
          "day": "tuesday"
        },
        {
          "start_time": "18:00",
          "day": "thursday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 3
    },
    {
      "name": "Good Night (heat)",
      "color": "4B81FE",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 23.88888888888889,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 22.777777777777768,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 20.555555555555564,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 20.555555555555564,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 20,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "23:30",
          "day": "saturday"
        },
        {
          "start_time": "23:30",
          "day": "thursday"
        },
        {
          "start_time": "23:30",
          "day": "friday"
        },
        {
          "start_time": "23:30",
          "day": "tuesday"
        },
        {
          "start_time": "23:30",
          "day": "sunday"
        },
        {
          "start_time": "23:30",
          "day": "wednesday"
        },
        {
          "start_time": "23:30",
          "day": "monday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 5
    },
    {
      "name": "Good Morning (heat)",
      "color": "FEE107",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 23.88888888888889,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 22.777777777777768,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "07:15",
          "day": "monday"
        },
        {
          "start_time": "07:15",
          "day": "friday"
        },
        {
          "start_time": "07:15",
          "day": "tuesday"
        },
        {
          "start_time": "07:15",
          "day": "thursday"
        },
        {
          "start_time": "07:15",
          "day": "wednesday"
        },
        {
          "start_time": "07:15",
          "day": "sunday"
        },
        {
          "start_time": "07:15",
          "day": "saturday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 6
    },
    {
      "name": "Daytime (heat)",
      "color": "00A68E",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 22.77777777777776,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "09:00",
          "day": "wednesday"
        },
        {
          "start_time": "09:00",
          "day": "sunday"
        },
        {
          "start_time": "09:00",
          "day": "tuesday"
        },
        {
          "start_time": "09:00",
          "day": "thursday"
        },
        {
          "start_time": "09:00",
          "day": "saturday"
        },
        {
          "start_time": "09:00",
          "day": "monday"
        },
        {
          "start_time": "09:00",
          "day": "friday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 7
    },
    {
      "name": "Cool House-Day",
      "color": "4B81FE",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [],
      "thermostat_prefs": [
        {
          "fan": "on",
          "id": 2,
          "mode": "cool"
        }
      ],
      "id": 8
    }
  ],
  "ecovent_control": "control_stats_and_vents",
  "away_temp_high": 26.805979999999998,
  "scenes_enabled": true,
  "away_schedules": [],
  "thermostat_prefs": [
    {
      "setpoint_set_timestamp": null,
      "setpoint": null,
      "setpoint_high": null,
      "fan_set_timestamp": "2017-04-12 20:27:43",
      "fan": "auto",
      "mode": "heat",
      "mode_set_timestamp": "2017-04-12 20:24:39",
      "id": 2,
      "setpoint_low": null
    }
  ],
  "system_state": "run",
  "schedules_enabled": true,
  "mode": "heat"
}


-------------------
https://cloud.ecovent.io/remote/v1/alerts
//Get
//Header only no body
Authorization: "token=Token Goes Here"]

//Response
//Not much here being I have no alerts on my system at this time
{
  "alerts": []
}


------------------
https://cloud.ecovent.io/remote/v1/room_prefs
//Put Request
//Header
Authorization: "token=Token Goes Here"]

//Example body
{
  "room_prefs": [
    {
      "id": 4,
      "ignore": false,
      "relative_setpoint": 1,
      "setpoint": 20,
      "ui_position": 1
    }
  ]
}


//Example response
{
  "room_prefs": [
    {
      "ignore": false,
      "relative_setpoint": -2,
      "setpoint": 21.11111111111111,
      "priority": false,
      "ui_position": 4,
      "priority_set_timestamp": "2017-03-31 17:53:04",
      "id": 1
    },
    {
      "ignore": false,
      "relative_setpoint": -1,
      "setpoint": 21.66666666666667,
      "priority": false,
      "ui_position": 3,
      "priority_set_timestamp": "2017-04-12 20:24:16",
      "id": 2
    },
    {
      "ignore": true,
      "relative_setpoint": 0,
      "setpoint": 21.06476772732206,
      "priority": false,
      "ui_position": 5,
      "priority_set_timestamp": "2017-03-20 01:56:56",
      "id": 3
    },
    {
      "ignore": false,
      "relative_setpoint": 1,
      "setpoint": 20,
      "priority": true,
      "ui_position": 1,
      "priority_set_timestamp": "2017-04-13 13:42:03",
      "id": 4
    },
    {
      "ignore": false,
      "relative_setpoint": 2,
      "setpoint": 21.66666666666667,
      "priority": false,
      "ui_position": 2,
      "priority_set_timestamp": "2017-04-12 04:25:32",
      "id": 5
    },
    {
      "ignore": false,
      "relative_setpoint": -1,
      "setpoint": 22.77777777777776,
      "priority": false,
      "ui_position": 0,
      "priority_set_timestamp": "2017-04-06 17:29:33",
      "id": 6
    }
  ]
}


----------------
https://cloud.ecovent.io/remote/v1/thermostat_prefs
//Put Request
//Header
Authorization: "token=Token Goes Here"]

//Example body
{
  "thermostat_prefs": [
    {
      "id": 2,
      "fan":"auto"
    }
  ]
}


//Example Body Response
{
  "thermostat_prefs": [
    {
      "setpoint": null,
      "setpoint_high": null,
      "fan": "auto",
      "mode": "heat",
      "id": 2,
      "setpoint_low": null
    }
  ]
}

--------------------
https://cloud.ecovent.io/remote/v1/active_scene
//Put Request
//Header
Authorization: "token=Token Goes Here"]

//Example body
{
  "id": 1
}

//Example Response
{
  "active_scene": {
    "current_scene_id": 1,
    "scene_overridden_time": "2017-04-13 13:42:04",
    "scheduled_scene_id": 7
  },
  "away_temp_low": 15.930010000000001,
  "room_prefs": [
    {
      "ignore": false,
      "relative_setpoint": -2,
      "setpoint": 19.44444444444445,
      "priority": false,
      "ui_position": 4,
      "priority_set_timestamp": "2017-03-31 17:53:04",
      "id": 1
    },
    {
      "ignore": false,
      "relative_setpoint": -1,
      "setpoint": 19.44444444444445,
      "priority": false,
      "ui_position": 3,
      "priority_set_timestamp": "2017-04-12 20:24:16",
      "id": 2
    },
    {
      "ignore": true,
      "relative_setpoint": 0,
      "setpoint": 21.06476772732206,
      "priority": false,
      "ui_position": 5,
      "priority_set_timestamp": "2017-03-20 01:56:56",
      "id": 3
    },
    {
      "ignore": true,
      "relative_setpoint": 1,
      "setpoint": 20,
      "priority": true,
      "ui_position": 1,
      "priority_set_timestamp": "2017-04-13 13:42:03",
      "id": 4
    },
    {
      "ignore": false,
      "relative_setpoint": 2,
      "setpoint": 19.44444444444445,
      "priority": false,
      "ui_position": 2,
      "priority_set_timestamp": "2017-04-12 04:25:32",
      "id": 5
    },
    {
      "ignore": true,
      "relative_setpoint": -1,
      "setpoint": 22.77777777777776,
      "priority": false,
      "ui_position": 0,
      "priority_set_timestamp": "2017-04-06 17:29:33",
      "id": 6
    }
  ],
  "away": false,
  "scenes": [
    {
      "name": "Away (heat)",
      "color": "E07AB8",
      "room_prefs": [
        {
          "ignore": true,
          "id": 6
        },
        {
          "ignore": true,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 19.44444444444445,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 19.44444444444445,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 19.44444444444445,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 1
    },
    {
      "name": "Evening (heat)",
      "color": "FE956E",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 23.33333333333334,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 22.222222222222218,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "18:00",
          "day": "wednesday"
        },
        {
          "start_time": "18:00",
          "day": "sunday"
        },
        {
          "start_time": "18:00",
          "day": "friday"
        },
        {
          "start_time": "18:00",
          "day": "saturday"
        },
        {
          "start_time": "18:00",
          "day": "monday"
        },
        {
          "start_time": "18:00",
          "day": "tuesday"
        },
        {
          "start_time": "18:00",
          "day": "thursday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 3
    },
    {
      "name": "Good Night (heat)",
      "color": "4B81FE",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 23.88888888888889,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 22.777777777777768,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 20.555555555555564,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 20.555555555555564,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 20,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "23:30",
          "day": "saturday"
        },
        {
          "start_time": "23:30",
          "day": "thursday"
        },
        {
          "start_time": "23:30",
          "day": "friday"
        },
        {
          "start_time": "23:30",
          "day": "tuesday"
        },
        {
          "start_time": "23:30",
          "day": "sunday"
        },
        {
          "start_time": "23:30",
          "day": "wednesday"
        },
        {
          "start_time": "23:30",
          "day": "monday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 5
    },
    {
      "name": "Good Morning (heat)",
      "color": "FEE107",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 23.88888888888889,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 22.777777777777768,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "07:15",
          "day": "monday"
        },
        {
          "start_time": "07:15",
          "day": "friday"
        },
        {
          "start_time": "07:15",
          "day": "tuesday"
        },
        {
          "start_time": "07:15",
          "day": "thursday"
        },
        {
          "start_time": "07:15",
          "day": "wednesday"
        },
        {
          "start_time": "07:15",
          "day": "sunday"
        },
        {
          "start_time": "07:15",
          "day": "saturday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 6
    },
    {
      "name": "Daytime (heat)",
      "color": "00A68E",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 22.77777777777776,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.66666666666667,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [
        {
          "start_time": "09:00",
          "day": "wednesday"
        },
        {
          "start_time": "09:00",
          "day": "sunday"
        },
        {
          "start_time": "09:00",
          "day": "tuesday"
        },
        {
          "start_time": "09:00",
          "day": "thursday"
        },
        {
          "start_time": "09:00",
          "day": "saturday"
        },
        {
          "start_time": "09:00",
          "day": "monday"
        },
        {
          "start_time": "09:00",
          "day": "friday"
        }
      ],
      "thermostat_prefs": [
        {
          "fan": "auto",
          "id": 2,
          "mode": "heat"
        }
      ],
      "id": 7
    },
    {
      "name": "Cool House-Day",
      "color": "4B81FE",
      "room_prefs": [
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 6
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 4
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 5
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 2
        },
        {
          "ignore": false,
          "setpoint": 21.11111111111111,
          "id": 1
        },
        {
          "ignore": true,
          "id": 3
        }
      ],
      "schedules": [],
      "thermostat_prefs": [
        {
          "fan": "on",
          "id": 2,
          "mode": "cool"
        }
      ],
      "id": 8
    }
  ],
  "ecovent_control": "control_stats_and_vents",
  "away_temp_high": 26.805979999999998,
  "scenes_enabled": true,
  "away_schedules": [],
  "thermostat_prefs": [
    {
      "setpoint_set_timestamp": null,
      "setpoint": null,
      "setpoint_high": null,
      "fan_set_timestamp": "2017-04-12 20:27:43",
      "fan": "auto",
      "mode": "heat",
      "mode_set_timestamp": "2017-04-12 20:24:39",
      "id": 2,
      "setpoint_low": null
    }
  ],
  "system_state": "run",
  "schedules_enabled": true,
  "mode": "heat"
}