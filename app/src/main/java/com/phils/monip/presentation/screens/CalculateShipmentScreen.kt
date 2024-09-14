package com.phils.monip.presentation.screens


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CalculateShipmentScreen() {
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Calculate Shipping Cost", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        // Input fields for calculation
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Sender Location") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Receiver Location") })
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(value = "", onValueChange = {}, label = { Text("Approx Weight (kg)") })
        Spacer(modifier = Modifier.height(8.dp))

        // Packaging Type Dropdown
        var packagingType = remember { "Box" }
        OutlinedTextField(value = packagingType, onValueChange = { packagingType = it }, label = { Text("Packaging Type") })
        Spacer(modifier = Modifier.height(8.dp))

        // Category Dropdown
        var category = remember { "Document" }
        OutlinedTextField(value = category, onValueChange = { category = it }, label = { Text("Category") })
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { /* Calculate logic */ }) {
            Text("Calculate")
        }
    }
}