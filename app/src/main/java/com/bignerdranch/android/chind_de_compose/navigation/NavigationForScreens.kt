package com.bignerdranch.android.chind_de_compose.navigation

sealed class NavigationForScreens (val rotate: String) {
    object FlashScreen : NavigationForScreens("flash")
    object Main : NavigationForScreens("main")
    object Profile : NavigationForScreens("prof")
}