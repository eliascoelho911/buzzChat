package com.buzzchat.ui.features.user.repository

import com.buzzchat.ui.features.user.model.User

interface UserRepository {
    fun getLoggedUser(): User
}