package com.example.pokemon.presentation.homeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.model.PokemonType
import com.example.pokemon.ui.theme.PokemonTheme
import com.example.pokemon.util.DummyData


@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val dummyData = DummyData.pokemonList
    Column(
        modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        PokemonGrid(dummyData)
    }
}

@Composable
fun PokemonGrid(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier,
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        items(pokemonList) { poke ->
            PokemonCardItem(poke)
        }
    }
}

@Composable
fun PokemonCardItem(
    poke: Pokemon,
    modifier: Modifier = Modifier,
) {
    ElevatedCard(
        modifier = modifier.padding(8.dp),
        elevation = CardDefaults.elevatedCardElevation(2.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerLowest
        )
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
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
                    TypeChip(it)
                }
            }
        }
    }
}

@Composable
fun TypeChip(type: PokemonType) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(50))
            .background(
                Color(type.color),
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        Text(
            text = type.name,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.surfaceContainerLowest
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonCardItemPrev() {
    PokemonCardItem(
        DummyData.pokemonList[2]
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    PokemonTheme {
        HomeScreen()
    }
}