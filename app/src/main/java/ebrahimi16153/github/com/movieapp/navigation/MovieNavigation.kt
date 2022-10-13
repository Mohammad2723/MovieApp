package ebrahimi16153.github.com.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import ebrahimi16153.github.com.movieapp.screen.details.DetailsScreen
import ebrahimi16153.github.com.movieapp.screen.home.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    //navHost and navGraph
    NavHost(navController = navController, startDestination = MoviesScreen.HomeScreen.name) {
        // home
        composable(MoviesScreen.HomeScreen.name) {
            // here we pass where this should lead us to
            HomeScreen(navController = navController)
        }

        //details   -----> //www.google.com/details/id=34
        composable(
            MoviesScreen.DetailsScreen.name + "/{movie}",
            arguments = listOf(navArgument(name = "movie") { type = NavType.StringType })
        ) { backStackEntry ->
            DetailsScreen(navController = navController,backStackEntry.arguments?.getString("movie"))
        }

    }


}