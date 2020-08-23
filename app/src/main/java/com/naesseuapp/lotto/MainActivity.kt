package com.naesseuapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        랜덤으로 번호 생성 카드를 클릭 이벤트 리스너
        randomCard.setOnClickListener {
//            ResultActivity를 시작하는 Intent 를 만들고 startActivity로 실행
            startActivity(Intent(this, ResultActivity::class.java))
        }

//        별자리로 번호 생성 카드를 클릭 이벤트 리스너
        constellationCard.setOnClickListener {
//            ConstellationActivity 를 시작하는 Intent 를 만들고 startActivity로 실행
            startActivity(Intent(this, ConstellationActivity::class.java))
        }

//        이름으로 번호 생성 카드를 클릭 이벤트 리스너
        nameCard.setOnClickListener {
//            NameActivity를 시작하는 Intent를 만들고 startActivity로 실행
            startActivity(Intent(this, NameActivity::class.java))
        }


    }
}