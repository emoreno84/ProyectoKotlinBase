/*
 * Copyright (C) 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.roomwordssample

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

/**
 * Activity for entering a word.
 */

class NewWordActivity : AppCompatActivity() {

    private val wordViewModel: WordViewModel by viewModels {
        WordViewModelFactory((application as WordsApplication).repository)
    }
    @SuppressLint("MissingInflatedId")
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_word)
        val editTextTitulo = findViewById<EditText>(R.id.edit_titulo)
        val editTextGenero = findViewById<EditText>(R.id.edit_genero)
        val editTextAutor = findViewById<EditText>(R.id.edit_autor)


        val button = findViewById<Button>(R.id.button_save)
        val buttonBack = findViewById<Button>(R.id.button_back)

        button.setOnClickListener {
            val replyIntent = Intent()

            if (TextUtils.isEmpty(editTextTitulo.text) || TextUtils.isEmpty(editTextGenero.text) || TextUtils.isEmpty(editTextAutor.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val titulo = editTextTitulo.text.toString()
                val genero = editTextGenero.text.toString()
                val autor = editTextAutor.text.toString()

                var book = Book(titulo, genero, autor)
                wordViewModel.insert(book)
/*              replyIntent.putExtra(EXTRA_REPLY, autor)
                replyIntent.putExtra(EXTRA_REPLY, genero)
                replyIntent.putExtra(EXTRA_REPLY, titulo)
                setResult(Activity.RESULT_OK, replyIntent)*/

            }
            finish()
        }

        buttonBack.setOnClickListener {
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }
}
