package com.example.pokemon.presentation.homeScreen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.pokemon.domain.model.PokemonType

@Composable
fun TypeChip(modifier: Modifier = Modifier, type: PokemonType) {
    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(Color(type.color))
            .padding(horizontal = 8.dp, vertical = 2.dp)
    ) {
        Text(
            text = type.name,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surfaceContainerLowest
        )
    }
}