package com.buzzchat.ui.stubs.user

import com.buzzchat.ui.features.user.model.User
import com.eliascoelho911.common.general.generateId
import kotlin.random.Random

object UserStub {
    fun getUsers(): List<User> = listOf(
        User(
            username = generateId(),
            fullName = "Lucas Ribeiro",
            avatarUrl = ""
        ),
        User(
            username = generateId(),
            fullName = "João Pedro",
            avatarUrl = ""
        ),
        User(
            username = generateId(),
            fullName = "Maria Eduarda",
            avatarUrl = ""
        ),
        User(
            username = generateId(),
            fullName = "Ana Clara",
            avatarUrl = ""
        ),
    )

    fun getRandomUser(): User = getUsers().random()

    fun getRandomUsers(): List<User> =
        getUsers().shuffled().take(Random.nextInt(1, getUsers().size))

    fun getLoggedUser(): User = User(
        username = generateId(),
        fullName = "Elias Coelho",
        avatarUrl = ""
    )
}