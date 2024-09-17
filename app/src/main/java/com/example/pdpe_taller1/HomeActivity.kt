package com.example.pdpe_taller1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdpe_taller1.ui.theme.PDPE_Taller1Theme
import java.util.*

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDPE_Taller1Theme {
                HomeScreen()
            }
        }
    }
}

@Composable
fun HomeScreen() {
    val greeting = getGreetingMessage()
    val context = LocalContext.current
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = greeting)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Navegar a MainActivity
            context.startActivity(Intent(context, MainActivity::class.java))
        }) {
            Text(text = "Ir a la Actividad Principal")
        }
    }
}

fun getGreetingMessage(): String {
    val hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY)
    return when (hour) {
        in 0..11 -> "Buenos días"
        in 12..17 -> "Buenas tardes"
        else -> "Buenas noches"
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    PDPE_Taller1Theme {
        HomeScreen()
    }
}