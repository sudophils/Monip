package com.phils.monip.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Truck
import com.phils.monip.domain.model.TrackingInfo
import com.phils.monip.domain.model.VehicleInfo
import com.phils.monip.presentation.components.AvailableVehicle
import com.phils.monip.presentation.components.HomeTopHeader
import com.phils.monip.presentation.components.ShipmentTrackingCard

@Composable
fun HomeScreen(navController: NavHostController) {

    val info = TrackingInfo(
        shipmentNumber = "NEJ20089934122231",
        icon = Lucide.Truck,
        receiver = "Chicago 6534",
        sender = "Atlanta, 2543",
        time = "2 days - 3 days",
        status = "Waiting to collect"
    )
    val freights = listOf(
        VehicleInfo(
            freightType = "Ocean Freight", rating = "International",
            image =
            "https://atlas-content-cdn.pixelsquid.com/stock-images/delivery-truck-box-Av8vKM7-600.jpg"
        ),
        VehicleInfo(
            freightType = "Ocean Freight", rating = "Local",
            image =
            "https://atlas-content-cdn.pixelsquid.com/stock-images/delivery-truck-box-Av8vKM7-600.jpg"
        ),
        VehicleInfo(
            freightType = "Ocean Freight", rating = "International",
            image =
            "https://img.freepik.com/free-psd/psd-isolated-box-truck-template_1409-3473.jpg"
        ),
    )

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {

        HomeTopHeader(navController)
        Text(
            "Track",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 24.sp)
        )
        ShipmentTrackingCard(shipmentInfo = info)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            "Available Vehicles",
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp),
            style = TextStyle(fontSize = 24.sp)
        )
        LazyRow {
            freights.forEach {
                item {
                    AvailableVehicle(info = it)
                }
            }
        }


    }
}



