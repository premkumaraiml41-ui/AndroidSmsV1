package com.example.smsapp.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.smsapp.AppScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun AppDrawer(
    navController: NavHostController,
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable () -> Unit
) {
    var inboxExpanded by remember { mutableStateOf(false) }

    val currentRoute =
        navController.currentBackStackEntryAsState().value
            ?.destination?.route ?: ""

    LaunchedEffect(currentRoute) {
        if (currentRoute == AppScreen.Send.route) {
            inboxExpanded = false
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {

                // Header
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(24.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.size(64.dp)
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Text(
                        text = "KeshavSoft",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onPrimary
                    )

                    Text(
                        text = "+91 98481 63021",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onPrimary.copy(alpha = 0.8f)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Send SMS
                NavigationDrawerItem(
                    label = { Text("Send SMS") },
                    selected = currentRoute == AppScreen.Send.route,
                    onClick = {
                        navController.navigate(AppScreen.Send.route)
                        scope.launch { drawerState.close() }
                    }
                )

                // Inbox Parent
                NavigationDrawerItem(
                    label = { Text("Inbox") },
                    selected = false,
                    onClick = { inboxExpanded = !inboxExpanded },
                    icon = {
                        Icon(
                            imageVector = if (inboxExpanded)
                                Icons.Default.ExpandLess
                            else
                                Icons.Default.ExpandMore,
                            contentDescription = null
                        )
                    }
                )

                if (inboxExpanded) {

                    NavigationDrawerItem(
                        label = { Text("Inbox V1") },
                        selected = currentRoute == AppScreen.InboxV1.route,
                        onClick = {
                            navController.navigate(AppScreen.InboxV1.route)
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(start = 24.dp)
                    )

                    NavigationDrawerItem(
                        label = { Text("Inbox V2") },
                        selected = currentRoute == AppScreen.InboxV2.route,
                        onClick = {
                            navController.navigate(AppScreen.InboxV2.route)
                            scope.launch { drawerState.close() }
                        },
                        modifier = Modifier.padding(start = 24.dp)
                    )
                }
            }
        }
    ) {
        content()
    }
}