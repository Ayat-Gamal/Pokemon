package com.example.pokemon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.navigation.bottomBar.PokeBottomBar
import com.example.pokemon.presentation.detailScreen.PokemonDetailScreen
import com.example.pokemon.presentation.detailScreen.PokemonDetailViewModel
import com.example.pokemon.presentation.favoriteScreen.FavoriteScreen
import com.example.pokemon.presentation.homeScreen.HomeScreen
import com.example.pokemon.presentation.searchScreen.SearchScreen
import com.example.pokemon.util.DummyData

@Composable
fun PokeNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {
    val detailsViewModel: PokemonDetailViewModel = hiltViewModel()
    val dummyData = DummyData.pokemonList
    val selectedPokemon by detailsViewModel.selectedPokemon.collectAsStateWithLifecycle()
    NavHost(
        navController = navHostController,
        startDestination = Screen.Pokedex,
    ) {
        //Home(poke list)
        composable<Screen.Pokedex> {
            HomeScreen(
                modifier,
                onPokemonClick = { pokeId ->
                    detailsViewModel.selectedPokemon(pokeId)
                    navHostController.navigate(Screen.PokemonDetail(pokeId))

                }
            )
        }
        // Favorite
        composable<Screen.Favorite> {
            FavoriteScreen(modifier)
        }
        //Search
        composable<Screen.Search> {
            SearchScreen(modifier)
        }
        //Details screen
        composable<Screen.PokemonDetail> { backStackEntry ->


            selectedPokemon?.let { pokeId ->
                PokemonDetailScreen(modifier, pokeId, onFavoriteClick = {}, onBackClick = {
                    navHostController.popBackStack()
                })
            }

        }

    }

}

@Preview(showBackground = true)
@Composable
private fun BottomBarPrev() {
    val navHostController = rememberNavController()
    val backStackEntry = navHostController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry.value?.destination
    PokeBottomBar(
        navController = navHostController,
        currentDestination = currentDestination
    )
}