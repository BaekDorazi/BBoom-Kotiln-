package com.baek.zombi.dutchpay

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var etPrice: EditText //가격 입력창
    lateinit var etPerson: EditText //사람 명수 입력창
    lateinit var tvResult: TextView //결과값
    lateinit var btnKakao: Button //카카오 버튼

    lateinit var btn1: Button
    lateinit var btn2: Button
    lateinit var btn3: Button
    lateinit var btn4: Button
    lateinit var btn5: Button
    lateinit var btn6: Button
    lateinit var btn7: Button
    lateinit var btn8: Button
    lateinit var btn9: Button
    lateinit var btn0: Button
    lateinit var btnBackspace: Button //<- 버튼
    lateinit var btnResult: Button //완료 버튼

    lateinit var mAdView: AdView //배너 광고

    var editFocus:Int = 0 //EditText 선택 한거 구분 0: etPrice, 1: etPerson

    val adRequest = AdRequest.Builder().build()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, getString(R.string.adAppId))

        init()
        listener()

        mAdView.loadAd(adRequest) //광고 load
    }

    private fun init() {
        etPrice = findViewById(R.id.et_price)
        etPerson = findViewById(R.id.et_person)
        tvResult = findViewById(R.id.tv_result)
        btnKakao = findViewById(R.id.btn_kakao)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn5 = findViewById(R.id.btn5)
        btn6 = findViewById(R.id.btn6)
        btn7 = findViewById(R.id.btn7)
        btn8 = findViewById(R.id.btn8)
        btn9 = findViewById(R.id.btn9)
        btn0 = findViewById(R.id.btn0)
        btnBackspace = findViewById(R.id.btn_backspace)
        btnResult = findViewById(R.id.btn_result)

        mAdView = findViewById(R.id.adView)
    }

    private fun listener() {
        btnKakao.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btn_kakao -> {

            }
            R.id.btn1 -> {
                selectNum(1)
            }
            R.id.btn2 -> {
                selectNum(2)
            }
            R.id.btn3 -> {
                selectNum(3)
            }
            R.id.btn4 -> {
                selectNum(4)
            }
            R.id.btn5 -> {
                selectNum(5)
            }
            R.id.btn6 -> {
                selectNum(6)
            }
            R.id.btn7 -> {
                selectNum(7)
            }
            R.id.btn8 -> {
                selectNum(8)
            }
            R.id.btn9 -> {
                selectNum(9)
            }
            R.id.btn0 -> {
                selectNum(0)
            }
            R.id.btn_backspace -> {

            }
            R.id.btn_result -> {

            }
        }
    }

    private fun selectNum(num: Int) {

    }
}
