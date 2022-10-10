package ebrahimi16153.github.com.movieapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ebrahimi16153.github.com.movieapp.screen.details.DetailsScreen
import ebrahimi16153.github.com.movieapp.screen.home.HomeScreen

@Composable
fun MovieNavigation(){
    val navController = rememberNavController()
    //navHost and navGraph
    NavHost(navController=navController , startDestination = MoviesScreen.HomeScreen.name){
        // home
    composable(MoviesScreen.HomeScreen.name){
        // here we pass where this should lead us to
         HomeScreen(navController = navController)
    }

        //details
        composable(MoviesScreen.DetailsScreen.name){
            DetailsScreen(navController = navController)
        }
        
    }



}