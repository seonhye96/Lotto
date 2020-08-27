package com.naesseuapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList
import kotlin.random.Random

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setupValues()
    }

    override fun setupEvents() {
//        랜덤으로 번호 생성 카드를 클릭 이벤트 리스너
        randomCard.setOnClickListener {

            val intent = Intent(mContext, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(LottonumberMaker.getShuffleLottoNumbers()))

            startActivity(intent)
        }

//        별자리로 번호 생성 카드를 클릭 이벤트 리스너
        constellationCard.setOnClickListener {
            startActivity(Intent(mContext, ConstellationActivity::class.java))
        }

//        이름으로 번호 생성 카드를 클릭 이벤트 리스너
        nameCard.setOnClickListener {
            startActivity(Intent(mContext, NameActivity::class.java))
        }
    }

    override fun setupValues() {

    }


}