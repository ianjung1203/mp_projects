package com.example.mp0502


import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var checkBoxes: List<CheckBox>
    private lateinit var tvResult: TextView
    private lateinit var btnResult: Button

    //체크박스 순서(1~4)에 맞춘 물건 이름과 정답 여부
    private val itemNames = listOf("소방차", "핸드믹서", "청진기", "소방장갑")
    private val isAnswer = listOf(true, false, false, true)   //정답: 소방차, 소방장갑

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        checkBoxes = listOf(
            findViewById(R.id.checkBox1), findViewById(R.id.checkBox2),
            findViewById(R.id.checkBox3), findViewById(R.id.checkBox4)
        )
        tvResult = findViewById(R.id.textViewResult)
        btnResult = findViewById(R.id.buttonResult)

        //그림을 눌러도 옆의 체크박스가 체크/해제되도록
        val images = listOf<ImageView>(
            findViewById(R.id.imageViewItem1), findViewById(R.id.imageViewItem2),
            findViewById(R.id.imageViewItem3), findViewById(R.id.imageViewItem4)
        )
        for (i in images.indices) {
            images[i].setOnClickListener { checkBoxes[i].toggle() }
        }

        //<결과보기> / <재시작하기> 버튼
        btnResult.setOnClickListener {
            if (btnResult.text.toString() == "결과보기") {
                showResult()
            } else {
                restart()
            }
        }
    }

    private fun showResult() {
        //선택한 물건 이름 모으기 (isChecked로 체크 상태 확인)
        val selected = mutableListOf<String>()
        var correct = true
        for (i in checkBoxes.indices) {
            if (checkBoxes[i].isChecked) selected.add(itemNames[i])
            if (checkBoxes[i].isChecked != isAnswer[i]) correct = false
        }

        if (selected.isEmpty()) {
            Toast.makeText(this, "선택한 물건이 없습니다.", Toast.LENGTH_SHORT).show()
            return
        }

        //선택한 물건 이름을 토스트로 출력
        Toast.makeText(this, selected.joinToString(", ") + "을(를) 선택했습니다.", Toast.LENGTH_SHORT).show()

        //정답 여부를 버튼 아래에 출력
        tvResult.text = if (correct) "맞았습니다" else "틀렸습니다"
        btnResult.text = "재시작하기"
    }

    private fun restart() {
        for (cb in checkBoxes) cb.isChecked = false
        tvResult.text = "소방관의 용품을 선택해주세요"
        btnResult.text = "결과보기"
    }
}