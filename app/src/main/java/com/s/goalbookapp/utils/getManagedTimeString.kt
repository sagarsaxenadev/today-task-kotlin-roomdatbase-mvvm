package com.s.goalbookapp.utils

object Utils{
    fun getManagedTimeString(hours: Int, minutes: Int): String {
        var hours = hours

        var timeStr = ""
        var amPm = "AM"

        if (hours >= 12) {
            amPm = "PM"
            hours = hours - 12
        }
        if (hours == 0) {
            hours = 12
        }
        timeStr =
            (if (hours < 10) "0$hours" else hours).toString() + ":" + (if (minutes < 10) "0$minutes" else minutes) + " " + amPm

        return timeStr
    }
}
