package com.bignerdranch.android.chind_de_compose.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bignerdranch.android.chind_de_compose.screens.EnterScreen
import com.bignerdranch.android.chind_de_compose.screens.FlashScreen
import com.bignerdranch.android.chind_de_compose.screens.MainScreen
import com.bignerdranch.android.chind_de_compose.screens.ProfileScreen

@Composable
fun SetUp(con: NavHostController) {
    NavHost(navController = con, startDestination = NavigationForScreens.FlashScreen.rotate){
        composable(NavigationForScreens.FlashScreen.rotate){
            FlashScreen(controller = con)
        }
        composable(NavigationForScreens.Main.rotate)
        {
            MainScreen(controller = con)
        }
        composable(NavigationForScreens.Profile.rotate){
            ProfileScreen(controller = con)
        }
        composable(NavigationForScreens.Enter.rotate){
            EnterScreen(controller = con)
        }
    }
}
