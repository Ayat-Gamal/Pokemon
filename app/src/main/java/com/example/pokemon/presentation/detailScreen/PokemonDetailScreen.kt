package com.example.pokemon.presentation.detailScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.domain.model.PokemonType
import com.example.pokemon.presentation.detailScreen.compoent.DetailTypeTag
import com.example.pokemon.presentation.detailScreen.compoent.PokemonStatsList
import com.example.pokemon.ui.theme.PokemonTheme
import com.example.pokemon.util.DummyData

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
        containerColor = Color.White,
        floatingActionButton = {
            FloatingActionButton(
                onClick = onFavoriteClick,
                contentColor = Color.White,
                shape = CircleShape,
                modifier = Modifier.padding(bottom = 16.dp, end = 8.dp)
            ) {
                // Heart icon placeholder
                Box(
                    modifier = Modifier
                        .size(24.dp)
                        .background(color = Color.Transparent, shape = CircleShape)
                ) {
                    Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = "Type Icon",
                        tint = typeColor,
                    )
                }
            }
        }
    ) { paddingValues ->
        PokemonDetailContent(
            pokemon = pokemon,
            typeColor = typeColor,
            onBackClick = onBackClick,
            modifier = Modifier.padding(paddingValues)
        )
    }
}

@Composable
fun PokemonDetailContent(
    pokemon: Pokemon,
    typeColor: Color,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(modifier = modifier.fillMaxSize()) {
        // Gradient Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(typeColor, Color.White)
                    )
                )
        )

        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                IconButton(
                    onClick = onBackClick,
                    modifier = Modifier.padding(16.dp)
                ) {
                    // Back arrow icon placeholder
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(
                                color = Color.White.copy(alpha = 0.5f),
                                shape = RoundedCornerShape(4.dp)
                            )
                    ) {
                        Icon(
                            Icons.AutoMirrored.Rounded.ArrowBack,
                            contentDescription = "Back",
                            tint = typeColor,
                        )
                    }
                }
                Spacer(modifier = Modifier.height(100.dp))
            }
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 48.dp, topEnd = 48.dp),
                    color = Color.White
                ) {
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .padding(top = 80.dp, bottom = 100.dp)
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Text(
                            text = pokemon.displayName,
                            style = MaterialTheme.typography.displayMedium,
                            fontWeight = FontWeight.Bold,
                            color = Color.DarkGray
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        DetailTypeTag(type = pokemon.types.firstOrNull() ?: PokemonType.NORMAL)

                        Spacer(modifier = Modifier.height(24.dp))

                        val description = when (pokemon.name.lowercase()) {
                            "squirtle" -> "Squirtle's shell is not merely used for protection. The shell's rounded shape and the grooves on its surface help minimize resistance in water, enabling this pokemon to swim at high speed."
                            "pikachu" -> "When several of these Pokémon gather, their electricity could build and cause lightning storms."
                            else -> "Its nature is to protect its friends. If it's in danger, it will use all of its strength to overcome it."
                        }

                        Text(
                            text = description,
                            style = MaterialTheme.typography.bodyMedium,
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            lineHeight = 22.sp,
                            modifier = Modifier.padding(horizontal = 8.dp)
                        )
                        Spacer(modifier = Modifier.height(32.dp))
                        PokemonStatsList(typeColor = typeColor)
                    }
                }
            }
        }

        // Pokemon Image
        AsyncImage(
            model = pokemon.imageUrl,
            contentDescription = pokemon.name,
            modifier = Modifier
                .size(220.dp)
                .align(Alignment.TopCenter)
                .offset(y = 60.dp)
        )
    }
}


@Composable
fun DetailTabRow(typeColor: Color) {
    var selectedTab by remember { mutableStateOf("STATS") }
    val tabs = listOf("STATS", "EVOLUTIONS", "MOVES")

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        tabs.forEach { tab ->
            val isSelected = tab == selectedTab
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .clickable { selectedTab = tab },
                color = if (isSelected) typeColor else Color.Transparent,
            ) {
                Text(
                    text = tab,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp),
                    color = if (isSelected) Color.White else Color.Gray.copy(alpha = 0.8f),
                    style = MaterialTheme.typography.labelLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
private fun PokemonDetailScreenPrev() {
    PokemonTheme {
        PokemonDetailScreen(
            pokemon = DummyData.pokemonList[2], // Squirtle
            onBackClick = { },
            onFavoriteClick = {}
        )
    }
}
