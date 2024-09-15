package com.phils.monip.presentation.components

import android.util.DisplayMetrics
import android.view.WindowManager
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.composables.icons.lucide.Gift
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Plus
import com.phils.monip.domain.model.TrackingInfo
import com.phils.monip.ui.theme.Orange


@Composable
fun ShipmentTrackingCard(shipmentInfo: TrackingInfo) {

    Box(
        modifier = Modifier
            .height(290.dp)
            .width(420.dp)
            .padding(16.dp)
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
        Column {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .padding(8.dp)
                ) {
                    Text(
                        "Shipment number", style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Text(
                        shipmentInfo.shipmentNumber,
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color.Black,
                            fontWeight = FontWeight.W700
                        )
                    )
                }
                Icon(
                    shipmentInfo.icon,
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp),
                    contentDescription = "",
                    tint = Color.Blue,
                )
            }
            HorizontalDivider(
                color = Color.LightGray.copy(alpha = 0.3f),
                modifier = Modifier.height(0.5.dp)
            )

            TrackingItemRow(info = shipmentInfo)
            HorizontalDivider(
                color = Color.LightGray.copy(alpha = 0.3f),
                modifier = Modifier.height(0.5.dp)
            )
            AddStopButtonRow()
        }

    }
}


@Composable
fun TrackingItemRow(info: TrackingInfo) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(Color.Yellow, CircleShape)
            ) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        Lucide.Gift,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        contentDescription = "",
                        tint = Color.Blue,
                    )
                }
            }

            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    "Sender", style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.W400
                    )
                )
                Text(
                    info.sender,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        fontSize = 12.sp
                    )
                )
            }
            Spacer(modifier = Modifier.width(70.dp))
            Column(

                horizontalAlignment = Alignment.Start
            ) {
                Text(
                    "Time", style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.W400
                    )
                )
                Text(
                    info.time,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        fontSize = 12.sp
                    )
                )
            }


        }

        // receiver row

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(Color.Green, CircleShape)
            ) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        Lucide.Gift,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        contentDescription = "",
                        tint = Color.Blue,
                    )
                }
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    "Receiver", style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.W400
                    )
                )
                Text(
                    info.receiver,
                    style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        fontSize = 12.sp
                    )
                )
            }

            Spacer(modifier = Modifier.width(70.dp))

            Column(horizontalAlignment = Alignment.Start) {
                Text(
                    "Status", style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Gray,
                        fontWeight = FontWeight.W400
                    )
                )
                Text(
                    info.status,
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W500,
                        fontSize = 14.sp
                    )
                )
            }

        }
        Spacer(modifier = Modifier.height(8.dp))
    }

}

@Composable
fun AddStopButtonRow() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(
            Lucide.Plus,
            modifier = Modifier
                .width(20.dp)
                .height(20.dp),
            contentDescription = "",
            tint = Orange,
        )
        Text(
            "Add Stop",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = Orange,
                fontWeight = FontWeight.W600
            ),
            modifier = Modifier.clickable {
                print("add stop")
            },
        )

    }
}