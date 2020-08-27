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
            intent.putIntegerArrayListExtra("result", ArrayList(LottonumberMaker.getLottoNumbersFromHash(editText.text.toString())))
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



}