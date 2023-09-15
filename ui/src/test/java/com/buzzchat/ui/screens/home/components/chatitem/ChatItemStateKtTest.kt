package com.buzzchat.ui.screens.home.components.chatitem

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.model.Message
import com.buzzchat.ui.features.user.model.User
import org.junit.Test
import kotlin.test.assertEquals

class ChatItemStateKtTest {

    private val loggedUser = User(
        username = "user0",
        fullName = "User 0",
        avatarUrl = "",
    )
    private val otherUser = User(
        username = "user1",
        fullName = "User 1",
        avatarUrl = "",
    )

    private val chat = Chat(
        id = "chat0",
        messages = listOf(
            Message(
                id = "message0",
                sender = loggedUser,
                content = "Hello",
                createAt = 0,
                isRead = true,
                isDelivered = true,
            ),
            Message(
                id = "message1",
                sender = otherUser,
                content = "How are you?",
                createAt = 0,
                isRead = true,
                isDelivered = true,
            ),
            Message(
                id = "message2",
                sender = otherUser,
                content = "I'm fine, thanks",
                createAt = 0,
                isRead = false,
                isDelivered = true,
            ),
        ),
        loggedUser = loggedUser,
        otherUser = otherUser,
        otherUserIsTyping = false,
    )

    @Test
    fun `toState() should return a ChatItemState`() {
        val expected = ChatItemState(
            id = chat.id,
            avatarUrl = otherUser.avatarUrl,
            chatName = otherUser.fullName,
            lastMessage = chat.messages.last().content,
            lastMessageMillis = chat.messages.last().createAt,
            unreadMessages = 1,
            isTyping = false,
        )
        val result = chat.toState()

        assertEquals(expected, result)
    }
}