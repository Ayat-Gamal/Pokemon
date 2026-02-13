package com.example.pokemon.presentation.homeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {

    Box(
        contentAlignment = Alignment.Center
    ) {
        Text("HomeScreen")
    }
}