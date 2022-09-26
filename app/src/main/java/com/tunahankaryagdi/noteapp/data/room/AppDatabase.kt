package com.tunahankaryagdi.noteapp.data.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tunahankaryagdi.noteapp.data.model.Note

@Database(entities = [Note::class],version = 2)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao() : NoteDao
}