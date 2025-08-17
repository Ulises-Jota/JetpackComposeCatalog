package com.cursokotlin.jetpackcomponentscatalog.utils

data class CheckInfo(
    val title: String,
    var selected: Boolean = false,
    var onCheckedChange: (Boolean) -> Unit
)