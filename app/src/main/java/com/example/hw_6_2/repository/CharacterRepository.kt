package com.example.hw_6_2.repository

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.example.hw_6_2.data.model.CharacterList
import com.example.hw_6_2.data.model.Character
import com.example.hw_6_2.data.remote.api.RickAndMortyAPI
import dagger.hilt.android.qualifiers.ApplicationContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class CharacterRepository @Inject constructor(
    private val api: RickAndMortyAPI
) {
    fun getCharacter(): MutableLiveData<List<Character>> {
        val liveData = MutableLiveData<List<Character>>()
        api.getAllCharacters().enqueue(object : Callback<CharacterList> {
            override fun onResponse(p0: Call<CharacterList>, response: Response<CharacterList>) {
                Log.d("ololo", response.body().toString())
                if (response.isSuccessful) {
                    Log.e("success", response.code().toString())
                    response.body()?.let {
                        liveData.postValue(it.results)

                    }
                }
            }
            override fun onFailure(p0: Call<CharacterList>, error: Throwable) {
                Log.e("fail", "onFailure: ${error.message}")
            }
        })
        return liveData
    }
}