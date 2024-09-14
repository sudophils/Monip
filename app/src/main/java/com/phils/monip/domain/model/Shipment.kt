package com.phils.monip.domain.model


data class Shipment(
    val id: String,
    val status: String,
    val arrivalInfo: String,
    val description: String,
    val amount: Double,
    val date: String
)