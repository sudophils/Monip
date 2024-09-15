package com.phils.monip.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.ArrowLeft
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Scan
import com.composables.icons.lucide.Search
import com.phils.monip.ui.theme.Orange
import com.phils.monip.ui.theme.Purple40
import com.phils.monip.ui.theme.Purple80


@Composable
fun SearchScreen(navController: NavHostController) {
    var searchText by remember { mutableStateOf("") }

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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    searchText: String,
    onSearchTextChange: (String) -> Unit,
    onNavigateUp: () -> Unit
) {
    TopAppBar(
//        colors = TopAppBarColors(Purple40),
        navigationIcon = {
            IconButton(onClick = onNavigateUp) {
                Icon(imageVector = Lucide.ArrowLeft, contentDescription = "Navigate up")
            }
        },
        title = {
            TextField(
                value = searchText,
                onValueChange = onSearchTextChange,
                modifier = Modifier
                    .clip(RoundedCornerShape(50.dp))
                    .fillMaxWidth()
                    .background(Color.Gray.copy(alpha = 0.2f))
                    .fillMaxWidth(),
                placeholder = {
                    Text("Search")
                },
                leadingIcon = {
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
                                Image(Lucide.Scan, contentDescription = "Scan")
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
    )
}


@Composable
fun SearchContent(
    modifier: Modifier = Modifier,
    searchText: String
) {

    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
//        items(items) { item ->
//            // Render your search list items
//        }
    }
}