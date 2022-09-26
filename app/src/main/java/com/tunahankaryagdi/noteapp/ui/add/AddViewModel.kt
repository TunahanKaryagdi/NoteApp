package com.tunahankaryagdi.noteapp.ui.add

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
class AddViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    fun addNote(note : Note){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertNote(note)
        }
    }


}