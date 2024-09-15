package com.phils.monip.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.ArrowDown
import com.composables.icons.lucide.Bell
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Send
import com.composables.icons.lucide.Users
import com.phils.monip.ui.navigation.NavigationItem
import com.phils.monip.ui.theme.Purple40

@Composable
fun HomeTopHeader(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(color = Purple40)
            .height(180.dp)
            .padding(6.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier

                        .background(Color.LightGray, CircleShape)
                ) {

                    IconButton(
                        onClick = { },
                    ) {

                        Image(Lucide.Users, contentDescription = "Scan")
                    }
                }
                Column(horizontalAlignment = Alignment.Start) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Icon(
                            Lucide.Send,
                            modifier = Modifier.width(14.dp),
                            contentDescription = "",
                            tint = Color.White,
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = "Your location",
                            style = MaterialTheme.typography.bodyMedium.copy(color = Color.LightGray)
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "Weitheimer, Illinois",
                            style = MaterialTheme.typography.titleMedium.copy(color = Color.White)
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            Lucide.ArrowDown,
                            modifier = Modifier.width(19.dp),
                            contentDescription = "toggle",
                            tint = Color.White,
                        )
                    }
                    Spacer(modifier = Modifier.height(2.dp))
                }
                Spacer(modifier = Modifier.width(4.dp))
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                        .background(Color.White, CircleShape)
                ) {
                    IconButton(
                        onClick = { },
                    ) {
                        Image(Lucide.Bell, contentDescription = "notification")
                    }
                }
            }
            Spacer(Modifier.height(24.dp))
            SearchBox(onNavigateUp = {
                navController.navigate(NavigationItem.SEARCH.route)
            })
            Spacer(Modifier.height(20.dp))
        }
    }
}