package com.buzzchat.core.common.date

import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat
import java.util.Locale

fun LocalDateTime.simpleFormat(locale: Locale = Locale.getDefault()): String {
    return when {
        isToday() -> formatToHours(locale)
        isTomorrow() || isYesterday() -> formatToDayOfWeek(locale)
        else -> formatToDate(locale)
    }
}

fun LocalDateTime.formatToDayOfWeek(locale: Locale = Locale.getDefault()): String =
    SimpleDateFormat("EEEE", locale).format(toDate())

fun LocalDateTime.formatToHours(locale: Locale = Locale.getDefault()): String =
    toString(DateTimeFormat.forStyle("-S").withLocale(locale))

fun LocalDateTime.formatToDate(locale: Locale = Locale.getDefault()): String =
    toString(DateTimeFormat.forStyle("S-").withLocale(locale))
