package com.lamti.listdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    // RecyclerView = Το view της λίστας
    private lateinit var itemsRecyclerView: RecyclerView
    private lateinit var itemsAdapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // βρίσκουμε το recyclerView
        itemsRecyclerView = findViewById(R.id.myRecyclerView)

        // Ο αντάπτορας που ενώνει τα δεδομένα με τα views
        itemsAdapter = MyListAdapter(this@MainActivity) {
            Toast.makeText(this@MainActivity,it.description, Toast.LENGTH_SHORT).show()
        }

        // Βάζουμε στον recyclerView τον αντάπτορα που θα κρατάει τα δεδομένα μας
        itemsRecyclerView.adapter = itemsAdapter

        // Γεμίζουμε την  λίστα του αντάπτορα με δεδομένα
        itemsAdapter.submitList(DataRepository.data)
    }

}