package com.phils.monip.domain.model


enum class ShipmentCategory(val value: String) {
    DOCUMENT("Document"),
    GLASS("Glass"),
    LIQUID("Liquid"),
    FOOD("Food"),
    ELECTRONICS("Electronic"),
    PRODUCT("Product"),
    OTHERS("Others"),
}

fun getAllCategories(): List<ShipmentCategory> {
    return listOf(
        ShipmentCategory.DOCUMENT,
        ShipmentCategory.GLASS,
        ShipmentCategory.LIQUID,
        ShipmentCategory.FOOD,
        ShipmentCategory.PRODUCT,
        ShipmentCategory.OTHERS,
        ShipmentCategory.ELECTRONICS,
    )
}

fun getCategory(value: String): ShipmentCategory? {
    val map = ShipmentCategory.entries.associateBy(ShipmentCategory::value)
    return map[value]
}