package com.example.pokemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.pokemon.navigation.PokeNavHost
import com.example.pokemon.navigation.bottomBar.PokeBottomBar
import com.example.pokemon.ui.theme.PokemonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val navHostController = rememberNavController()
            val backStackEntry = navHostController.currentBackStackEntryAsState()
            val currentDestination = backStackEntry.value?.destination
            PokemonTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        PokeBottomBar(
                            navController = navHostController,
                            currentDestination = currentDestination
                        )
                    }

                ) { innerPadding ->
                    PokeNavHost(
                        navHostController = navHostController,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PokemonTheme {
        val navHostController = rememberNavController()
        val backStackEntry = navHostController.currentBackStackEntryAsState()
        PokeNavHost(
            navHostController = navHostController
        )
    }
}