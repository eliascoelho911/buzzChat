package com.buzzchat.ui.stubs.user

import com.buzzchat.ui.features.user.model.User
import com.eliascoelho911.common.general.generateId

object UserStub {
    fun getUsers(): List<User> = listOf(
        User(
            id = generateId(),
            name = "Lucas Ribeiro",
            avatarUrl = ""
        ),
        User(
            id = generateId(),
            name = "João Pedro",
            avatarUrl = ""
        ),
        User(
            id = generateId(),
            name = "Maria Eduarda",
            avatarUrl = ""
        ),
        User(
            id = generateId(),
            name = "Ana Clara",
            avatarUrl = ""
        ),
    )

    fun getRandomUser(): User = getUsers().random()

    fun getLoggedUser(): User = User(
        id = generateId(),
        name = "Elias Coelho",
        avatarUrl = ""
    )
}