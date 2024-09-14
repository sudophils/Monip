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
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.composables.icons.lucide.Calculator
import com.composables.icons.lucide.House
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Ship
import com.composables.icons.lucide.User
import com.phils.monip.presentation.screens.CalculateShipmentScreen
import com.phils.monip.presentation.screens.HomeScreen
import com.phils.monip.presentation.screens.ProfileScreen
import com.phils.monip.presentation.screens.ShipmentScreen
import java.util.Locale


@Composable
fun ShippingManagementApp() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomNavigationBar(navController) }
    ) { innerPadding ->
        NavHost(navController, startDestination = "home", Modifier.padding(innerPadding)) {
            composable("home") { HomeScreen() }
            composable("calculate") { CalculateShipmentScreen() }
            composable("shipment") { ShipmentScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val currentRoute = currentRoute(navController)
    NavigationBar {
        val items = listOf(
            NavigationItem("home", Lucide.House ),
            NavigationItem("calculate", Lucide.Calculator),
            NavigationItem("shipment", Lucide.Ship ),
            NavigationItem("profile", Lucide.User)
        )
        items.forEach { screen ->
            NavigationBarItem(
                icon = { Icon(imageVector = screen.icon, contentDescription = null) },

                label = {
                    Text(screen.route.replaceFirstChar {
                        if (it.isLowerCase()) it.titlecase(
                            Locale.ROOT
                        ) else it.toString()
                    })
                },
                selected = currentRoute == screen.route,
                onClick = { navController.navigate(screen.route) }
            )
        }
    }
}


@Composable
fun currentRoute(navController: NavController): String? {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    return navBackStackEntry?.destination?.route
}

data class NavigationItem(val route: String, val icon: ImageVector)
