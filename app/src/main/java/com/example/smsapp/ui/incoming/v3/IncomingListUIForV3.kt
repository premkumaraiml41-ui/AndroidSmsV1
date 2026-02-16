package com.example.smsapp.ui.incoming.v3

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.smsapp.data.SmsMessage
import androidx.compose.material.icons.filled.Send
import com.example.smsapp.ui.incoming.common.IncomingEmptyState

@Composable
fun IncomingListUIForV3(
    messages: List<SmsMessage>,
    modifier: Modifier = Modifier,
    onOpenClick: (SmsMessage) -> Unit
) {

    if (messages.isEmpty()) {
        IncomingEmptyState()
        return
    }

    LazyColumn(modifier = modifier) {
        items(messages) { sms ->

            Row(
                modifier = Modifier
                    .padding(12.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Column(Modifier.weight(1f)) {

                    Text(sms.address, style = MaterialTheme.typography.titleMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(sms.body, style = MaterialTheme.typography.bodyMedium)
                    Spacer(Modifier.height(4.dp))
                    Text(sms.date, style = MaterialTheme.typography.labelSmall)
                }

                IconButton(onClick = { onOpenClick(sms) }) {
                    Icon(Icons.Default.Send, contentDescription = "Reply")
                }
            }
        }
    }
}