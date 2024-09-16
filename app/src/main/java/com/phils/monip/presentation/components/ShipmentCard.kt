package com.phils.monip.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Package
import com.composables.icons.lucide.Timer
import com.phils.monip.domain.model.Shipment

@Composable
fun ShipmentCard(shipment: Shipment, modifier:Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .border(
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp,
                    bottomStart = 8.dp
                ), border = BorderStroke(1.dp, color = Color.LightGray.copy(alpha = 0.5f))
            )
            .background(color = Color.White)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Box(
                    modifier = Modifier
                        .width(110.dp)
                        .clip(RoundedCornerShape(100))
                        .height(30.dp)
                        .padding(vertical = 2.dp)
                        .background(color = Color.LightGray.copy(alpha = .3f))
                ) {
                    Row {
                        Icon(
                            Lucide.Timer,
                            modifier = Modifier
                                .padding(4.dp)
                                .width(16.dp)
                                .height(16.dp),
                            contentDescription = "",
                            tint = Color.Gray,
                        )

                        Text(
                            text = shipment.status,
                            style = MaterialTheme.typography.bodyMedium.copy(
                                color = Color.Black,
                            )
                        )
                    }
                }
                Text(
                    text = shipment.arrivalInfo, style = MaterialTheme.typography.titleMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W700
                    )
                )
                Text(
                    text = shipment.description, style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                    )
                )
                Row {
                    Text(text = "\$${shipment.amount} USD")
                    Spacer(
                        modifier = Modifier
                            .width(4.dp)
                    )
                    Text(text = shipment.date)
                }
            }
            Box(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
            ) {
                Icon(
                    Lucide.Package,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    contentDescription = "",
                    tint = Color.Gray,
                )
            }

        }
    }
}