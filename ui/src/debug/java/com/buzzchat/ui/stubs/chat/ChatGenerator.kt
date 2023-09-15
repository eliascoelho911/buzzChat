package com.buzzchat.ui.stubs.chat

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.stubs.chat.message.MessageGenerator.generateLoggedUserMessage
import com.buzzchat.ui.stubs.chat.message.MessageGenerator.generateOtherUserMessage
import com.buzzchat.ui.stubs.user.UserStub
import com.eliascoelho911.common.general.generateId
import kotlin.random.Random

object ChatGenerator {
    fun privateChat(messages: Int = Random.nextInt(15)) = Chat(
        id = generateId(),
        messages = (0..messages).map {
            if (Random.nextBoolean()) generateLoggedUserMessage() else generateOtherUserMessage()
        },
        loggedUser = UserStub.getLoggedUser(),
        otherUsers = UserStub.getRandomUsers(),
    )
}