package com.phils.monip.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.phils.monip.domain.model.SearchListItem

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun SearchScreen(navController: NavController) {
    var presses by remember { mutableIntStateOf(0) }

    val items = listOf(
        SearchListItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20089934122231"
        ),
        SearchListItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20089934122231"
        ),
        SearchListItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20089934122231"
        ),
        SearchListItem(
            productName = "Macbook Pro M2",
            fromLocation = "Paris",
            toLocation = "Morocco",
            shippingNumber = "#NEJ20089934122231"
        ),
    )

    Scaffold(topBar = {
        TopAppBar(
            colors = topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
            title = {
                Text("Top app bar")
            })
    }) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {

        }

    }
}