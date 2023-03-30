package com.ergea.wordsapp.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.ergea.wordsapp.R
import com.ergea.wordsapp.databinding.ItemListWordBinding
import com.ergea.wordsapp.ui.WordDetailFragment

/**
 * @Author: ridhogymnastiar
 * Github: https://github.com/ridhogaa
 */

class WordAdapter(private val list: List<Char>) :
    RecyclerView.Adapter<WordAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: ItemListWordBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(list: Char) {
            binding.btnWord.text = list.toString()

            binding.btnWord.setOnClickListener {
                val bundle = Bundle()
                bundle.putString("EXTRA_WORD", list.toString())
                it.findNavController().navigate(R.id.action_wordHomeFragment_to_wordDetailFragment, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(ItemListWordBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(list[position])

    override fun getItemCount(): Int = list.size
}
