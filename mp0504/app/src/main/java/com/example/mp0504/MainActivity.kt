package com.example.mp0504

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.ToggleButton

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

        val ivRoom = findViewById<ImageView>(R.id.imageViewRoom)
        val ivLight1 = findViewById<ImageView>(R.id.imageViewLight1)
        val ivLight2 = findViewById<ImageView>(R.id.imageViewLight2)
        val ivLight3 = findViewById<ImageView>(R.id.imageViewLight3)
        val tbLight = findViewById<ToggleButton>(R.id.toggleButtonLight)

        //토글 버튼의 상태(isChecked)가 바뀔 때마다 호출
        tbLight.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                //조명 켜기
                ivRoom.setImageResource(R.drawable.bg2)
                ivLight1.setImageResource(R.drawable.light21)
                ivLight2.setImageResource(R.drawable.light22)
                ivLight3.setImageResource(R.drawable.light23)
                tbLight.setBackgroundResource(R.drawable.on)
            } else {
                //조명 끄기
                ivRoom.setImageResource(R.drawable.bg1)
                ivLight1.setImageResource(R.drawable.light11)
                ivLight2.setImageResource(R.drawable.light12)
                ivLight3.setImageResource(R.drawable.light13)
                tbLight.setBackgroundResource(R.drawable.off)
            }
        }
    }
}