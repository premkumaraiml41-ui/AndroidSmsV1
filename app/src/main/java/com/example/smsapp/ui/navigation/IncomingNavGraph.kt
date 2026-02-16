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

@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.incomingGraph(
    navController: NavController,
    openDrawer: () -> Unit
) {

    composable(AppScreen.InboxIncomingV1.route) {
        IncomingScreenV1(openDrawer = openDrawer)
    }

    composable(AppScreen.InboxIncomingV2.route) {
        IncomingScreenV2(openDrawer = openDrawer)
    }

    composable(AppScreen.InboxIncomingV3.route) {
        IncomingScreenV3(
            openDrawer = openDrawer,
            navigateToSend = { phone, msg ->
                navController.navigate(
                    AppScreen.SendV3.route + "?phone=$phone&msg=$msg"
                )
            }
        )
    }

    composable(AppScreen.InboxIncomingV4.route) {
        IncomingScreenV4(
            openDrawer = openDrawer,
            navigateToSend = { phone, msg ->
                navController.navigate(
                    AppScreen.SendV3.route + "?phone=$phone&msg=$msg"
                )
            }
        )
    }
}