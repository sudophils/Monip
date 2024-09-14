package com.phils.monip.domain.model

import androidx.compose.ui.graphics.vector.ImageVector

data class TrackingInfo(
    val shipmentNumber: String,
    val icon: ImageVector,
    val sender: String,
    val receiver: String,
    val time: String,
    val status: String
)
