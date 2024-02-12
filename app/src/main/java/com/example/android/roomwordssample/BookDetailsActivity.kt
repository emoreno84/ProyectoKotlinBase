package com.example.android.roomwordssample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class BookDetailsActivity : AppCompatActivity() {
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
        buttonBack.setOnClickListener {
            finish()
        }
    }
}