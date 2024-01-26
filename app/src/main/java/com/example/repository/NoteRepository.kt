package com.example.repository

import com.example.database.NoteDatabase
import com.example.model.Note

class NoteRepository(private val db: NoteDatabase) {

    suspend fun insertNode(note : Note) = db.getNoteDao().insertNote(note)
    suspend fun deleteNote(note: Note) = db.getNoteDao().deleteNote(note)
    suspend fun updateNote(note: Note) = db.getNoteDao().updateNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String) = db.getNoteDao().searchNote(query)
}