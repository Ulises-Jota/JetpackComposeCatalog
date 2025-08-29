package com.cursokotlin.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun MyCustomSnackbar(paddingValues: PaddingValues) {
    val snackbarState = remember { SnackbarHostState() }
    val coroutineScope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {
        Button(
            modifier = Modifier.align(Alignment.Center),
            onClick = {
                coroutineScope.launch {
                    snackbarState.showSnackbar("")
                }
            }
        ) {
            Text("Mostrar custom snackbar")
        }
        SnackbarHost(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = paddingValues.calculateBottomPadding() + 16.dp),
            hostState = snackbarState
        ) {
            CustomSnackbar()
        }
    }
}

@Composable
fun CustomSnackbar(message: String? = null) {
    Snackbar(
        containerColor = MaterialTheme.colorScheme.onTertiaryContainer,
        shape = RoundedCornerShape(25)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth(),
            ) {
                Text("Titulo")
                Spacer(modifier = Modifier.height(4.dp))
                Text("Tienes una nueva notificación${message.let { ": $it" }}")
            }
            Column(modifier = Modifier.align(Alignment.CenterEnd)) {
                Button(onClick = { /*TODO*/ }) {
                    Text("Acción")
                }
            }
        }
    }
}
