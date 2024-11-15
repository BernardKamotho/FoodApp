package com.example.foodapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } //end insets

        //find the recylerView by use of its id.
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        //specify the layout manager
        val layoutmanager = LinearLayoutManager(applicationContext)

        //put the kayout manager to the recyclerview. It will be allinged vertically
        recyclerView.layoutManager = layoutmanager

        //access the recycycler adapater (The one that contains the data)
        val adapter = RecyclerAdapter(applicationContext)

        //Specicfy onto which adapter our recyclerview is getting data from
        recyclerView.adapter = adapter

        //DONE

    }
}