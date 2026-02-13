package com.example.pokemon.domain.model

/**
 * Pokemon types with their associated colors for UI
 */
enum class PokemonType(val color: Long) {
    NORMAL(0xFFA8A878),
    FIRE(0xFFF08030),
    WATER(0xFF6890F0),
    ELECTRIC(0xFFF8D030),
    GRASS(0xFF78C850),
    ICE(0xFF98D8D8),
    FIGHTING(0xFFC03028),
    POISON(0xFFA040A0),
    GROUND(0xFFE0C068),
    FLYING(0xFFA890F0),
    PSYCHIC(0xFFF85888),
    BUG(0xFFA8B820),
    ROCK(0xFFB8A038),
    GHOST(0xFF705898),
    DRAGON(0xFF7038F8),
    DARK(0xFF705848),
    STEEL(0xFFB8B8D0),
    FAIRY(0xFFEE99AC);

    companion object {
        fun fromString(type: String): PokemonType {
            return entries.find {
                it.name.equals(type, ignoreCase = true)
            } ?: NORMAL
        }
    }
}