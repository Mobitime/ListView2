package com.example.listview

import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Collections.list

class MainActivity : AppCompatActivity() {

   private val notesList = mutableListOf<String>()
    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listViewLV: ListView
    private lateinit var editTextET: EditText
    private lateinit var saveBTN: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextET = findViewById(R.id.editTextET)
        saveBTN = findViewById(R.id.saveBTN)
        listViewLV = findViewById(R.id.listViewLV)
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1,notesList)
        listViewLV.adapter = adapter

        saveBTN.setOnClickListener{
            val note = editTextET.text.toString()
            if (note.isNotEmpty()){
                notesList.add(note)
                adapter.notifyDataSetChanged()
                editTextET.text.clear()
            }
        }
         listViewLV.setOnItemClickListener {_,_, position, _ ->
          val note = notesList[position]
        val Dialog = Dialog()
        Dialog.showDialog(this, "Удалить заметку '$note'?"){
        notesList.removeAt(position)
        adapter.notifyDataSetChanged()
    }
}
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when ( item.itemId){
            R.id.action_exit ->{
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}