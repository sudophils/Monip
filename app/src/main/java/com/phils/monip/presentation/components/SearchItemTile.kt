package com.phils.monip.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
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
import com.composables.icons.lucide.ArrowRight
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Package
import com.phils.monip.domain.model.SearchItem
import com.phils.monip.ui.theme.Purple40

@Composable
fun SearchItemTile(searchItem: SearchItem) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .width(40.dp)
                    .height(40.dp)
                    .background(Purple40, CircleShape)
            ) {
                IconButton(
                    onClick = { },
                ) {
                    Icon(
                        Lucide.Package,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        contentDescription = "",
                        tint = Color.White,
                    )
                }
            }

            Column(
                modifier = Modifier
                    .padding(8.dp)
            ) {
                Text(
                    searchItem.productName, style = MaterialTheme.typography.bodyLarge.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.W700


                    )
                )
                Row {
                    Text(
                        searchItem.shippingNumber,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Text(
                        " | ",
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Text(
                        searchItem.fromLocation,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        )
                    )
                    Icon(
                        Lucide.ArrowRight,
                        modifier = Modifier
                            .width(20.dp)
                            .height(20.dp),
                        contentDescription = "",
                        tint = Color.Gray,
                    )
                    Text(
                        searchItem.toLocation,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = Color.Gray,
                            fontWeight = FontWeight.W400
                        )
                    )
                }
            }


        }
        HorizontalDivider(
            color = Color.LightGray.copy(alpha = 0.3f),
            modifier = Modifier.height(0.5.dp)
        )
    }
}