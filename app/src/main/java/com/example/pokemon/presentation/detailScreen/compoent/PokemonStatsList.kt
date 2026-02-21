package com.example.pokemon.presentation.detailScreen.compoent

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun PokemonStatsList(typeColor: Color) {
    val stats = listOf(
        Triple("HP", "000", 0.45f),
        Triple("ATK", "000", 0.20f),
        Triple("DEF", "000", 0.55f),
        Triple("SATK", "000", 0.75f),
        Triple("SDEF", "000", 0.30f),
        Triple("SPD", "000", 0.60f)
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        stats.forEach { (label, value, progress) ->
            StatItem(label = label, value = value, progress = progress, color = typeColor)
        }
    }
}