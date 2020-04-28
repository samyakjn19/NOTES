package com.example.myapplication

import android.content.Intent
import android.database.Cursor
import android.os.Build.ID
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.Button
import android.widget.GridLayout
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Sqlite.Companion.TB_name
import com.example.myapplication.Sqlite.Companion.id
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_subject.*

class MainActivity : AppCompatActivity() {


    lateinit var lists: ArrayList<subject>
    lateinit var DB : Sqlite
    lateinit var data: Cursor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val go = findViewById<Button>(R.id.go_subject)

        // first project


        go.setOnClickListener{


            startActivity(Intent(this@MainActivity,add_subjects::class.java))


        }


        lists = ArrayList<subject>()
        DB = Sqlite(applicationContext)
        data = DB.data_geter


        val adaptar = adaptar(applicationContext,lists)
        val recycler = findViewById<RecyclerView>(R.id.list)

        ShowDAta()

        list.layoutManager = GridLayoutManager(applicationContext,2)
        list.adapter = adaptar
    }

    fun ShowDAta(){


        if (data.count == 0) {

            Toast.makeText(applicationContext,"THERE IS NO ITEMS",Toast.LENGTH_SHORT).show()

        }


        while (data.moveToNext()) {


            lists.add(subject(data.getString(0),
                        data.getString(1),
                data.getString(2)))

        }


    }

    override fun onStart() {
        super.onStart()
        ShowDAta()
    }





}
