package com.naesseuapp.lotto

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_name.*
import java.text.SimpleDateFormat
import java.util.*
import java.util.jar.Attributes
import kotlin.collections.ArrayList
import kotlin.random.Random

class NameActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name)

        setupEvents()
        setupValues()
    }

    override fun setupEvents() {
        // 로또 번호 확인 버튼의 클릭이벤트 리스너 설정
        goButton.setOnClickListener{

            if (TextUtils.isEmpty(editText.text.toString())) {
                Toast.makeText(mContext, "이름을 입력해주세요.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var intent = Intent(mContext, ResultActivity::class.java)
            intent.putIntegerArrayListExtra("result", ArrayList(getLottoNumbersFromHash(editText.text.toString())))
            intent.putExtra("name", editText.text.toString())
            startActivity(intent)
        }

        // 뒤로가기 버튼의 클릭이벤트 리스너 설정
        backButton.setOnClickListener {
            finish()
        }
    }

    override fun setupValues() {

    }

    /*입력받은 이름에 대한 해시코드를 사용하여 로또번호를 섞고 결과 반환*/
    fun getLottoNumbersFromHash(name : String):MutableList<Int>{
        var list = mutableListOf<Int>()

        for (number in 1..45){
            list.add(number)
        }

        var targetString = SimpleDateFormat("yyyy-MM-dd").format(Date()) + name

        list.shuffle(Random(targetString.hashCode().toLong()))

        return list.subList(0, 6)
    }

}