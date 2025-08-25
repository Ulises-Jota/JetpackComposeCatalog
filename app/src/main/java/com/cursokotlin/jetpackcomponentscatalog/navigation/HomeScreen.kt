package com.cursokotlin.jetpackcomponentscatalog.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(
    navigateBack: () -> Unit,
    navigateToDetail: (String) -> Unit
) {
    var text by rememberSaveable { mutableStateOf("") }
    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Red),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(text = "Home", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Row {
            TextField(
                modifier = Modifier.weight(1f),
                value = text,
                onValueChange = { text = it }
            )
            Button(
                onClick = { navigateToDetail(text) }
            ) {
                Text("Detail")
            }
        }
        Spacer(Modifier.weight(1f))
        Button(
            onClick = navigateBack
        ) {
            Text("Atrás")
        }
        Spacer(Modifier.weight(1f))
    }
}
