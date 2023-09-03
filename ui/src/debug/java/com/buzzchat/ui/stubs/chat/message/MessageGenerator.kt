package com.buzzchat.ui.stubs.chat.message

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import com.buzzchat.ui.features.chat.model.Message
import com.buzzchat.ui.features.user.model.User
import com.buzzchat.ui.stubs.user.UserStub
import com.eliascoelho911.common.date.getMillis
import com.eliascoelho911.common.general.generateId
import org.joda.time.LocalDateTime
import kotlin.random.Random

object MessageGenerator {

    fun generateLoggedUserMessage() = generateMessage(sender = UserStub.getLoggedUser())

    fun generateOtherUserMessage() = generateMessage(sender = UserStub.getRandomUser())

    private fun generateMessage(
        sender: User,
        content: String = generateMessageContent(),
        createAt: Long = generateCreateAtDate().getMillis(),
    ) = run {
        val isRead = Random.nextBoolean()
        Message(
            generateId(),
            sender = sender,
            content = content,
            createAt = createAt,
            isRead = isRead,
            isDelivered = if (isRead) true else Random.nextBoolean()
        )
    }

    private fun generateCreateAtDate(): LocalDateTime = LocalDateTime.now()
        .minusMinutes(Random.nextInt(60)).minusHours(Random.nextInt(72))

    private fun generateMessageContent(words: Int = Random.nextInt(50)): String {
        return LoremIpsum(words).values.joinToString(" ")
    }
}