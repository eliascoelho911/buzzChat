package com.lifetracker.ui.common.date

import org.joda.time.LocalDateTime

fun LocalDateTime.toHoursMinutes(): String {
    return toString("HH:mm")
}