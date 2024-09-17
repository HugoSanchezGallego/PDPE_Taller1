package com.example.pdpe_taller1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdpe_taller1.ui.theme.PDPE_Taller1Theme

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDPE_Taller1Theme {
                SettingsScreen()
            }
        }
    }
}

@Composable
fun SettingsScreen() {
    var backgroundColor by remember { mutableStateOf(Color.White) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { backgroundColor = Color.Red }) {
            Text("Rojo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { backgroundColor = Color.Green }) {
            Text("Verde")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { backgroundColor = Color.Blue }) {
            Text("Azul")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            // Navegar de vuelta a HomeActivity
            context.startActivity(Intent(context, HomeActivity::class.java))
        }) {
            Text("Volver a Inicio")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    PDPE_Taller1Theme {
        SettingsScreen()
    }
}