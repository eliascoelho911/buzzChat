package com.buzzchat.ui.features.chat.usecases

import com.buzzchat.ui.features.chat.model.Chat
import com.buzzchat.ui.features.chat.model.Message
import com.buzzchat.ui.features.chat.repository.ChatRepository
import com.eliascoelho911.common.date.getMillis
import com.eliascoelho911.common.general.generateId
import io.mockk.every
import io.mockk.mockk
import org.joda.time.LocalDateTime
import org.junit.Test
import kotlin.test.assertEquals

class GetAllChatsUseCaseTest {
    private val repository = mockk<ChatRepository>()

    private val getAllChatsUseCase = GetAllChatsUseCase(repository)

    private val yesterdayMessage: Message = Message(
        id = generateId(),
        content = "Hello",
        sender = mockk(),
        createAt = LocalDateTime.now().minusDays(1).getMillis(),
        isRead = true,
        isDelivered = true
    )

    private val todayMessage: Message = Message(
        id = generateId(),
        content = "Hello",
        sender = mockk(),
        createAt = LocalDateTime.now().getMillis(),
        isRead = true,
        isDelivered = true
    )

    private val chatWithYesterdayMessage: Chat = Chat(
        id = generateId(),
        loggedUser = mockk(),
        otherUser = mockk(),
        otherUserIsTyping = false,
        messages = listOf(yesterdayMessage)
    )

    private val chatWithTodayMessage: Chat = Chat(
        id = generateId(),
        loggedUser = mockk(),
        otherUser = mockk(),
        otherUserIsTyping = false,
        messages = listOf(todayMessage)
    )

    private val chatWithoutMessages: Chat = Chat(
        id = generateId(),
        loggedUser = mockk(),
        otherUser = mockk(),
        otherUserIsTyping = false,
        messages = emptyList()
    )

    @Test
    fun `invoke() should return a list of chats`() {
        every { repository.getAllChats() } returns listOf(
            chatWithYesterdayMessage,
            chatWithTodayMessage,
            chatWithoutMessages
        )

        val expected = listOf(
            chatWithTodayMessage,
            chatWithYesterdayMessage
        )

        val result = getAllChatsUseCase()

        assertEquals(expected, result)
    }
}