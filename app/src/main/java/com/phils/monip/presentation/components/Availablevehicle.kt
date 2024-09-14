package com.phils.monip.presentation.components

import android.util.DisplayMetrics
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.phils.monip.domain.model.VehicleInfo

@Composable
fun AvailableVehicle(info: VehicleInfo) {

//    val displayMetrics = DisplayMetrics()
//    windowManager.defaultDisplay.getMetrics(displayMetrics)
    Box(
        modifier = Modifier
            .height(290.dp)
            .width(170.dp)
            .padding(10.dp)
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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(8.dp)

        ) {
            Text(
                info.freightType, style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray,
                    fontWeight = FontWeight.W400
                )
            )
            Text(
                info.rating,
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = Color.Black,
                    fontWeight = FontWeight.W700
                )
            )
            AsyncImage(
                model = info.image,
                contentDescription = null,
            )

        }

    }
}