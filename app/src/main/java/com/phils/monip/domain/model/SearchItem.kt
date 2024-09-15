package com.phils.monip.domain.model

data class SearchItem(
    val productName: String,
    val shippingNumber: String,
    val fromLocation: String,
    val toLocation: String
)
