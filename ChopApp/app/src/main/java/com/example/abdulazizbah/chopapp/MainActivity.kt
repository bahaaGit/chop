package com.example.abdulazizbah.chopapp

import android.graphics.BitmapFactory
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.graphics.drawable.RoundedBitmapDrawable
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    val foodList = arrayListOf("Benachin","Chinese","Vege Burger","Tuna Cesar Salad","Nyebeh","yohus","shrimps")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var imageView = findViewById(R.id.circularImageView) as ImageView
        var bitmap = BitmapFactory.decodeResource(resources, R.drawable.choplogo)
        val roundedBitmapDrawable = RoundedBitmapDrawableFactory.create(resources,bitmap)
        roundedBitmapDrawable. setCircular(true)
        imageView.setImageDrawable(roundedBitmapDrawable)

        pickMealBtn.setOnClickListener {
            //println("clicked")
            val random = Random()
            val randomFood = random.nextInt(foodList.count())
            selecteFood.text = foodList[randomFood]
        }
        addFoodBtn.setOnClickListener {
            val newFood = addNewFood.text.toString()
            if(!foodList.contains(newFood)){
                foodList.add(newFood)
            }else{
                Toast.makeText(this,"Food Already added", Toast.LENGTH_SHORT).show()
            }

            addNewFood.text.clear()
        }
    }
}
