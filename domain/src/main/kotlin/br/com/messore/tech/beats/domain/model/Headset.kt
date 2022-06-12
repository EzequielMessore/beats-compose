package br.com.messore.tech.beats.domain.model

data class Headset(
    val id: Int,
    val autonomy: String,
    val capture: String,
    val compatibility: String,
    val connection: String,
    val height: String,
    val model: String,
    val powerSupply: String,
    val price: Double,
    val rating: Double,
    val imageURL: String,
    val reviews: Int,
)
