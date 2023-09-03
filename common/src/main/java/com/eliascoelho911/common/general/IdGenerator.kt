package com.eliascoelho911.common.general

import java.util.UUID

fun generateId(): String {
    return UUID.randomUUID().toString()
}