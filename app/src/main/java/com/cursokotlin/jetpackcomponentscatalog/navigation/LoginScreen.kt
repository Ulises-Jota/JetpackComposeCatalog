package com.cursokotlin.jetpackcomponentscatalog.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun LoginScreen(
    navigateToDetail: () -> Unit,
    coroutineScope: CoroutineScope,
    snackbarHostState: SnackbarHostState
) {
    BackHandler {
        coroutineScope.launch {
            snackbarHostState.showSnackbar("Javi")
        }
    }

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Blue),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.weight(1f))
        Text(text = "Login", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(
            onClick = navigateToDetail
        ) {
            Text("Navegar")
        }
        Spacer(Modifier.weight(1f))
    }
}
