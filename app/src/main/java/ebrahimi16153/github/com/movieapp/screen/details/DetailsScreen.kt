package ebrahimi16153.github.com.movieapp.screen.details

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun DetailsScreen(navController: NavController, movieData: String?) {


    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color.Transparent, elevation = 0.dp) {
            Row(horizontalArrangement = Arrangement.Start) {
                Spacer(modifier = Modifier.width(20.dp))
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier
                        .clickable { navController.popBackStack() }
                        .size(25.dp))

                Spacer(modifier = Modifier.width(15.dp))
                Text(text = movieData.toString())

            }

        }
    }) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize()
        ) {

            Text(text = movieData.toString(), style = MaterialTheme.typography.h5)
//        Spacer(modifier = Modifier.height(23.dp))
//        Button(onClick = { navController.popBackStack() }) {
//            Text(text = "Go Back")
//        }

        }


    }

}