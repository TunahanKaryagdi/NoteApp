package com.tunahankaryagdi.noteapp.data.repository

import com.tunahankaryagdi.noteapp.data.room.AppDatabase
import com.tunahankaryagdi.noteapp.data.model.Note
import com.tunahankaryagdi.noteapp.data.room.NoteDao
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDao: NoteDao) {

    suspend fun insertNote(note: Note) {
        noteDao.insert(note)
    }

    suspend fun getAll(): List<Note> {
        return noteDao.getAll()
    }

    suspend fun deleteNote(note: Note) {
        noteDao.delete(note)
    }

    suspend fun insertAll(note: Note) {
        noteDao.insertAll(note)
    }

}