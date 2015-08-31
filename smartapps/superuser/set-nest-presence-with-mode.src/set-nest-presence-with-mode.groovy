/**
 *  Set Nest Presence with Mode Change
 *  Based on ST Mode: Home or Away (Nest: Present or Away)
 *
 *  Author: TodB
 *  Date: 2014-03-25
 */

// Automatically generated. Make future change here.
definition(
    name: "Set Nest Presence with Mode",
    namespace: "",
    author: "ctbrock@gmail.com",
    description: "abc",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience%402x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience%402x.png")

preferences {
	section("Thermostats") {
		input "Nest", "capability.thermostat", multiple: true, required: true
	}
}

def installed() {
	subscribe(location, changedLocationMode)
}

def updated() {
	unsubscribe()
	subscribe(location, changedLocationMode)
}

def changedLocationMode(evt)
{
	if (location.mode == "Home")
    	{ 
        Nest.present()
		}
    if (location.mode == "Home Night")
    	{ 
        Nest.present()
		}
    if (location.mode == "Away")
    	{ 
        Nest.away()
		}
    if (location.mode == "Away Night")
    	{ 
        Nest.away()
		}
    }
