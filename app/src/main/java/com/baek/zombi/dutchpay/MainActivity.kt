package com.baek.zombi.dutchpay

import android.os.Bundle
import android.text.Editable
import android.text.Selection
import android.text.TextWatcher
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import java.text.DecimalFormat
import android.widget.Toast


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

    var editFocus: Int = 0 //EditText 선택 한거 구분 0: etPrice, 1: etPerson

    val adRequest = AdRequest.Builder().build()
    var pressedTime: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this, getString(R.string.adAppId))

        init()
        listener()

        etPrice.setInputType(0) //EditText 눌러도 키보드 안뜨도록
        etPerson.setInputType(0)

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
        etPrice.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        etPerson.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }
        })

        etPrice.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) editFocus = 0
            }
        })

        etPerson.setOnFocusChangeListener(object : View.OnFocusChangeListener {
            override fun onFocusChange(v: View?, hasFocus: Boolean) {
                if (hasFocus) editFocus = 1
            }
        })

        etPrice.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                etPrice.setText("")

                return false
            }
        })

        etPerson.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                etPerson.setText("")

                return false
            }
        })

        btnKakao.setOnClickListener(this)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
        btn6.setOnClickListener(this)
        btn7.setOnClickListener(this)
        btn8.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btn0.setOnClickListener(this)
        btnBackspace.setOnClickListener(this)
        btnResult.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
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
                lateinit var etSelect: EditText

                if (editFocus == 0) etSelect = etPrice
                else if (editFocus == 1) etSelect = etPerson

                selectBackSpace(etSelect)
            }
            R.id.btn_result -> {
                selectResult()
            }
        }
    }

    private fun selectNum(num: Int) {
        if (editFocus == 0) etPrice.setText(etPrice.getText().toString() + num)
        else if (editFocus == 1) etPerson.setText(etPerson.getText().toString() + num)
    }

    private fun selectBackSpace(et: EditText) {
        var tmpStr: String = et.getText().toString()
        var strLength: Int = tmpStr.length

        if (strLength > 0) et.setText(tmpStr.substring(0, strLength - 1))
    }

    private fun selectResult() {
        var price: Int = Integer.parseInt(etPrice.getText().toString())
        var person: Int = Integer.parseInt(etPerson.getText().toString())
        var strResult: String = getMoneyFormat((price / person).toString())
        tvResult.setText(strResult + " 원")
    }

    private fun getMoneyFormat(str: String): String {
        if (str.length == 0)
            return ""

        var value = Integer.parseInt(str)
        var moneyFormat: DecimalFormat = DecimalFormat("###,###")

        return moneyFormat.format(value)
    }

    override fun onBackPressed() {
        if (pressedTime == 0L) {
            Toast.makeText(this, "한번 더 누르면 종료됩니다.", Toast.LENGTH_LONG).show()
            pressedTime = System.currentTimeMillis()
        } else {
            val seconds = (System.currentTimeMillis() - pressedTime).toInt()

            if (seconds > 2000) {
                pressedTime = 0
            } else {
                finish()
            }
        }
    }
}
