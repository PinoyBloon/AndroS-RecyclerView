package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class DetailDragonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_dragon)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val dragons = intent.getParcelableExtra<Dragons>(MainActivity.INTENT_PARCELABLE)

        val imgDragons = findViewById<ImageView>(R.id.img_item_photo)
        val nameDragons = findViewById<TextView>(R.id.item_name)
        val descDragons = findViewById<TextView>(R.id.item_description)

        imgDragons.setImageResource(dragons?.imgDragons!!)
        nameDragons.text = dragons.nameDragons
        descDragons.text = dragons.descDragons
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}