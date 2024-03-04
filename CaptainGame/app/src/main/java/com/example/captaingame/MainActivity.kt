package com.example.captaingame

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.example.captaingame.ui.theme.CaptainGameTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CaptainGameTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CaptainGame()
                }
            }
        }
    }
}

@Composable
fun CaptainGame(){
    val treasuresFound = remember{ mutableStateOf(0)}
    val direction = remember{ mutableStateOf("North") }
    val event = remember{ mutableStateOf("Storm")}
    var healthPoints = remember{ mutableStateOf(15)}

    Column {
        Text(text = "Treasures found: ${treasuresFound.value}")
        Text(text = "Treasures found: ${direction.value}")
        Text(text = "Health points: ${healthPoints.value}")
        val context = LocalContext.current
        Button(onClick =
        {
            direction.value = "North"
            if(Random.nextBoolean() && healthPoints.value > 0){
                Toast.makeText(context, "You have found treasure!", Toast.LENGTH_SHORT).show()
                treasuresFound.value += 1
            }
            else if(Random.nextBoolean() && healthPoints.value > 0){
                event.value = "Storm"
                Toast.makeText(context, "You have encountered a storm!", Toast.LENGTH_SHORT).show()
                healthPoints.value -= 1
            }
            else if(healthPoints.value == 0){
                Toast.makeText(context, "Your ship is wrecked!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Sail North")
        }

        Button(onClick =
        {
            direction.value = "East"
            if(Random.nextBoolean() && healthPoints.value > 0){
                Toast.makeText(context, "You have found treasure!", Toast.LENGTH_SHORT).show()
                treasuresFound.value += 1
            }
            else if(Random.nextBoolean() && healthPoints.value > 0){
                event.value = "Storm"
                Toast.makeText(context, "You have encountered a storm!", Toast.LENGTH_SHORT).show()
                healthPoints.value -= 1
            }
            else if(healthPoints.value == 0){
                Toast.makeText(context, "Your ship is wrecked!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Sail East")
        }

        Button(onClick =
        {
            direction.value = "West"
            if(Random.nextBoolean() && healthPoints.value > 0){
                Toast.makeText(context, "You have found treasure!", Toast.LENGTH_SHORT).show()
                treasuresFound.value += 1
            }
            else if(Random.nextBoolean() && healthPoints.value > 0){
                event.value = "Storm"
                Toast.makeText(context, "You have encountered a storm!", Toast.LENGTH_SHORT).show()
                healthPoints.value -= 1
            }
            else if(healthPoints.value == 0){
                Toast.makeText(context, "Your ship is wrecked!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Sail West")
        }

        Button(onClick =
        {
            direction.value = "South"
            if(Random.nextBoolean() && healthPoints.value > 0){
                Toast.makeText(context, "You have found treasure!", Toast.LENGTH_SHORT).show()
                treasuresFound.value += 1
            }
            else if(Random.nextBoolean() && healthPoints.value > 0){
                event.value = "Storm"
                Toast.makeText(context, "You have encountered a storm!", Toast.LENGTH_SHORT).show()
                healthPoints.value -= 1
            }
            else if(healthPoints.value == 0){
                Toast.makeText(context, "Your ship is wrecked!", Toast.LENGTH_SHORT).show()
            }
        }) {
            Text(text = "Sail South")
        }
    }
}