package com.lifetracker.ui.common.util.date

import org.joda.time.LocalDateTime

fun LocalDateTime.formatToHoursMinutes(): String {
    return toString("HH:mm")
}

fun LocalDateTime.formatToDay(): String {
    return toString("EEEE")
}