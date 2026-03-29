package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapplication.presentation.catalog.AppCatalogRoute

object LearningAppDestination {
    const val CATALOG = "catalog"
}

@Composable
fun LearningAppNavHost(
    navController: androidx.navigation.NavHostController = rememberNavController(),
    modifier: Modifier = Modifier,
) {
    NavHost(
        navController = navController,
        startDestination = LearningAppDestination.CATALOG,
        modifier = modifier,
    ) {
        composable(LearningAppDestination.CATALOG) {
            AppCatalogRoute()
        }
    }
}
