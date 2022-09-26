package com.tunahankaryagdi.noteapp.data.model

import androidx.room.*
import java.util.*

@Entity(tableName = "notes")
data class Note(

    val title: String = "title",
    val content: String = "content",

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)

