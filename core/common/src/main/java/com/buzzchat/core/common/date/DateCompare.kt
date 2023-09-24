package com.buzzchat.core.common.date

import org.joda.time.LocalDateTime

fun LocalDateTime.isTomorrow(): Boolean {
    val tomorrow = LocalDateTime.now().plusDays(1)
    return dayOfMonth == tomorrow.dayOfMonth && monthOfYear == tomorrow.monthOfYear
}

fun LocalDateTime.isYesterday(): Boolean {
    val yesterday = LocalDateTime.now().minusDays(1)
    return dayOfMonth == yesterday.dayOfMonth && monthOfYear == yesterday.monthOfYear
}

fun LocalDateTime.isToday(): Boolean = dayOfMonth == LocalDateTime.now().dayOfMonth