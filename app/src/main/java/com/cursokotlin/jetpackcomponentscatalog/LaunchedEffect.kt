package com.cursokotlin.jetpackcomponentscatalog

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MyLaunchedEffect(modifier: Modifier = Modifier) {
    var timeLeft by rememberSaveable { mutableIntStateOf(5) }

    LaunchedEffect(timeLeft) {
        if (timeLeft > 0) {
            delay(1000)
            timeLeft --
        }
    }

    LaunchedEffect(Unit) {
        // Esto se va a ejectuar una única vez, la primera vez que se compone la vista
    }

    Box(
        modifier = modifier.size(150.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (timeLeft > 0) timeLeft.toString() else "KABOOM!!",
            fontSize = 30.sp
        )
    }
}