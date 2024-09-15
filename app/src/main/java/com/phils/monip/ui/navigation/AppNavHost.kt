package com.phils.monip.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.phils.monip.presentation.screens.CalculateShipmentScreen
import com.phils.monip.presentation.screens.HomeScreen
import com.phils.monip.presentation.screens.ProfileScreen
import com.phils.monip.presentation.screens.SearchScreen
import com.phils.monip.presentation.screens.ShipmentScreen

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = NavigationItem.HOME.route,

    ) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(NavigationItem.HOME.route) { HomeScreen(navController) }
        composable(NavigationItem.CALCULATE.route) { CalculateShipmentScreen() }
        composable(NavigationItem.SHIPMENT.route) { ShipmentScreen() }
        composable(NavigationItem.PROFILE.route) { ProfileScreen() }
        composable(NavigationItem.SEARCH.route) { SearchScreen(navController) }
    }
}