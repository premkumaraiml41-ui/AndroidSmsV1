package com.example.smsapp.ui.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.smsapp.ui.incoming.v5.IncomingConversationThreadScreenV5
import com.example.smsapp.ui.incoming.v6.IncomingConversationThreadScreenV6

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingThreadGraph(
    navController: NavController
) {

    composable(
        route = "incoming_v5_thread?address={address}",
        arguments = listOf(
            navArgument("address") { defaultValue = "" }
        )
    ) { backStack ->

        val address = backStack.arguments?.getString("address") ?: ""

        IncomingConversationThreadScreenV5(
            address = address,
            openDrawer = { navController.popBackStack() }
        )
    }

    composable(
        route = "incoming_v6_thread?address={address}",
        arguments = listOf(
            navArgument("address") { defaultValue = "" }
        )
    ) { backStack ->

        val address = backStack.arguments?.getString("address") ?: ""

        IncomingConversationThreadScreenV6(
            address = address,
            openDrawer = { navController.popBackStack() }
        )
    }
}