package com.tunahankaryagdi.noteapp.ui.favorite.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.databinding.FavoriteListItemBinding
import com.tunahankaryagdi.noteapp.databinding.HomeListItemBinding

class FavoriteListAdapter : RecyclerView.Adapter<FavoriteListAdapter.FavoriteListViewHolder>() {

    var favoriteNotes : List<Note> = emptyList()

    fun setList(newNotes : List<Note>){
        favoriteNotes = newNotes
        notifyDataSetChanged()

    }

    class FavoriteListViewHolder(private val binding : FavoriteListItemBinding)  : RecyclerView.ViewHolder(binding.root){

        fun bind(note: Note){
            binding.note =note

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteListViewHolder {
        val binding = FavoriteListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  FavoriteListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: FavoriteListViewHolder, position: Int) {
        holder.bind(favoriteNotes[position])
    }

    override fun getItemCount(): Int {
        if (favoriteNotes.isEmpty()){
            return 0
        }else{
            return favoriteNotes.size
        }
    }
}


