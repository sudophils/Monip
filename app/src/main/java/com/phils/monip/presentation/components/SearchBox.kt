package com.phils.monip.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Scan
import com.composables.icons.lucide.Search
import com.phils.monip.ui.theme.Orange

@Composable

fun SearchBox(onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .fillMaxWidth()
            .height(55.dp)
            .background(Color.White.copy())
            .clickable {
                onClick()
            },

        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                IconButton(
                    onClick = { },
                ) {
                    Image(Lucide.Search, contentDescription = "Scan")
                }
            }
            Box(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Box(

                    modifier = Modifier
                        .width(45.dp)
                        .height(45.dp)
                        .background(color = Orange, CircleShape)
                ) {
                    IconButton(
                        onClick = { },
                    ) {
                        Image(Lucide.Scan, contentDescription = "Scan")
                    }
                }
            }
        }

    }
}