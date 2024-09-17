package com.example.pdpe_taller1

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pdpe_taller1.ui.theme.PDPE_Taller1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDPE_Taller1Theme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var name by remember { mutableStateOf("") }
    var savedName by remember { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Ingresa tu nombre") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { savedName = name }) {
                Text("Guardar Nombre")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Nombre Guardado: $savedName")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                // Navegar a SettingsActivity
                context.startActivity(Intent(context, SettingsActivity::class.java))
            }) {
                Text("Ir a Configuración")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    PDPE_Taller1Theme {
        MainScreen()
    }
}