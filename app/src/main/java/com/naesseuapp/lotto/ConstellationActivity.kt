package com.naesseuapp.lotto

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CalendarView
import android.widget.DatePicker
import android.widget.SearchView
import kotlinx.android.synthetic.main.activity_constellation.*
import java.util.*
import kotlin.collections.ArrayList

class ConstellationActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_constellation)

        setupEvents()
        setupValues()
    }

    override fun setupEvents() {
        // 로또 번호 확인 버튼의 클릭이벤트 리스너 설정
        goResultButton.setOnClickListener{
            // ResultActivity 를 시작하는 인텐트를 만들고 startActivity 로 실행
            val intent = Intent(mContext, ResultActivity::class.java)

            //전달하는 리스트는 별자리의 해시코드로 생성한 로또 번호
            intent.putIntegerArrayListExtra("result", ArrayList(LottonumberMaker.getLottoNumbersFromHash(makeConstellationString(datePicker.month, datePicker.dayOfMonth))))

            // 별자리를 추가로 전달
            intent.putExtra("constellation", makeConstellationString(datePicker.month, datePicker.dayOfMonth))
            startActivity(intent)
        }
    }

    override fun setupValues() {
        //현재 DatePicker의 월, 일 정보로 별자리 텍스트 변경
        textView.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)

        //DatePicker의 날짜가 변화하면 별자리를 보여주는 텍스트뷰도 변경
        val calender = Calendar.getInstance()
        datePicker.init(calender.get(Calendar.YEAR), calender.get(Calendar.MONTH), calender.get(Calendar.DAY_OF_MONTH)
            , object : CalendarView.OnDateChangeListener, DatePicker.OnDateChangedListener{
                override fun onDateChanged(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
                    // 변경된 시점의 DatePicker 의 월, 일 정보로 별자리 텍스트 변경
                    textView.text = makeConstellationString(datePicker.month, datePicker.dayOfMonth)
                }

                override fun onSelectedDayChange(view: CalendarView, year: Int, monthOfYear: Int, dayOfMonth: Int) {

                }

            })
    }

    fun makeConstellationString(month : Int, day : Int) : String {
        val target = "${month + 1}${String.format("%02d", day)}".toInt()

        when (target) {
            in 101..119 -> return "염소자리"
            in 120..218 -> return "물병자리"
            in 219..320 -> return "물고기자리"
            in 321..419 -> return "양자리"
            in 420..520 -> return "황소자리"
            in 521..621 -> return "쌍둥이자리"
            in 622..722 -> return "게자리"
            in 723..822 -> return "사자자리"
            in 823..923 -> return "처녀자리"
            in 924..1022 -> return "천칭자리"
            in 1023..1122 -> return "전갈자리"
            in 1123..1224 -> return "사수자리"
            in 1225..1231 -> return "염소자리"
            else -> return "기타별자리"
        }
    }


}