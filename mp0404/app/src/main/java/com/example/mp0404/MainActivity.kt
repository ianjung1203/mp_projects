package com.example.mp0404


import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var etObjA: EditText   //거북이 개수 입력칸
    private lateinit var etObjB: EditText   //물고기 개수 입력칸

    //정답: turtle.png에는 거북이 2마리, fish.png에는 물고기 5마리
    private val answerA = 2
    private val answerB = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        etObjA = findViewById(R.id.editTextA)
        etObjB = findViewById(R.id.editTextB)
    }

    //버튼 클릭 시 호출되는 메서드
    fun onClickChoice(view: View?) {
        //입력된 값을 정수로 변환하여 변수에 저장 (빈칸이면 null)
        val partA = etObjA.text.toString().toIntOrNull()
        val partB = etObjB.text.toString().toIntOrNull()

        if (partA == answerA && partB == answerB) {
            Toast.makeText(this, "맞았습니다", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}