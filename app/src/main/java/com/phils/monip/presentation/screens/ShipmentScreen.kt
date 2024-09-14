package com.phils.monip.presentation.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.phils.monip.domain.model.Shipment
import com.phils.monip.presentation.components.ShipmentCard

@Composable
fun ShipmentScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Shipments", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))
        // Sample shipment data
        val shipments = listOf(
            Shipment("1", "In Progress", "Arriving today", "Package 1", 20.0, "2024-09-11"),
            Shipment("2", "Completed", "Delivered", "Package 2", 15.0, "2024-09-10")
        )
        shipments.forEach { shipment ->
            ShipmentCard(shipment)
        }
    }
}

