package com.naesseuapp.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    val lottoImageStartId = R.drawable.num1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val result = intent.getIntegerArrayListExtra("result")

        // 전달받은 결과가 있는 경우에만 실행
        result?.let {
            // 결과에 맞게 로또 공 이미지를 업데이트한다.
            // 전달받은 결과는 정렬되지 있지 않으므로 정렬해서 전달한다.
            updateLottoBallImage(result)
        }
    }

    fun updateLottoBallImage(result:List<Int>){
        if(result.size < 6) return

        imageView01.setImageResource(lottoImageStartId + (result[0] - 1))
        imageView02.setImageResource(lottoImageStartId + (result[1] - 1))
        imageView03.setImageResource(lottoImageStartId + (result[2] - 1))
        imageView04.setImageResource(lottoImageStartId + (result[3] - 1))
        imageView05.setImageResource(lottoImageStartId + (result[4] - 1))
        imageView06.setImageResource(lottoImageStartId + (result[5] - 1))
    }
}