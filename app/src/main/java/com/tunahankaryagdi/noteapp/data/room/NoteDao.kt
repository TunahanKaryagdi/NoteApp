package com.tunahankaryagdi.noteapp.data.room

import androidx.room.*
import com.tunahankaryagdi.noteapp.data.model.Note

@Dao
interface NoteDao {
    @Query("SELECT * FROM notes")
    suspend fun getAll(): List<Note>

    @Insert
    suspend fun insertAll(vararg note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("UPDATE notes SET is_favorite = :isFavorite WHERE id =:id")
    suspend fun update(id: Int , isFavorite: Boolean)

    @Query("SELECT * FROM notes WHERE is_favorite = :isFavorite ")
    suspend fun getFavoriteNotes(isFavorite: Boolean) : List<Note>
}