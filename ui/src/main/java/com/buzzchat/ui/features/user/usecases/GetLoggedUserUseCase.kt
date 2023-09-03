package com.buzzchat.ui.features.user.usecases

import com.buzzchat.ui.features.user.model.User
import com.buzzchat.ui.features.user.repository.UserRepository

class GetLoggedUserUseCase(private val repository: UserRepository) {
    operator fun invoke(): User {
        return repository.getLoggedUser()
    }
}