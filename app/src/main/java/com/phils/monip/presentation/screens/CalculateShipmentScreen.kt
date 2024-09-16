package com.phils.monip.presentation.screens


import android.annotation.SuppressLint
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.HourglassBottom
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.MoveToInbox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.composables.icons.lucide.ArrowLeft
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Package
import com.phils.monip.domain.model.ShipmentCategory
import com.phils.monip.domain.model.getAllCategories
import com.phils.monip.domain.model.getCategory
import com.phils.monip.ui.theme.Orange
import com.phils.monip.ui.theme.Purple40


@Composable
fun CalculateShipmentScreen(navController: NavHostController) {
    var isVisible by remember { mutableStateOf(true) }

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
                CalculateShipmentAppBar(
                    onNavigateUp = { navController.navigateUp() }
                )
            },
            content = { innerPadding ->
                CalculateShipmentContent(
                    modifier = Modifier.padding(innerPadding)
                )
            }
        )
    }
}

@Composable
fun CalculateShipmentAppBar(onNavigateUp: () -> Unit) {
    Box(
        modifier = Modifier
            .background(Purple40)
            .padding(horizontal = 12.dp)
            .height(80.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onNavigateUp) {
                Icon(
                    imageVector = Lucide.ArrowLeft,
                    contentDescription = "Navigate up",
                    tint = Color.White
                )
            }
            Text(
                "Calculate",
                style = MaterialTheme.typography.titleLarge.copy(
                    textAlign = TextAlign.Start,
                    color = Color.White
                )
            )
        }
    }
}

@Composable
fun ShippingInputComponent(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    icon: @Composable (() -> Unit)? = null
) {

    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(55.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.Gray.copy(alpha = 0.2f)),
        contentAlignment = Alignment.Center,

        ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (icon != null) {
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                icon()
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                VerticalDivider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp),
                    color = Color.Gray.copy(alpha = .3f)
                )
            }
            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = if (icon != null) 8.dp else 0.dp, end = 8.dp),
                textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = Color.Gray
                        )
                    }
                    innerTextField()
                }
            )
        }
    }

}

@Composable
fun ShippingItemDropdownInput(
    selectedOption: String?,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    icon: @Composable (() -> Unit)? = null
) {
    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }

    val itemPosition = remember {
        mutableIntStateOf(0)
    }

    val packageCategories = listOf("Box", "Electronic", "Perishable")


    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(Color.White.copy(alpha = 0.2f))
            .clickable { isDropDownExpanded.value = true }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            if (icon != null) {
                Spacer(
                    modifier = Modifier
                        .width(24.dp)
                )
                icon()
                Spacer(
                    modifier = Modifier
                        .width(4.dp)
                )
                VerticalDivider(
                    modifier = Modifier
                        .width(1.dp)
                        .height(24.dp),
                    color = Color.Gray.copy(alpha = .3f)
                )


            }
            Text(
                text = selectedOption ?: placeholder,
                color = if (selectedOption == null) Color.Gray else Color.Black,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = if (icon != null) 8.dp else 0.dp, end = 8.dp)
            )
            IconButton(onClick = { isDropDownExpanded.value = true }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "What re you sending"
                )
            }
        }
        DropdownMenu(
            expanded = isDropDownExpanded.value,
            onDismissRequest = {
                isDropDownExpanded.value = false
            }) {
            packageCategories.forEachIndexed { index, category ->
                DropdownMenuItem(text = {
                    Text(text = category)
                },
                    onClick = {
                        isDropDownExpanded.value = false
                        itemPosition.intValue = index
                    })

            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun CalculateShipmentContent(modifier: Modifier = Modifier) {
    val shipmentsInputModifier = Modifier.padding(16.dp)
    val shipmentsDropDownModifier = Modifier.padding(horizontal = 16.dp)
    val selectedCategory: MutableState<ShipmentCategory?> = mutableStateOf(null)

    LazyColumn(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                "Destination",
                modifier = Modifier.padding(start = 24.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W800
            )
        }

        item {
            ShipmentInputContainer(modifier = shipmentsInputModifier)
        }

        item {
            Text(

                "Packaging",
                modifier = Modifier.padding(start = 24.dp, top = 16.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W800
            )
            Text(

                "What are you sending?",
                modifier = Modifier.padding(start = 24.dp, top = 2.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                fontWeight = FontWeight.W400
            )
        }

        item {
            ShipmentDropDownContainer(modifier = shipmentsDropDownModifier)
        }

        item {
            Text(
                "Categories",
                modifier = Modifier.padding(start = 24.dp),
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.W800
            )
            Text(

                "What are you sending?",
                modifier = Modifier.padding(start = 24.dp, top = 2.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = Color.Gray,
                fontWeight = FontWeight.W400
            )
        }

        item {
            CategoryChipContainer(
                categories = getAllCategories(),
                selectedCategory = selectedCategory.value,
                onSelectedChanged = {
                    selectedCategory.value = getCategory(it)
                })
        }


        item {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .padding(horizontal = 24.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Orange),
                onClick = {  }) {
                Text("Calculate")
            }
        }
    }
}


@Composable
fun ShipmentDropDownContainer(modifier: Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(65.dp)
            .border(
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp,
                    bottomStart = 8.dp
                ), border = BorderStroke(1.dp, color = Color.LightGray.copy(alpha = 0.2f))
            )
            .background(Color.White)
    ) {
        Column(modifier.padding(4.dp)) {
            ShippingItemDropdownInput(
                selectedOption = "",
                placeholder = "Select Packaging Type",
                icon = {
                    Icon(
                        imageVector = Lucide.Package,
                        contentDescription = "Packaging Type",
                        tint = Color.Gray
                    )
                }
            )
        }

    }

}

@Composable
fun ShipmentInputContainer(modifier: Modifier) {
    Box(
        modifier
            .fillMaxWidth()
            .height(300.dp)
            .border(
                shape = RoundedCornerShape(
                    topStart = 8.dp,
                    topEnd = 8.dp,
                    bottomEnd = 8.dp,
                    bottomStart = 8.dp
                ), border = BorderStroke(1.dp, color = Color.LightGray.copy(alpha = 0.2f))
            )
            .background(Color.White)
    ) {
        Column(modifier.padding(4.dp)) {
            ShippingInputComponent(
                value = "",
                onValueChange = {},
                placeholder = "Sender Location",
                icon = {
                    Icon(
                        imageVector = Icons.Default.Inbox,
                        contentDescription = "Sender Location",
                        tint = Color.Gray
                    )
                })


            ShippingInputComponent(
                value = "",
                onValueChange = {},
                placeholder = "Receiver Location",
                icon = {
                    Icon(
                        imageVector = Icons.Default.MoveToInbox,
                        contentDescription = "Receiver Location",
                        tint = Color.Gray
                    )
                })


            ShippingInputComponent(
                value = "",
                onValueChange = {},
                placeholder = "Approx. Weight",
                icon = {
                    Icon(
                        imageVector = Icons.Default.HourglassBottom,
                        contentDescription = "Approx. Weight",
                        tint = Color.Gray
                    )
                })
        }
    }
}

@Composable
fun CategoryChip(
    name: String = "Chip",
    isSelected: Boolean = false,
    onSelectionChanged: (String) -> Unit = {},
) {
    Surface(
        modifier = Modifier.padding(4.dp),
        shape = MaterialTheme.shapes.medium,
        color = if (isSelected) MaterialTheme.colorScheme.primary  else Color.LightGray
    ) {
        Row(modifier = Modifier
            .toggleable(
                value = isSelected,
                onValueChange = {
                    onSelectionChanged(name)
                }
            )
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}


@Composable
fun CategoryChipContainer(
    categories: List<ShipmentCategory> = getAllCategories(),
    selectedCategory: ShipmentCategory? = null,
    onSelectedChanged: (String) -> Unit = {},
) {
    Column(modifier = Modifier.padding(8.dp)) {
        LazyRow {
            items(categories) { it ->
                CategoryChip(
                    name = it.value,
                    isSelected = selectedCategory == it,
                    onSelectionChanged = {
                        onSelectedChanged(it)
                    },
                )
            }
        }
    }
}