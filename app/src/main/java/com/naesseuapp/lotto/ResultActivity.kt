package com.naesseuapp.lotto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.TextureView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_result.*
import java.text.SimpleDateFormat
import java.util.*

class ResultActivity : BaseActivity() {

    val lottoImageStartId = R.drawable.num1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        setupEvents()
        setupValues()
    }
    override fun setupEvents() {

    }

    override fun setupValues() {
        // 전달받은 결과 배열을 가져옴
        val result = intent.getIntegerArrayListExtra("result")
        // 전달받은 이름 가져옴
        var name = intent.getStringExtra("name")
        // 전달받은 별자리 가져옴
        var constellation = intent.getStringExtra("constellation")

        // 결과화면 기본 텍스트
        resultLabel.text = "랜덤으로 생성된\n로또번호입니다"

        //name 이 전달된 경우 결과화면 텍스트
        if(!TextUtils.isEmpty(name)){
            resultLabel.text = "${name} 님의\n${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n로또번호 입니다."
        }

        //별자리가 전달된 경우 텍스트 변경
        if(!TextUtils.isEmpty(constellation)){
            resultLabel.text = "${constellation}의\n" +
                    "${SimpleDateFormat("yyyy년 MM월 dd일").format(Date())}\n" +
                    "로또번호 입니다."
        }


        // 전달받은 결과가 있는 경우에만 실행
        result?.let {
            // 결과에 맞게 로또 공 이미지를 업데이트한다.
            // 전달받은 결과는 정렬되지 있지 않으므로 정렬해서 전달한다.
            updateLottoBallImage(result.sortedBy { it })
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