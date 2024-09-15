package com.phils.monip.presentation


import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.composables.icons.lucide.Calculator
import com.composables.icons.lucide.House
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Ship
import com.composables.icons.lucide.User
import com.phils.monip.ui.navigation.AppNavHost
import java.util.Locale


@Composable
fun ShippingManagementApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        AppNavHost(
            navController = navController,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = currentRoute(navController)
    NavigationBar {
        val items = listOf(
            BottomNavigationItem.HOME,
            BottomNavigationItem.CALCULATE,
            BottomNavigationItem.SHIPMENT,
            BottomNavigationItem.PROFILE
        )
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },
                label = {
                    Text(screen.route.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
                    })
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

sealed class BottomNavigationItem(val route: String, val icon: ImageVector) {
    data object HOME : BottomNavigationItem("home", Lucide.House)
    data object CALCULATE : BottomNavigationItem("calculate", Lucide.Calculator)
    data object SHIPMENT : BottomNavigationItem("shipment", Lucide.Ship)
    data object PROFILE : BottomNavigationItem("profile", Lucide.User)
}
