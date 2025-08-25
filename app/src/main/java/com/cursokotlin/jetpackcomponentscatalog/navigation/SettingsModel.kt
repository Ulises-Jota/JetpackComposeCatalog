package com.cursokotlin.jetpackcomponentscatalog.navigation

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
data class SettingsModel(
    val id: String,
    val isDarkMode: Boolean
) : Parcelable
