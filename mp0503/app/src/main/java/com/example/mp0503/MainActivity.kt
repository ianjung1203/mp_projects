package com.example.mp0503

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast

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

        val rgShadow = findViewById<RadioGroup>(R.id.radioGroupShadow)

        //라디오 버튼 선택이 바뀔 때마다 호출 (checkedId = 선택된 라디오 버튼의 id)
        rgShadow.setOnCheckedChangeListener { group, checkedId ->
            when (checkedId) {
                R.id.radioButton2 ->   //정답: 2번 그림자
                    Toast.makeText(this, "맞았습니다", Toast.LENGTH_SHORT).show()
                R.id.radioButton1, R.id.radioButton3, R.id.radioButton4 ->
                    Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
            }
        }

        //그림자 그림을 눌러도 위의 라디오 버튼이 선택되도록
        val pairs = listOf(
            R.id.imageViewShadow1 to R.id.radioButton1,
            R.id.imageViewShadow2 to R.id.radioButton2,
            R.id.imageViewShadow3 to R.id.radioButton3,
            R.id.imageViewShadow4 to R.id.radioButton4
        )
        for ((imageId, radioId) in pairs) {
            findViewById<ImageView>(imageId).setOnClickListener {
                findViewById<RadioButton>(radioId).isChecked = true
            }
        }
    }
}