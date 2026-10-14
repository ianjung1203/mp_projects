package com.example.mp0505

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.ImageView
import android.widget.Switch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ivCat = findViewById<ImageView>(R.id.imageViewCat)
        val ivLamp = findViewById<ImageView>(R.id.imageViewLamp)
        val viewDim = findViewById<View>(R.id.viewDim)
        val swCat = findViewById<Switch>(R.id.switchCat)
        val swLight = findViewById<Switch>(R.id.switchLight)

        //'고양이' 스위치: ON이면 고양이 보이기, OFF면 숨기기
        swCat.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                ivCat.visibility = View.VISIBLE
            } else {
                ivCat.visibility = View.INVISIBLE
            }
        }

        //'라이트' 스위치: ON이면 조명 켜고 창밖 밝게, OFF면 반대로
        swLight.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                ivLamp.setImageResource(R.drawable.light32)
                viewDim.visibility = View.INVISIBLE
                swLight.setThumbResource(R.drawable.on3)
            } else {
                ivLamp.setImageResource(R.drawable.light31)
                viewDim.visibility = View.VISIBLE
                swLight.setThumbResource(R.drawable.off3)
            }
        }
    }
}