package com.phils.monip.presentation.screens


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.SecondaryIndicator
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.ArrowLeft
import com.composables.icons.lucide.Lucide
import com.phils.monip.domain.model.Shipment
import com.phils.monip.presentation.components.ShipmentCard
import com.phils.monip.ui.theme.Purple40

@Composable
fun ShipmentScreen(navController: NavHostController) {
    var isVisible by remember { mutableStateOf(true) }
    var selectedTab by remember { mutableStateOf(ShipmentStatus.All) }

    LaunchedEffect(Unit) {
        isVisible = true
    }
    AnimatedVisibility(
        visible = isVisible,
        enter = fadeIn(),
        exit = fadeOut(animationSpec = tween(durationMillis = 300))
    ) {
        Scaffold(
            topBar = {
                ShipmentAppBar(
                    onNavigateUp = { navController.navigateUp() }
                )
            },
            content = { innerPadding ->
                ShipmentContent(
                    modifier = Modifier.padding(innerPadding),
                    selectedTab = selectedTab,
                    onTabSelected = { selectedTab = it }
                )
            }
        )
    }
}

@Composable
fun ShipmentAppBar(
    onNavigateUp: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Purple40)
            .padding(horizontal = 12.dp)
            .height(80.dp),
        contentAlignment = Alignment.Center

    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Lucide.ArrowLeft,
                    contentDescription = "Navigate up",
                    tint = Color.White
                )
            }
            Text(
                "Shipments history",
                style = MaterialTheme.typography.titleLarge.copy(
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            )

        }
    }
}

@Composable
fun ShipmentContent(
    modifier: Modifier = Modifier,
    selectedTab: ShipmentStatus,
    onTabSelected: (ShipmentStatus) -> Unit
) {
    // Shipment List
    val shipments = listOf(
        Shipment(
            "1",
            ShipmentStatus.InProgress.toString(),
            "Arriving today",
            "You can navigate between composables \nwhile taking advantage",
            20.0,
            "Sep 15, 2024"
        ),
        Shipment(
            "2",
            ShipmentStatus.Completed.toString(),
            "Delivered",
            "You can navigate between composables\n while taking advantage",
            15.0,
            "Sep 1, 2024"
        ),
        Shipment(
            "3",
            ShipmentStatus.Pending.toString(),
            "Pending delivery",
            "You can navigate between composables \nwhile taking advantage",
            30.0,
            "Sep 5, 2024"
        ),

        Shipment(
            "4",
            ShipmentStatus.Cancelled.toString(),
            "Cancelled",
            "You can navigate between composables\n while taking advantage",
            10.0,
            "Sep 10, 2024"
        ),
        Shipment(
            "5",
            ShipmentStatus.Completed.toString(),
            "Delivered",
            "You can navigate between composables\n while taking advantage",
            10.0,
            "Sep 10, 2024"
        ),
        Shipment(
            "6",
            ShipmentStatus.InProgress.toString(),
            "Arriving today",
            "You can navigate between composables\n while taking advantage",
            10.0,
            "Sep 10, 2024"
        )

    )

    Column(modifier = modifier.fillMaxSize()) {
        ShipmentTabRow(
            selectedTab = selectedTab,
            shipments = shipments,
            onTabSelected = onTabSelected
        )


        val filteredShipments = shipments.filter { shipment ->
            selectedTab == ShipmentStatus.All || shipment.status == selectedTab.toString()
        }

        LazyColumn(
            modifier = Modifier
                .padding(16.dp)

        ) {

            items(
                filteredShipments,
                key = { it.id })
            { shipment ->
                ShipmentCard(shipment, Modifier.animateItem())
            }
        }
    }
}


@Composable
fun ShipmentTabRow(
    selectedTab: ShipmentStatus,
    onTabSelected: (ShipmentStatus) -> Unit,
    shipments: List<Shipment>
) {
    val tabs = ShipmentStatus.entries.toTypedArray()

    ScrollableTabRow(
        selectedTabIndex = tabs.indexOf(selectedTab),
        containerColor = Purple40,
        contentColor = Color.Black,
        indicator = { tabPositions ->
            SecondaryIndicator(
                Modifier.tabIndicatorOffset(tabPositions[tabs.indexOf(selectedTab)]),
                color = Color(0xFFFFA500)
            )
        }
    ) {
        tabs.forEach { status ->
            val count = when (status) {
                ShipmentStatus.All -> shipments.size
                else -> shipments.count { it.status == status.toString() }
            }
            Tab(
                selectedContentColor = Color.White,
                unselectedContentColor = Color.LightGray,
                text = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(status.name)
                        if (selectedTab == status && count > 0) {
                            Spacer(modifier = Modifier.width(4.dp))
                            Box(
                                modifier = Modifier
                                    .size(20.dp)
                                    .background(Color(0xFFFFA500), shape = CircleShape),
                                contentAlignment = Alignment.Center
                            ) {
                                Text(
                                    text = count.toString(),
                                    color = Color.White,
                                    fontSize = 12.sp
                                )
                            }
                        }
                    }
                },
                selected = selectedTab == status,
                onClick = { onTabSelected(status) }
            )
        }
    }
}


enum class ShipmentStatus {
    All, Completed, InProgress, Pending, Cancelled
}

