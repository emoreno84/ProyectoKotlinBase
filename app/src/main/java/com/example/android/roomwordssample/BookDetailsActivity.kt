package com.example.android.roomwordssample

import android.content.ContentValues
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import com.google.android.material.floatingactionbutton.FloatingActionButton

class BookDetailsActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_details)

        val tvTitulo = findViewById<TextView>(R.id.tvTitulo)
        val tvGenero = findViewById<TextView>(R.id.tvGenero)
        val tvAutor = findViewById<TextView>(R.id.tvAutor)

        val intent = intent

        val titulo = intent?.getStringExtra("titulo")
        val genero = intent?.getStringExtra("genero")
        val autor = intent?.getStringExtra("autor")

        tvTitulo.text = titulo
        tvGenero.text = genero
        tvAutor.text = autor


        val buttonBack = findViewById<Button>(R.id.button_back)
        val btnDel = findViewById<Button>(R.id.button_delete)

        buttonBack.setOnClickListener {
            finish()
        }

        btnDel.setOnClickListener {
            //Log.d(ContentValues.TAG, "TITULO: " + tvTitulo.text);
            wordViewModel.delete(tvTitulo.text.toString())
            finish()
        }

    }
}