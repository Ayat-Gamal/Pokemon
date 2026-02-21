package com.example.pokemon.presentation.homeScreen.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon

@Composable
fun PokemonCardItem(
    modifier: Modifier = Modifier,
    poke: Pokemon,
    onPokemonClick: (clickedPokeId : Int)  -> Unit
) {
    ElevatedCard(
        modifier = modifier,
        onClick = {onPokemonClick(poke.id)},
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .align(Alignment.CenterHorizontally),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            AsyncImage(
                model = poke.imageUrl,
                clipToBounds = true,
                contentDescription = poke.name,
                modifier = Modifier
                    .size(96.dp)
                    .padding(bottom = 8.dp)
            )
            Text(
                text = poke.displayName,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = poke.formattedNumber,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            // TYPES
            Row(
                horizontalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                poke.types.take(3).forEach {
                    TypeChip(type = it)
                }
            }
        }
    }
}
