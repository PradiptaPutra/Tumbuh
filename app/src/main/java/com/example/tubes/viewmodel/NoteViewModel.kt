package com.example.tubes.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tubes.data.dao.NoteDao
import com.example.tubes.data.entity.Note
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val noteDao: NoteDao) : ViewModel() {

    val notes = noteDao.getAllNotes()
    val notesChannel= Channel<NotesEvent> ()
    val notesEvent = notesChannel.receiveAsFlow()

    fun insertNote(note: Note) = viewModelScope.launch {
        noteDao.insertNote(note)
        notesChannel.send(NotesEvent.NavigatioNotesFragment)
    }

    fun  updateNote(note: Note) = viewModelScope.launch {
        noteDao.updateNote(note)
        notesChannel.send(NotesEvent.NavigatioNotesFragment)
    }

    fun deleteNote(note: Note) = viewModelScope.launch {
        noteDao.deleteNote(note)
        notesChannel.send(NotesEvent.ShowUndoSnackBar("Catatan Telah Terhapus", note))
    }

    sealed class NotesEvent{
        data class ShowUndoSnackBar(val msg: String, val note: Note):NotesEvent()
        object NavigatioNotesFragment: NotesEvent()
    }

}