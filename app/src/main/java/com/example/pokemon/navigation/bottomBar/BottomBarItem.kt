package com.example.pokemon.navigation.bottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.pokemon.navigation.Screen

const val HOME_SCREEN = "Pokedex"
const val FAVORITE_SCREEN = "Favorite"
const val SEARCH_SCREEN = "Search"

sealed class BottomBarItem(
    val route: Screen,
    val label: String,
    val icon: ImageVector,
) {
    data object Pokedex : BottomBarItem(
        route = Screen.Pokedex,
        label = HOME_SCREEN,
        icon = Icons.Default.Home
    )

    data object Search : BottomBarItem(
        route = Screen.Search,
        label = SEARCH_SCREEN,
        icon = Icons.Default.Search
    )

    data object Favorite : BottomBarItem(
        route = Screen.Favorite,
        label = FAVORITE_SCREEN,
        icon = Icons.Default.Favorite
    )

    companion object {
        val items = listOf(Pokedex, Search, Favorite)
    }
}
