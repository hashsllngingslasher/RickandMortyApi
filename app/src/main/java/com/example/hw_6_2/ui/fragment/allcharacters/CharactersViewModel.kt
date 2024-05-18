package com.example.hw_6_2.ui.fragment.allcharacters

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw_6_2.data.model.Character
import com.example.hw_6_2.data.model.CharacterList
import com.example.hw_6_2.repository.CharacterRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val repository: CharacterRepository
) : ViewModel() {
    fun getAllCharacters(): LiveData<List<Character>> {
        return repository.getCharacter()
    }
}