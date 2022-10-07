package ebrahimi16153.github.com.movieapp.navigation


enum class MoviesScreen{
    HomeScreen,
    DetailsScreen;
    companion object{
        fun fromRout(route:String?):MoviesScreen = when (route?.substringBefore("/")){

            HomeScreen.name -> HomeScreen
            DetailsScreen.name -> DetailsScreen
            null -> HomeScreen
            else -> throw  IllegalArgumentException("Route $route is not valid")

        }
    }
}