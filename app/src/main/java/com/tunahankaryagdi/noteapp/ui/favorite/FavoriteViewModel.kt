package com.tunahankaryagdi.noteapp.ui.favorite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class FavoriteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    var favoriteNotes: MutableLiveData<List<Note>> = MutableLiveData()


    fun getFavoriteNotes(){

        viewModelScope.launch(Dispatchers.IO) {
            var response = repository.getFavoriteNotes()
            withContext(Dispatchers.Main){
                favoriteNotes.postValue(response)
            }

        }

    }

}