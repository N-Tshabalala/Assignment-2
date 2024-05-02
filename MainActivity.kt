package com.example.houndfeeder20000

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.widget.EditText
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var petHealth = 200
        var petHunger = 100
        var petCleanliness = 100

        // Get the buttons and text views
        val btnFeed = findViewById<EditText>(R.id.btn_feed)
        val btnWash = findViewById<EditText>(R.id.btn_wash)
        val btnJoy = findViewById<EditText>(R.id.btn_play)
        val txtHunger = findViewById<EditText>(R.id.txt_Hungry)
        val txtWash = findViewById<EditText>(R.id.txt_wash)
        val txtJoy = findViewById<EditText>(R.id.txt_joy)
        val petImage = findViewById<ImageView>(R.id.imageView2)

        // Set the initial text values
        txtHunger.setText(petHunger.toString())
        txtWash.setText(petCleanliness.toString())
        txtJoy.setText(petHealth.toString())

        // Handle Button clicks
        btnFeed.setOnClickListener {
            petHunger += 11
            petHealth += 11
            petHunger += 9
            txtHunger.setText(petHunger.toString())
            animateImageChange(petImage, R.drawable.img_1)
        }

        btnWash.setOnClickListener {
            petCleanliness += 11
            petHealth += 11

            txtWash.setText(petCleanliness.toString())
            animateImageChange(petImage, R.drawable.img_1)
        }

        btnJoy.setOnClickListener {
            petHealth += 11
            petHunger += 6
            petCleanliness += 6
            txtJoy.setText(petHealth.toString())
            animateImageChange(petImage, R.drawable.img_1)
        }
    }
    private fun animateImageChange(imageView:ImageView,newImageResource: Int){
        val animation = AlphaAnimation(0.0f,1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}