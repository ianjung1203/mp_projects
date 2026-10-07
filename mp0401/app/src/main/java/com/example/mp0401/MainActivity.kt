package com.example.mp0401

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    //주사위 이미지 리소스 배열 선언
    private val diceNumber = intArrayOf(
        R.drawable.dice1, R.drawable.dice2, R.drawable.dice3,
        R.drawable.dice4, R.drawable.dice5, R.drawable.dice6
    )

    private var numA = 0
    private var numB = 0
    private lateinit var etAnswer: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val ivDiceA = findViewById<ImageView>(R.id.imageViewDiceA)
        val ivDiceB = findViewById<ImageView>(R.id.imageViewDiceB)
        etAnswer = findViewById(R.id.editTextAnswer)

        //주사위 값(1~6) 랜덤으로 설정
        numA = (1..6).random()
        numB = (1..6).random()

        //주사위 값에 맞는 이미지 출력 (배열 인덱스는 0부터라서 -1)
        ivDiceA.setImageResource(diceNumber[numA - 1])
        ivDiceB.setImageResource(diceNumber[numB - 1])
    }

    //<결과보기> 버튼 클릭 시 호출되는 메서드 (xml의 android:onClick과 이름이 같아야 함)
    fun onClickResult(view: View) {
        val input = etAnswer.text.toString().toIntOrNull()   //빈칸이면 null

        if (input == null) {
            Toast.makeText(this, "숫자를 입력하세요", Toast.LENGTH_SHORT).show()
        } else if (input == numA + numB) {
            Toast.makeText(this, "맞았습니다", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}

