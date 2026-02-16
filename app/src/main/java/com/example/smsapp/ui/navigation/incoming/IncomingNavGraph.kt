package com.example.smsapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.smsapp.AppScreen
import com.example.smsapp.ui.incoming.v1.IncomingScreenV1
import com.example.smsapp.ui.incoming.v2.IncomingScreenV2
import com.example.smsapp.ui.incoming.v3.IncomingScreenV3
import com.example.smsapp.ui.incoming.v4.IncomingScreenV4
import com.example.smsapp.ui.incoming.v5.IncomingScreenV5
import androidx.navigation.navArgument
import com.example.smsapp.ui.incoming.v5.IncomingConversationThreadScreenV5
import com.example.smsapp.ui.incoming.v6.IncomingConversationThreadScreenV6
import com.example.smsapp.ui.incoming.v6.IncomingScreenV6

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingGraph(
    navController: NavController,
    openDrawer: () -> Unit
) {
    incomingListGraph(navController, openDrawer)
    incomingThreadGraph(navController)
}