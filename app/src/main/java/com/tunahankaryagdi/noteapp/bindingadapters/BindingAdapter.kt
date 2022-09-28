package com.tunahankaryagdi.noteapp.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tunahankaryagdi.noteapp.R
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.ui.home.HomeViewModel

@BindingAdapter("isFavorite")
fun ImageView.isFavorite(isFavorite : Boolean = false){

    if (isFavorite){
        this.setImageResource(R.drawable.ic_favorite)
    }else{
        this.setImageResource(R.drawable.ic_not_favorite)
    }

}



