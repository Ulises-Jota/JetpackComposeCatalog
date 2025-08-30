package com.cursokotlin.jetpackcomponentscatalog.animations

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimateAsStateFullExample() {
    var isSelected by rememberSaveable { mutableStateOf(false) }
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) Color.Red else Color.Blue
    )
    val animatedSize by animateDpAsState(
        targetValue = if (isSelected) 200.dp else 150.dp
    )
    val animatedOffset by animateOffsetAsState(
        targetValue = if (isSelected) Offset(0f, 100f) else Offset(0f, 0f)
    )
    val animatedFloat by animateFloatAsState(
        targetValue = if (isSelected) 0.1f else 1f
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(32.dp))
        Button(
            onClick = { isSelected = !isSelected }
        ) {
            Text("Seleccionar")
        }
        Text("Float: %.2f".format(animatedFloat))
        Spacer(Modifier.height(32.dp))

        Box(
            Modifier
                .offset(animatedOffset.x.dp, animatedOffset.y.dp)
                .size(animatedSize)
                .background(animatedColor.copy(alpha = animatedFloat))
        )
    }
}

@Composable
fun AnimateColorAsStateExample() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }
    var showBox by rememberSaveable {
        mutableStateOf(true)
    }
    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 1000),
        finishedListener = { showBox = false },
        label = "Red and Yellow animation"
    )

    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
    }
}

@Composable
fun AnimateDpAsStateExample() {
    var smallSize by rememberSaveable { mutableStateOf(true) }
    var isTextVisible by rememberSaveable { mutableStateOf(false) }
    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 500),
        finishedListener = { isTextVisible = !smallSize },
        label = "Size animation"
    )
    Box(modifier = Modifier
        .size(size)
        .background(Color.Cyan)
        .clickable { smallSize = !smallSize }
    ) {
        if (isTextVisible)
            Text(
                text = "Hola, qué onda?",
                modifier = Modifier.align(Alignment.Center)
            )
    }
}
