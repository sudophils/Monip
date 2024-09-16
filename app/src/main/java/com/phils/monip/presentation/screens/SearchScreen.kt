package com.phils.monip.presentation.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.ArrowLeft
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Scan
import com.composables.icons.lucide.Search
import com.phils.monip.domain.model.SearchItem
import com.phils.monip.presentation.components.SearchItemTile
import com.phils.monip.ui.theme.Orange
import com.phils.monip.ui.theme.Purple40


@Composable
fun SearchScreen(navController: NavHostController) {
    var isVisible by remember { mutableStateOf(true) }
    var searchText by remember { mutableStateOf("") }

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
                SearchAppBar(
                    searchText = searchText,
                    onSearchTextChange = { searchText = it },
                    onNavigateUp = { navController.navigateUp() }
                )
            },
            content = { innerPadding ->
                SearchContent(
                    modifier = Modifier.padding(innerPadding),
                    searchText = searchText
                )
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onNavigateUp: () -> Unit
) {
    Box(
        modifier = Modifier
            .background(Purple40)
            .padding(horizontal = 12.dp)
            .height(110.dp),
        contentAlignment = Alignment.Center

    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Lucide.ArrowLeft,
                    contentDescription = "Navigate up",
                    tint = Color.White
                )
            }
            TextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                modifier = Modifier
                    .padding(vertical = 16.dp)
                    .clip(RoundedCornerShape(50.dp))
                    .fillMaxWidth()
                    .background(Color.White.copy())
                    .fillMaxWidth(),
                placeholder = {
                    Text(
                        "Enter the receipt number ...",
                        style = MaterialTheme.typography.bodySmall.copy(
                            color = Color.Gray,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W400
                        )
                    )
                },
                leadingIcon = {
                    Box(
                        modifier = Modifier
                            .padding(8.dp)
                    ) {
                        IconButton(
                            onClick = { },
                        ) {
                            Image(Lucide.Search, contentDescription = "")
                        }
                    }
                },
                trailingIcon = {
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
                                Image(Lucide.Scan, contentDescription = "")
                            }
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                )
            )
        }
    }

}


@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    searchText: String
) {
    val items = listOf(
        SearchItem(
            productName = "Macbook Pro M1",
            fromLocation = "Paris",
            toLocation = "UK",
            shippingNumber = "#NEJ20189934122231"
        ),
        SearchItem(
            productName = "Macbook Pro Intel",
            fromLocation = "Japan",
            toLocation = "Nigeria",
            shippingNumber = "#NEJ20389934122231"
        ),
        SearchItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20085934122231"
        ),
        SearchItem(
            productName = "Macbook Pro M2",
            fromLocation = "London",
            toLocation = "Prague",
            shippingNumber = "#NEJ24089934122231"
        ),
        SearchItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ21189934122231"
        ),
        SearchItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20089934122281"
        ),
        SearchItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20029934122231"
        ),
        SearchItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20080934122231"
        ),
    )

    val filteredItems = items.filter { item ->
        item.productName.contains(searchText, ignoreCase = true) ||
                item.fromLocation.contains(searchText, ignoreCase = true) ||
                item.toLocation.contains(searchText, ignoreCase = true) ||
                item.shippingNumber.contains(searchText, ignoreCase = true)
    }
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Spacer(
            modifier = Modifier
                .height(110.dp)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .border(
                    shape = RoundedCornerShape(
                        topStart = 8.dp,
                        topEnd = 8.dp,
                        bottomEnd = 8.dp,
                        bottomStart = 8.dp
                    ), border = BorderStroke(1.dp, color = Color.LightGray.copy(alpha = 0.5f))
                )
                .background(color = Color.White),

            ) {

            LazyColumn(
                modifier = modifier

                    .fillMaxSize()

                    .padding(8.dp),
                verticalArrangement = Arrangement.Top

            ) {
                items(filteredItems, key = { it.shippingNumber }) { item ->
                    SearchItemTile(searchItem = item, Modifier.animateItem())
                }
            }


        }
    }

}