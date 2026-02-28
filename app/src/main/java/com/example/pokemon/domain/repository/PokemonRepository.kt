package com.example.pokemon.domain.repository

import com.example.pokemon.domain.model.Pokemon
import com.example.pokemon.util.DummyData
import jakarta.inject.Inject
import kotlin.jvm.Throws


class PokemonRepository @Inject constructor() {
    fun getPokemon(pokemonId: Int): Pokemon? {
        val dummyData = DummyData.pokemonList
        val poke = dummyData.find {
            it.id == pokemonId
        }
        return poke
    }
    fun getAllPokemon(): List<Pokemon> {
        val dummyData = DummyData.pokemonList
        return dummyData

    }

}