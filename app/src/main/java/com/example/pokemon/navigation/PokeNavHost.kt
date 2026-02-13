package com.example.pokemon.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.navigation.bottomBar.PokeBottomBar
import com.example.pokemon.presentation.favoriteScreen.FavoriteScreen
import com.example.pokemon.presentation.homeScreen.HomeScreen
import com.example.pokemon.presentation.searchScreen.SearchScreen

@Composable
fun PokeNavHost(
    navHostController: NavHostController,
    modifier: Modifier = Modifier,
) {

    NavHost(
        navController = navHostController,
        startDestination = Screen.Pokedex,
    ) {
        //Home(poke list)
        composable<Screen.Pokedex> {
            HomeScreen()
        }
        // Favorite
        composable<Screen.Favorite> {
            FavoriteScreen()
        }
        //Search
        composable<Screen.Search> {
            SearchScreen()
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