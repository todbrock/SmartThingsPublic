/**
* Event with Unlocked by Specific Code ID
* Review logs to determine what ID is used.
* Author: TodB
*/


// Automatically generated. Make future change here.
definition(
    name: "Set Mode with Unlock",
    namespace: "",
    author: "ctbrock@gmail.com",
    description: "Set Mode with Unlock",
    category: "My Apps",
    iconUrl: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience.png",
    iconX2Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience%402x.png",
    iconX3Url: "https://s3.amazonaws.com/smartapp-icons/Convenience/Cat-Convenience%402x.png")

preferences {
    section("Determine Home Mode When the following lock:") {
                input "lock1","capability.lock", title: "Lock", multiple: true
    }
/**
* section("Unlocks with the following assigned ID (1-30):") {
*    			input "code1", "number"
*    }
*/
}

def installed()
{
        subscribe(lock1, "lock", LockHandler)
}

def updated()
{
        unsubscribe()
        subscribe(lock1, "lock", LockHandler)
}

def LockHandler(evt) {
   if (evt.value == "unlocked") {
//      if (evt.data == '{"usedCode":'+code1+'}')
//      {
                def newMode = location.mode
                   
                if (location.mode == "Away") {
                	newMode = "Home"
                	}
                if (location.mode == "Away Night") {
                	newMode = "Home Night"
                    }
         if (location.mode != newMode) {
         setLocationMode(newMode)
         }
//      }
                                }
                     }