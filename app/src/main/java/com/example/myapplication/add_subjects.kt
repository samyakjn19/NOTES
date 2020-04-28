package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class add_subjects : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_subjects)



        var DB = Sqlite(applicationContext)
        var title_input = findViewById<EditText>(R.id.title_edit_text)
        var desc_input = findViewById<EditText>(R.id.desc_edit_text)
        var Add_subject = findViewById<Button>(R.id.add_sunject)

        Add_subject.setOnClickListener{

            val title_text = title_input.text.toString().trim()
            val desc_text = desc_input.text.toString().trim()

            DB.add_data(title_text,desc_text)
            Toast.makeText(this@add_subjects , "THE SUBJECT HAS BEEN ADDED",Toast.LENGTH_SHORT).show()

            startActivity(Intent(this@add_subjects,MainActivity::class.java))

            //part5


        }



    }
}
