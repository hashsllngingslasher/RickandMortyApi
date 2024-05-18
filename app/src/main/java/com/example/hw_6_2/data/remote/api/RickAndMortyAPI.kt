package com.example.hw_6_2.data.remote.api

import com.example.hw_6_2.data.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyAPI {

    @GET("character")
    fun getAllCharacters(): Call<CharacterList>

}