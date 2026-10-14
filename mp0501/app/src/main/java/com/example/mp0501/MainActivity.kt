package com.example.mp0501

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.view.View
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var ivAnswer: ImageView   //문제 그림 위에 겹쳐 보이는 껍데기

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ivAnswer = findViewById(R.id.imageViewAnswer)

        //이벤트 리스너 객체를 하나 만들어 보기 4개에 똑같이 등록
        val listener = AnswerClickListener()
        findViewById<ImageView>(R.id.imageViewChoice1).setOnClickListener(listener)
        findViewById<ImageView>(R.id.imageViewChoice2).setOnClickListener(listener)
        findViewById<ImageView>(R.id.imageViewChoice3).setOnClickListener(listener)
        findViewById<ImageView>(R.id.imageViewChoice4).setOnClickListener(listener)
    }

    //이벤트 리스너 클래스: View.OnClickListener 인터페이스를 구현
    inner class AnswerClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            when (v?.id) {
                R.id.imageViewChoice1 -> checkAnswer(R.drawable.answer1, false)
                R.id.imageViewChoice2 -> checkAnswer(R.drawable.answer2, true)   //정답: 달팽이 껍데기
                R.id.imageViewChoice3 -> checkAnswer(R.drawable.answer3, false)
                R.id.imageViewChoice4 -> checkAnswer(R.drawable.answer4, false)
            }
        }
    }

    //고른 껍데기를 달팽이에 씌우고 정답 여부를 토스트로 출력
    private fun checkAnswer(imageRes: Int, isCorrect: Boolean) {
        ivAnswer.setImageResource(imageRes)
        ivAnswer.visibility = View.VISIBLE

        if (isCorrect) {
            Toast.makeText(this, "맞았습니다", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "틀렸습니다", Toast.LENGTH_SHORT).show()
        }
    }
}
