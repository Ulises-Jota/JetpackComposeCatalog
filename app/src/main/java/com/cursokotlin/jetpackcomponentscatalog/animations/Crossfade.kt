package com.cursokotlin.jetpackcomponentscatalog.animations

import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Create
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.cursokotlin.jetpackcomponentscatalog.navigation.DetailScreen
import com.cursokotlin.jetpackcomponentscatalog.navigation.HomeScreen
import com.cursokotlin.jetpackcomponentscatalog.utils.ComponentType
import com.cursokotlin.jetpackcomponentscatalog.utils.getComponentTypeRandom

@Composable
fun CrossfadeAnimationExampleTwo(paddingValues: PaddingValues) {
    var currentScreen by rememberSaveable { mutableStateOf("Home") }

    Column(
        modifier = Modifier.padding(paddingValues)
    ) {
        Row {
            Text("Home", modifier = Modifier.clickable { currentScreen = "Home" })
            Text("Detail", modifier = Modifier.clickable { currentScreen = "Detail" })
        }

        Crossfade(
            targetState = currentScreen
        ) { screen ->
            when(screen) {
                "Home" -> HomeScreen(
                    navigateBack = {},
                    navigateToDetail = {}
                )
                "Detail" -> DetailScreen(
                    id = "",
                    navigateToSettings = {}
                )
            }
        }
    }
}

@Composable
fun CrossfadeAnimationExampleOne() {

    var myComponentType: ComponentType by remember {
        mutableStateOf(ComponentType.Text)
    }
    Column(Modifier.fillMaxSize()) {

        Button(onClick = { myComponentType = getComponentTypeRandom() }) {
            Text(text = "Cambiar componente")
        }

        Crossfade(
            targetState = myComponentType,
            animationSpec = tween(1000),
            label = "Crossfade example"
        ) { myComponentType ->
            when (myComponentType) {
                ComponentType.Image -> Icon(Icons.Default.Create, contentDescription = "")
                ComponentType.Text -> Text(text = "SOY UN COMPONENTE")
                ComponentType.Box -> Box(
                    Modifier
                        .size(50.dp)
                        .background(Color.Blue)
                )

                ComponentType.Error -> Text(text = "ERRORRRRRRR")
            }
        }
    }
}
