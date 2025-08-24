package com.cursokotlin.jetpackcomponentscatalog.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.weight(1f))
        Text(text = "Login", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(
            onClick = {

            }
        ) {
            Text("Navegar")
        }
        Spacer(Modifier.weight(1f))
    }
}
