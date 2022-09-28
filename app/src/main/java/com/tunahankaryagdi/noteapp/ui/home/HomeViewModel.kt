package com.tunahankaryagdi.noteapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.data.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    var notes: MutableLiveData<List<Note>> = MutableLiveData()



    fun update(note: Note){

        viewModelScope.launch(Dispatchers.IO) {
                repository.update(note)

        }
    }


    fun getData() {

        viewModelScope.launch(Dispatchers.IO) {
            var response = repository.getAll()
            withContext(Dispatchers.Main){
                notes.postValue(response)
            }

        }

    }

}