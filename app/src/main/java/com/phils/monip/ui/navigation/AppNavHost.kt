package com.phils.monip.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.phils.monip.presentation.ShippingManagementApp
import com.phils.monip.presentation.screens.SearchScreen

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
        composable(NavigationItem.SEARCH.route) {
            SearchScreen(navController)
        }
        composable(NavigationItem.HOME.route) {
            ShippingManagementApp()
        }
    }
}