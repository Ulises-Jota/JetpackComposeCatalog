package com.cursokotlin.jetpackcomponentscatalog.navigation

import kotlinx.serialization.Serializable

@Serializable
object Login

@Serializable
object Home

@Serializable
data class Detail(val id: String)

@Serializable
data class Settings(val settingsModel: SettingsModel)
