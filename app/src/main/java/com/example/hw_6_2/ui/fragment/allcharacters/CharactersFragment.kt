package com.example.hw_6_2.ui.fragment.allcharacters

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import androidx.recyclerview.widget.RecyclerView.VERTICAL
import com.example.hw_6_2.databinding.FragmentCharactersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CharactersFragment : Fragment() {
    private lateinit var binding: FragmentCharactersBinding
    private val characterAdapter by lazy {
        CharacterAdapter()
    }
    private val viewModel: CharactersViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCharactersBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecycler()
        observe()
    }

    private fun observe() {
        viewModel.getAllCharacters().observe(viewLifecycleOwner) { characters ->
            if (characters != null) {
                Log.d("CharacterFragment", "Characters list updated: ${characters.size}")
                characterAdapter.setList(characters)
            } else {
                Log.d("CharacterFragment", "Characters list is null")
            }
        }
    }

    private fun setRecycler() = with(binding.rvCharacters) {
        adapter = characterAdapter
        layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )
    }

}