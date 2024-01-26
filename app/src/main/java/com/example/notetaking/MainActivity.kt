package com.example.notetaking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.database.NoteDatabase
import com.example.notetaking.databinding.ActivityMainBinding
import com.example.repository.NoteRepository
import com.example.viewmodel.NoteViewModel
import com.example.viewmodel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    lateinit var  noteViewModel : NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpViewModel()
    }

    private fun setUpViewModel() {
        val noteRepository = NoteRepository(NoteDatabase(this))

        val viewModelProviderFactory = NoteViewModelFactory(application,
            noteRepository)

        noteViewModel = ViewModelProvider(
            this,
            viewModelProviderFactory)[NoteViewModel::class.java]
    }
}

