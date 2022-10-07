package ebrahimi16153.github.com.movieapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ebrahimi16153.github.com.movieapp.ui.theme.MovieAppTheme


private val movieList = mutableListOf<String>(
    "The Lion King",
    "Avatar",
    "The Dark Night",
    "Lord Of Ring",
    "Cars",
    "Mission Impossible",
    "Prestige",
    "TopGun Maverick",
    "Dunce",
    "The God Father",
    "The Titanic",

    )

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MainContent(movieList)
            }

        }
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MovieAppTheme {
        Scaffold(topBar = {
            TopAppBar(backgroundColor = Color(0xff007aff), elevation = 5.dp) {
                Text(text = "Movie", style = TextStyle(color = Color.White))
            }
        }) {


            MainContent(movieList)

        }
    }
}


@Composable
fun MainContent(movieList: MutableList<String>) {
    Surface(
        color = MaterialTheme.colors.background,
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            LazyColumn {

                items(items = movieList) {
                    MovieRow(item = it){
                        Log.e("TAG","itemClick")
                    }
                }

            }
        }

    }
}

@Composable
fun MovieRow(item: String, onClick: () -> Unit ={}) {

        Card(
            shape = CircleShape.copy(all = CornerSize(15.dp)),
                    modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .padding(15.dp)
//                .clip(shape = CircleShape.copy(all = CornerSize(16.dp)))
                .clickable {  onClick() },
            elevation = 5.dp,
        ) {

            Row(horizontalArrangement = Arrangement.Start, verticalAlignment = Alignment.CenterVertically) {
                Surface(modifier = Modifier
                    .padding(12.dp)
                    .background(MaterialTheme.colors.background)
                    .size(100.dp),
                    shape = RectangleShape,
//                    elevation = 4.dp
                ) {
                    Icon(imageVector = Icons.Default.AccountBox, contentDescription ="image icon", tint = Color(0xff007aff) )
                }
                Text(text = item)
            }


        }
    }



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MainContent(movieList)
    }
}