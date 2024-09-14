package com.phils.monip.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.phils.monip.ui.navigation.AppNavHost
import com.phils.monip.ui.theme.MonipTheme
import com.phils.monip.ui.theme.Purple40

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MonipTheme {
                SetStatusBarColor(color = Purple40)
                Surface {
//                    ShippingManagementApp()
                    AppNavHost(navController = rememberNavController())
                }

            }
        }
    }
}

@Composable
private fun SetStatusBarColor(color: Color) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(color = color)
    }
}

@Preview(showBackground = true)
@Composable
fun ShippingAppPreview() {
    MonipTheme {
        ShippingManagementApp()
    }
}