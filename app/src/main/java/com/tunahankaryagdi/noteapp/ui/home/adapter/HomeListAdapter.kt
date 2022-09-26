package com.tunahankaryagdi.noteapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.databinding.HomeListItemBinding

class HomeListAdapter : RecyclerView.Adapter<HomeListAdapter.HomeListViewHolder>() {

    var notes : List<Note> = emptyList()

    fun setList(newNotes : List<Note>){
        notes = newNotes
        notifyDataSetChanged()
    }

    class HomeListViewHolder(private val binding : HomeListItemBinding)  : RecyclerView.ViewHolder(binding.root){

        fun bind(note: Note){
            binding.note =note
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeListViewHolder {
        val binding = HomeListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  HomeListViewHolder(binding)

    }

    override fun onBindViewHolder(holder: HomeListViewHolder, position: Int) {
        holder.bind(notes[position])
    }

    override fun getItemCount(): Int {
        if (notes.isEmpty()){
            return 0
        }else{
            return notes.size
        }
    }
}