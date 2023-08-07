package com.example.artbookfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.artbookfragment.databinding.ItemRowBinding
import com.example.artbookfragment.model.Art
import com.example.artbookfragment.view.ArtListDirections

class ArtListAdapter(val artList : List<Art>) : RecyclerView.Adapter<ArtListAdapter.ArtHolder>() {

    class ArtHolder(val binding : ItemRowBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtHolder {
        val binding = ItemRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ArtHolder(binding)
    }

    override fun getItemCount(): Int {
        return artList.size
    }

    override fun onBindViewHolder(holder: ArtHolder, position: Int) {

        holder.binding.artNameText.text = artList[position].artName
        holder.itemView.setOnClickListener {
            val action = ArtListDirections.actionArtListToDetailFragment("old",id=artList[position].id)
            Navigation.findNavController(it).navigate(action)

        }
    }
}