package com.example.smsapp.ui.outgoing.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.smsapp.data.SmsMessage
import com.example.smsapp.viewmodel.TimeGroup

@Composable
fun OutgoingMessageList(
    messages: List<SmsMessage>,
    group: TimeGroup
){
    if(messages.isEmpty()){
        OutgoingEmptyState(group)
        return
    }

    LazyColumn {
        items(messages){ sms ->
            OutgoingMessageItem(sms)
        }
    }
}