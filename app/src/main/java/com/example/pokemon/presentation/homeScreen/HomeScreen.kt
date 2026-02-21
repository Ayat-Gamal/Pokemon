package com.example.pokemon.presentation.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.presentation.homeScreen.component.PokemonCardItem
import com.example.pokemon.ui.theme.PokemonTheme
import com.example.pokemon.util.DummyData


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onPokemonClick: (clickedPokeId : Int)  -> Unit
    ) {
     val dummyData = DummyData.pokemonList
    Column {
        PokemonGrid(
            dummyData, modifier
                .fillMaxSize()
                .padding(16.dp),
            onPokemonClick =   onPokemonClick
        )
    }
}

@Composable
fun PokemonGrid(
    pokemonList: List<Pokemon>,
    modifier: Modifier = Modifier,
    onPokemonClick: (clickedPokeId : Int)  -> Unit
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier,
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),

        ) {
        items(pokemonList) { poke ->
            PokemonCardItem(
                poke =  poke,
                onPokemonClick = onPokemonClick
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PokemonCardItemPrev() {
    PokemonCardItem(
        modifier = Modifier,
        poke= DummyData.pokemonList[2],
        onPokemonClick = {}
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPrev() {
    PokemonTheme {
        HomeScreen(
            modifier = Modifier,
            onPokemonClick = {}
        )
    }
}