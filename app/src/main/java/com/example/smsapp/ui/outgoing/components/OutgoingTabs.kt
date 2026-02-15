package com.example.smsapp.ui.outgoing.components

import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.smsapp.viewmodel.TimeGroup

@Composable
fun OutgoingTabs(
    selected: TimeGroup,
    onSelected: (TimeGroup) -> Unit
) {
    TabRow(selectedTabIndex = selected.ordinal) {
        TimeGroup.values().forEach { group ->
            Tab(
                selected = selected == group,
                onClick = { onSelected(group) },
                text = { Text(group.name) }
            )
        }
    }
}