package com.example.pokemon.data.remote.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DTO for Pokemon detail response
 * Endpoint: /pokemon/{id}
 */
@Serializable
data class PokemonDetailDto(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("height")
    val height: Int,
    @SerialName("weight")
    val weight: Int,
    @SerialName("sprites")
    val sprites: SpritesDto,
    @SerialName("types")
    val types: List<TypeSlotDto>,
    @SerialName("stats")
    val stats: List<StatDto>,
    @SerialName("abilities")
    val abilities: List<AbilitySlotDto>
)

/**
 * DTO for Pokemon sprites/images
 */
@Serializable
data class SpritesDto(
    @SerialName("front_default")
    val frontDefault: String? = null,
    @SerialName("other")
    val other: OtherSpritesDto? = null
)

/**
 * DTO for other sprite sources (higher quality images)
 */
@Serializable
data class OtherSpritesDto(
    @SerialName("official-artwork")
    val officialArtwork: OfficialArtworkDto? = null
)

/**
 * DTO for official artwork (best quality image)
 */
@Serializable
data class OfficialArtworkDto(
    @SerialName("front_default")
    val frontDefault: String? = null
)

/**
 * DTO for Pokemon type slot
 */
@Serializable
data class TypeSlotDto(
    @SerialName("slot")
    val slot: Int,
    @SerialName("type")
    val type: TypeDto
)

/**
 * DTO for type details
 */
@Serializable
data class TypeDto(
    @SerialName("name")
    val name: String
)

/**
 * DTO for Pokemon stat
 */
@Serializable
data class StatDto(
    @SerialName("base_stat")
    val baseStat: Int,
    @SerialName("stat")
    val stat: StatNameDto
)

/**
 * DTO for stat name
 */
@Serializable
data class StatNameDto(
    @SerialName("name")
    val name: String
)

/**
 * DTO for ability slot
 */
@Serializable
data class AbilitySlotDto(
    @SerialName("is_hidden")
    val isHidden: Boolean,
    @SerialName("ability")
    val ability: AbilityDto
)

/**
 * DTO for ability details
 */
@Serializable
data class AbilityDto(
    @SerialName("name")
    val name: String
)