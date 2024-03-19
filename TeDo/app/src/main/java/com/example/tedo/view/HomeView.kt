package com.example.tedo.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeView(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                8.dp
            )
    )
    {
        Text(text = "Brugernavn", fontFamily = FontFamily.Monospace)
        OutlinedTextField(
            value = "Brugernavn",
            onValueChange = {},
            shape = RoundedCornerShape(8.dp),
        )
        OutlinedTextField(
            value = "Kodeord",
            onValueChange = {},
            shape = RoundedCornerShape(8.dp)
        )
    }
}