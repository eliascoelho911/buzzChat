package com.buzzchat.core.common.date

import org.joda.time.LocalDateTime

fun localDateTime(millis: Long): LocalDateTime = LocalDateTime(millis)

fun LocalDateTime.getMillis(): Long = toDateTime().millis