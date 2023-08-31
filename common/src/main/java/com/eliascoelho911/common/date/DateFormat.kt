package com.eliascoelho911.common.date

import org.joda.time.LocalDateTime

fun LocalDateTime.formatToHours(onlyToday: Boolean = true): String {
    return if (onlyToday && isToday()) toString("HH:mm")
    else formatToSimpleDate()
}

fun LocalDateTime.formatToSimpleDate(): String {
    return toString("dd/MM/yyyy")
}

private fun LocalDateTime.isToday() = dayOfMonth == LocalDateTime.now().dayOfMonth