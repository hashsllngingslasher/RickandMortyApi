package com.example.hw_6_2.data.model

data class Character(
    val name: String,
    val image: String,
    val status: String,
    val species: String
)

data class CharacterList (
    val results : ArrayList<Character>
)