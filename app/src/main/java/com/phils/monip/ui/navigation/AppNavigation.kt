package com.phils.monip.ui.navigation

enum class Screen {
    HOME,
    SEARCH,
    CALCULATE,
    SHIPMENT,
    PROFILE,
}
sealed class NavigationItem(val route: String) {
    data object HOME : NavigationItem(Screen.HOME.name)
    data object SEARCH : NavigationItem(Screen.SEARCH.name)
    data object CALCULATE : NavigationItem(Screen.CALCULATE.name)
    data object SHIPMENT : NavigationItem(Screen.SHIPMENT.name)
    data object PROFILE : NavigationItem(Screen.PROFILE.name)
}
