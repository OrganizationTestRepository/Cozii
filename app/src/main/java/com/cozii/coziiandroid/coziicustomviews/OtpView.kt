package com.cozii.coziiandroid.coziicustomviews

import android.content.Context
import android.text.Editable
import android.text.InputFilter
import android.text.InputType
import android.text.TextWatcher
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.KeyEvent
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatEditText
import androidx.core.content.ContextCompat
import com.cozii.coziiandroid.R

class OtpView : LinearLayout {

    private val lengthFilter = InputFilter.LengthFilter(1)

    constructor(context: Context?) : super(context){
        setUpView()
    }

    constructor(context: Context?,attributeSet: AttributeSet?) : super(context,attributeSet) {
        setUpView()
    }

    companion object {
        const val digitCount = 4
    }


    private fun setUpView(){
        orientation = HORIZONTAL
        gravity = Gravity.CENTER
        for (i in 0 until digitCount){
            val editText = AppCompatEditText(context)
            editText.tag = i
            editText.filters = arrayOf<InputFilter>(lengthFilter)
            editText.inputType = InputType.TYPE_CLASS_NUMBER
            editText.isCursorVisible = false
            editText.gravity = Gravity.CENTER
            editText.setTextColor(ContextCompat.getColor(context,R.color.color_text_otp))
            editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
            val params = LayoutParams(
                resources.getDimension(R.dimen.otp_height).toInt(),
                resources.getDimension(R.dimen.otp_height).toInt(),1F
            )
            when (i) {
                0 -> {
                    editText.background = ContextCompat.getDrawable(context,R.drawable.background_left_otp_box)
                }
                1 -> {
                    editText.background = ContextCompat.getDrawable(context,R.drawable.background_full_otp_box)
                }
                2 -> {
                    editText.background = ContextCompat.getDrawable(context,R.drawable.background_middle_otp_box)
                }
                else -> {
                    editText.background = ContextCompat.getDrawable(context,R.drawable.background_right_otp_box)
                }
            }
            editText.layoutParams = params
            editText.addTextChangedListener(textWatcher)
            editText.setOnKeyListener(keyListener)
            addView(editText)
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(s: Editable?) {
            checkOTP()
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            println("OtpView --- Textwatcher OnTextViewChanged ----$s")
        }

    }

    private val keyListener = OnKeyListener { v, _, event ->
        if (event.keyCode == KeyEvent.KEYCODE_DEL){
            val tag = v.tag as Int
            val edt = v as AppCompatEditText
            if (tag > 0 && edt.text != null && edt.text!!.isEmpty()) {
                val nextEdt = getChildAt(tag - 1) as AppCompatEditText
                nextEdt.requestFocus()
            }
        }
        false
    }

    private fun checkOTP(){
        for (i in 0 until digitCount - 1) {
            val editText = getChildAt(i) as AppCompatEditText
            if (editText.text != null && editText.text!!.length == 1) {
                val nextEdt = getChildAt(i + 1) as AppCompatEditText
                nextEdt.requestFocus()
            }
        }
    }
}