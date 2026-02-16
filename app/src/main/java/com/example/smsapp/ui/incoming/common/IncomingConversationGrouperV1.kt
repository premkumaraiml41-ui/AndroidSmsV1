package com.example.smsapp.ui.incoming.common

import com.example.smsapp.data.SmsMessage
import com.example.smsapp.ui.incoming.model.IncomingConversation
import com.example.smsapp.utils.normalizeAddress

fun groupBySenderV1(
    messages: List<SmsMessage>,
    contactsMap: Map<String, String>
): List<IncomingConversation> {
    val grouped = messages.groupBy { normalizeAddress(it.address) }

    return grouped.map { (address, msgs) ->

        val latest = msgs.maxByOrNull { it.date.toLongOrNull() ?: 0L }!!

        IncomingConversation(
            address = contactsMap[address] ?: address,
            lastMessage = latest.body,
            lastTimestamp = latest.date.toLongOrNull() ?: 0L,
            count = msgs.size,
            messages = msgs.sortedByDescending { it.date.toLongOrNull() ?: 0L }
        )
    }
        .sortedByDescending { it.lastTimestamp }
}