package com.example.project2

import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.view.animation.AlphaAnimation
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2() : AppCompatActivity() {

    private var petHealth = 100
    private var petHunger = 50
    private var petCleanliness = 50

    constructor(parcel: Parcel) : this() {
        petHealth = parcel.readInt()
        petHunger = parcel.readInt()
        petCleanliness = parcel.readInt()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Get the button and the text views
        val feedbtn = findViewById<Button>(R.id.feedbtn)
        val cleanbtn = findViewById<Button>(R.id.cleanbtn)
        val happybtn = findViewById<Button>(R.id.playbtn)
        val txtHunger = findViewById<EditText>(R.id.txt_hunger_value)
        val txtClean = findViewById<EditText>(R.id.txt_clean_value)
        val txtHappy = findViewById<EditText>(R.id.txt_happy)
        val petImage = findViewById<ImageView>(R.id.pet_image)
        // Set the initial text values
        txtHunger.setText(petHunger.toString())
        txtClean.setText(petCleanliness.toString())
        txtHappy.setText(petHealth.toString())

        // Handle button click
        feedbtn.setOnClickListener {
            petHunger -= 10
            petHealth += 10
            petHunger += 5
            txtHunger.setText(petHunger.toString())
            animateImageChange
        }
        cleanbtn.setOnClickListener {
            petCleanliness += 10
            petHealth += 10
            txtClean.setText(petCleanliness.toString())
            txtHappy.setText(petHunger.toString())
            animateImageChange(petImage,R.drawable.eat_eating_icon)

            // Handle button Clicks
            feedbtn.setOnClickListener {
                petCleanliness += 10
                petHealth += 10

                txtClean.setText(petCleanliness.toString())
                animateImageChange(petImage, R.drawable.dog_cleaning_icon)
            }
            happybtn.setOnClickListener {
                petHealth += 10
                petHunger += 5
                petCleanliness -= 5
                txtHappy.setText(petHunger.toString())
                animateImageChange(petImage, R.drawable.dog_happy_icon)
            }
        }
    }

    private fun animateImageChange(imageView: ImageView, newImageResource: Int) {
        val animation = AlphaAnimation(0.0f, 1.0f)
        animation.duration = 500
        animation.fillAfter = true
        imageView.startAnimation(animation)
        imageView.setImageResource(newImageResource)
    }
}



