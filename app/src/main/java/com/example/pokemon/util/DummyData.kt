package com.example.pokemon.util

import com.example.pokemon.domain.model.*

/**
 * Dummy data for development and testing
 * Uses real Pokemon with actual PokeAPI image URLs
 */
object DummyData {

    /**
     * List of Pokemon for testing list/grid view
     */
    val pokemonList = listOf(
        Pokemon(
            id = 1,
            name = "bulbasaur",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/1.png",
            types = listOf(PokemonType.GRASS, PokemonType.POISON),
            isFavorite = false
        ),
        Pokemon(
            id = 4,
            name = "charmander",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/4.png",
            types = listOf(PokemonType.FIRE),
            isFavorite = false
        ),
        Pokemon(
            id = 7,
            name = "squirtle",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/7.png",
            types = listOf(PokemonType.WATER),
            isFavorite = false
        ),
        Pokemon(
            id = 25,
            name = "pikachu",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
            types = listOf(PokemonType.ELECTRIC),
            isFavorite = true
        ),
        Pokemon(
            id = 39,
            name = "jigglypuff",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/39.png",
            types = listOf(PokemonType.NORMAL, PokemonType.FAIRY),
            isFavorite = false
        ),
        Pokemon(
            id = 94,
            name = "gengar",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/94.png",
            types = listOf(PokemonType.GHOST, PokemonType.POISON),
            isFavorite = false
        ),
        Pokemon(
            id = 131,
            name = "lapras",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/131.png",
            types = listOf(PokemonType.WATER, PokemonType.ICE),
            isFavorite = false
        ),
        Pokemon(
            id = 133,
            name = "eevee",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/133.png",
            types = listOf(PokemonType.NORMAL),
            isFavorite = true
        ),
        Pokemon(
            id = 143,
            name = "snorlax",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/143.png",
            types = listOf(PokemonType.NORMAL),
            isFavorite = false
        ),
        Pokemon(
            id = 149,
            name = "dragonite",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/149.png",
            types = listOf(PokemonType.DRAGON, PokemonType.FLYING),
            isFavorite = false
        ),
        Pokemon(
            id = 150,
            name = "mewtwo",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/150.png",
            types = listOf(PokemonType.PSYCHIC),
            isFavorite = false
        ),
        Pokemon(
            id = 151,
            name = "mew",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/151.png",
            types = listOf(PokemonType.PSYCHIC),
            isFavorite = true
        ),
        Pokemon(
            id = 249,
            name = "lugia",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/249.png",
            types = listOf(PokemonType.PSYCHIC, PokemonType.FLYING),
            isFavorite = false
        ),
        Pokemon(
            id = 384,
            name = "rayquaza",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/384.png",
            types = listOf(PokemonType.DRAGON, PokemonType.FLYING),
            isFavorite = false
        ),
        Pokemon(
            id = 448,
            name = "lucario",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/448.png",
            types = listOf(PokemonType.FIGHTING, PokemonType.STEEL),
            isFavorite = false
        ),
        Pokemon(
            id = 658,
            name = "greninja",
            imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/658.png",
            types = listOf(PokemonType.WATER, PokemonType.DARK),
            isFavorite = false
        )
    )

    /**
     * Detailed Pokemon for testing detail view
     */
    val pikachuDetail = PokemonDetail(
        id = 25,
        name = "pikachu",
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/25.png",
        types = listOf(PokemonType.ELECTRIC),
        height = 4, // 0.4m
        weight = 60, // 6.0kg
        stats = PokemonStats(
            hp = 35,
            attack = 55,
            defense = 40,
            specialAttack = 50,
            specialDefense = 50,
            speed = 90
        ),
        abilities = listOf(
            Ability(name = "static", isHidden = false),
            Ability(name = "lightning-rod", isHidden = true)
        ),
        description = "When several of these Pokémon gather, their electricity could build and cause lightning storms.",
        isFavorite = true
    )

    val charizardDetail = PokemonDetail(
        id = 6,
        name = "charizard",
        imageUrl = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/6.png",
        types = listOf(PokemonType.FIRE, PokemonType.FLYING),
        height = 17, // 1.7m
        weight = 905, // 90.5kg
        stats = PokemonStats(
            hp = 78,
            attack = 84,
            defense = 78,
            specialAttack = 109,
            specialDefense = 85,
            speed = 100
        ),
        abilities = listOf(
            Ability(name = "blaze", isHidden = false),
            Ability(name = "solar-power", isHidden = true)
        ),
        description = "Charizard flies around the sky in search of powerful opponents. It breathes fire of such great heat that it melts anything.",
        isFavorite = false
    )

    /**
     * Get Pokemon by ID from dummy list
     */
    fun getPokemonById(id: Int): Pokemon? {
        return pokemonList.find { it.id == id }
    }

    /**
     * Get favorite Pokemon from dummy list
     */
    fun getFavoritePokemon(): List<Pokemon> {
        return pokemonList.filter { it.isFavorite }
    }
}