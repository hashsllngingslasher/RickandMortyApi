package com.example.hw_6_2.ui.fragment.allcharacters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import coil.load
import com.example.hw_6_2.data.model.Character
import com.example.hw_6_2.databinding.ItemCharacterBinding
import com.example.hw_6_2.extension.setIndicator

class CharacterAdapter() : Adapter<CharacterViewHolder>() {
    private var list = listOf<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding =
            ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    fun setList(list: List<Character>) {
        this.list = list
        notifyDataSetChanged()
    }
}

class CharacterViewHolder(private val binding: ItemCharacterBinding) : ViewHolder(binding.root) {
    fun onBind(model: Character) = with(binding) {
        tvName.text = model.name
        tvRace.text = model.species
        tvLifeStatus.text = model.status
        imgCharacter.load(model.image)
        imgLifeStatusIndicator.setIndicator(model.status)
    }
}
