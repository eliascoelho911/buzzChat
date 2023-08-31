package com.eliascoelho911.common.date

import org.joda.time.LocalDateTime
import org.joda.time.format.DateTimeFormat
import java.text.SimpleDateFormat
import java.util.Locale

fun LocalDateTime.simpleFormat(locale: Locale): String {
    return when {
        isToday() -> formatToHours(locale)
        isTomorrow() || isYesterday() -> formatToDayOfWeek(locale)
        else -> formatToDate(locale)
    }
}

fun LocalDateTime.formatToDayOfWeek(locale: Locale): String =
    SimpleDateFormat("EEEE", locale).format(toDate())

fun LocalDateTime.formatToHours(locale: Locale): String =
    toString(DateTimeFormat.forStyle("-S").withLocale(locale))

fun LocalDateTime.formatToDate(locale: Locale): String =
    toString(DateTimeFormat.forStyle("S-").withLocale(locale))
