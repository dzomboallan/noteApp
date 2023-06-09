package com.example.notes.Database

import android.icu.text.CaseMap.Title
import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.notes.Models.Note

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes() : LiveData<List<Note>>

    @Query("UPDATE notes_table SET title = :title, note = :note WHERE id = :id")
    suspend fun update(id : Int?, title: String?, note: String?)
}