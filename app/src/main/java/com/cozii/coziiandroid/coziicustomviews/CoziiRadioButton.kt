package com.cozii.coziiandroid.coziicustomviews

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatRadioButton
import androidx.appcompat.widget.AppCompatTextView
import com.cozii.coziiandroid.R

class CoziiRadioButton : AppCompatRadioButton {

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        setFont(context,attrs)
    }

    private fun setFont(context: Context, attrs: AttributeSet?) {
        val array = context.obtainStyledAttributes(attrs, R.styleable.CoziiCustomView)
        val font = array.getInt(R.styleable.CoziiCustomView_font_name,-1)
        setCustomFontType(context,font)
        array.recycle()
    }

    private fun setCustomFontType(context: Context, font: Int) {
        val fontType = Font?.setTypeFont(context,font)
        typeface = fontType
    }
}