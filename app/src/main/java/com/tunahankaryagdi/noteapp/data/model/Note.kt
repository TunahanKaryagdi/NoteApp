package com.tunahankaryagdi.noteapp.data.model

import androidx.room.*
import java.util.*

@Entity(tableName = "notes")
data class Note(

    val title: String = "",
    val content: String = "",

    @ColumnInfo(name = "is_favorite")
    val isFavorite: Boolean = false,

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

