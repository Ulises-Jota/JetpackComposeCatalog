package com.cursokotlin.jetpackcomponentscatalog.navigation

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.cursokotlin.jetpackcomponentscatalog.navigation.types.createNavType
import kotlinx.coroutines.CoroutineScope
import kotlin.reflect.typeOf

@Composable
fun NavigationHandler(
    snackbarHostState: SnackbarHostState,
    coroutineScope: CoroutineScope
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Login
    ) {
        composable<Login> {
            LoginScreen(
                navigateToDetail = { navController.navigate(Home) },
                snackbarHostState = snackbarHostState,
                coroutineScope = coroutineScope,
            )
        }

        composable<Home> {
            HomeScreen(
                navigateBack = { navController.popBackStack() },
                navigateToDetail = { navController.navigate(Detail(id = it)) }
            )
        }

        composable<Detail> { navBackStackEntry ->
            val detail = navBackStackEntry.toRoute<Detail>()
            DetailScreen(
                id = detail.id,
                navigateToSettings = { navController.navigate(Settings(it)) }
            )
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsModel>() to createNavType<SettingsModel>())) {
            val settings = it.toRoute<Settings>()
            SettingsScreen(
                settingsModel = settings.settingsModel,
                navigateToHome = {
                    navController.navigate(Login) {
                        popUpTo<Login> { inclusive = true }
                    }
                }
            )
        }
    }
}
