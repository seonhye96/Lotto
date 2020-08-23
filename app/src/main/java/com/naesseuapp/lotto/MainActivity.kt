package com.naesseuapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        랜덤으로 번호 생성 카드를 클릭 이벤트 리스너
        randomCard.setOnClickListener {

            val intent = Intent(this, ResultActivity::class.java)

            intent.putIntegerArrayListExtra("result", ArrayList(getRandomLottoNumbers()))

            startActivity(intent)
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

    //    랜덤으로 1~45 번중 하나의 번호를 생성하는 함수
    fun getRandomLottoNumber() : Int {
        //Random.nextInt 는 0~전달받은 파라미터 값 미만의 번호를 생성
        // ex) Random().nextInt(10) 은 0~9 까지의 무작위 수를 반환
        // 1~45 까지의 번호를 생성하려면 파라미터의 45를 넣고 결과값의 1을 더한다.
        return Random().nextInt(45)+1
    }

    // 랜덤으로 추출하여 6개의 로또 번호를 만드는 함수
    fun getRandomLottoNumbers() : MutableList<Int>{
        //무작위로 생성된 로또 번호를 저장할 가변 리스트 생성
        val lottoNumbers = mutableListOf<Int>()

        // 6번 반복하는 for문
        for (i in 1..6){
            var number = 0
            do{
                //랜덤한 번호를 추출해 number 변수에 저장
                number = getRandomLottoNumber()

                // lottoNumbers 에 number 변수의 값이 없을 때까지 반복
            }while (lottoNumbers.contains(number))

            // 이미 뽑은 리스트에 없는 번호가 나올때까지 반복했으므로 중복이 없는 상태
            // 추출된 번호를 뽑은 리스트에 추가
            lottoNumbers.add(number)
        }
        return lottoNumbers
    }
}