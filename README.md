# Ecovent
Ecovent API for SmartThings

To install this ecovent system you first need to make the device type and the smartapp. 

Known Issues that need help fixing. I am sure there are more however it's been awhile since I used the smartapp and have been sitting on the code to see if  ecovent would release an echo skill or smartapp for smartthings on their own. They haven't so here is what i have. 

1: Adding switch and code for users to go from "C" to "F"

2: Ensuring tempatures are seen correctly with smartthings (ex. I have found that even with everything showing as "F" my echo only sees "C"

3: The token doesn't seem to have an expiration date, however with the smartapp the token starts to throw errors after a week or two, sometimes shorter and sometimes sooner. Need coded that allows the app to get a new token if the token it has fails. 

4: Ensure that all commands. Temp up Temp Down, Set Temp, Turn on fan are all smartthing friendly so that routines and Alexa Echo can control that room.

5: Adding ecovent scenes support somehow. (low on todo list)
