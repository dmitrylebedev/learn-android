package com.example.myapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.data.DemoAppsRepository
import com.example.myapplication.feature.catalog.AppCatalogRoute
import com.example.myapplication.feature.details.AppCardScreen

object LearningAppDestination {
    const val CATALOG = "catalog"
    const val APP_CARD = "app_card/{appId}"
    const val APP_ID = "appId"

    fun appCardRoute(appId: String): String = "app_card/$appId"
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
            AppCatalogRoute(
                onAppClick = { appId ->
                    navController.navigate(LearningAppDestination.appCardRoute(appId))
                },
            )
        }

        composable(
            route = LearningAppDestination.APP_CARD,
            arguments = listOf(navArgument(LearningAppDestination.APP_ID) { type = NavType.StringType }),
        ) { backStackEntry ->
            val appId = backStackEntry.arguments?.getString(LearningAppDestination.APP_ID).orEmpty()
            val details = DemoAppsRepository.findDetails(appId)

            AppCardScreen(
                details = details,
                onBackClick = { navController.popBackStack() },
            )
        }
    }
}
