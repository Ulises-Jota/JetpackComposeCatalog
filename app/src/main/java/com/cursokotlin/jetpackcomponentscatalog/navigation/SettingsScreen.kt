package com.cursokotlin.jetpackcomponentscatalog.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun SettingsScreen(settingsModel: SettingsModel, navigateToHome: () -> Unit) {
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(
            text = "Settings: id: ${settingsModel.id}, darkModeEnabled: ${settingsModel.isDarkMode}",
            fontSize = 30.sp
        )
        Spacer(Modifier.weight(1f))
        Button(
            onClick = navigateToHome
        ) {
            Text("Volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}
