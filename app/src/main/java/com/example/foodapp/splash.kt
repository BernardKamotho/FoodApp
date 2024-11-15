package com.example.foodapp

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        } //end insets

        //get all the views by use of their ids
        val imageLeft = findViewById<ImageView>(R.id.imageLeft)
        val imageRight = findViewById<ImageView>(R.id.imageRight)
        val welcomeText = findViewById<TextView>(R.id.welcomeText)
        val signature = findViewById<TextView>(R.id.singature)

        //Animate the image coming from the left and bring it at the center
        imageLeft.animate().translationX(0f).setDuration(3000).setStartDelay(500).start()

        //Animate the image from the right
        imageRight.animate().translationX(0f).setDuration(3000).setStartDelay(500).start()

        //Animate the welcome text
        welcomeText.animate().translationY(0f).alpha(1f).setDuration(2000).setStartDelay(500).start()

        //animate the signature
        signature.animate().translationY(0f).alpha(1f).setDuration(2000).setStartDelay(500).start()



        //After the animation, navigate to the mainpage
        Handler().postDelayed({
            val mainPage = Intent(applicationContext, MainActivity::class.java)
            startActivity(mainPage)
            finish()
        }, 5000)
    }
}