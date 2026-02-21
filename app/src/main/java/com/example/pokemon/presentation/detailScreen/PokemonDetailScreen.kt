package com.example.pokemon.presentation.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.presentation.homeScreen.component.TypeChip
import com.example.pokemon.ui.theme.PokemonTheme
import com.example.pokemon.util.DummyData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PokemonDetailScreen(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    onBackClick: () -> Unit,
    onFavoriteClick: () -> Unit,
) {
    val typeColor = Color(pokemon.types.firstOrNull()?.color?.toInt() ?: 0xFF395a83.toInt())

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = pokemon.displayName)
                },
                colors = TopAppBarDefaults.topAppBarColors(),
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(Icons.Rounded.ArrowBack, "Back")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { onFavoriteClick },
                containerColor = typeColor, // Use the pokemon type color!
                contentColor = Color.White
            ) {
                Icon(Icons.Rounded.Favorite, contentDescription = "Favorite")
            }
        }
    ) { paddingValues ->

        PokemonDetailContent(pokemon = pokemon, modifier.padding(paddingValues))
    }

}

@Composable
fun PokemonDetailContent(
    pokemon: Pokemon,
    modifier: Modifier = Modifier,
) {
    val typeColor = Color(pokemon.types.firstOrNull()?.color?.toInt() ?: 0xFF395a83.toInt())

    Box(
        modifier = modifier
            .fillMaxSize(),
    ) {

        Box(
            modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(typeColor, typeColor.copy(alpha = 0.6f), Color.Transparent)
                    )
                )
                .height(300.dp),
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = pokemon.imageUrl,
                clipToBounds = true,
                contentDescription = pokemon.name,
                modifier = Modifier
                    .size(280.dp)
                    .padding(top = 40.dp),
            )

            Surface(
                modifier = Modifier.fillMaxSize(),
                shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp),
                tonalElevation = 2.dp,
                color = Color.Transparent,
            ) {

                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Name and Type Chips
                    Text(
                        text = pokemon.displayName,
                        style = MaterialTheme.typography.displaySmall,
                        fontWeight = FontWeight.Bold
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        pokemon.types.forEach { TypeChip(type = it) }
                    }

                    StatRow("HP", 0.45f, typeColor)
                    StatRow("ATK", 0.60f, typeColor)
                    StatRow("DEF", 0.35f, typeColor)
                }
            }
        }


    }

}

@Composable
fun StatRow(label: String, progress: Float, color: Color) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(label, modifier = Modifier.width(40.dp), style = MaterialTheme.typography.labelMedium)
        LinearProgressIndicator(
            progress = { progress },
            modifier = Modifier
                .fillMaxWidth()
                .height(8.dp)
                .clip(CircleShape),
            color = color,
            trackColor = color.copy(alpha = 0.2f)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonDetailScreenPrev() {
    val dummyData = DummyData.pokemonList
    PokemonTheme {
        PokemonDetailScreen(
            pokemon = dummyData.get(1),
            onBackClick = { },
            onFavoriteClick = {}
        )
    }
}