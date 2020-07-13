package com.cozii.coziiandroid.coziicustomviews

import android.content.Context
import android.graphics.Typeface

class Font {

    companion object {
        fun setTypeFont(context: Context, attributeSetXml: Int) : Typeface? {
            val fontName = when(attributeSetXml) {
                0 -> "Roboto-Medium.ttf"
                1 -> "Roboto-Regular.ttf"
                else -> null
            }
            return if (fontName != null){
                Typeface.createFromAsset(context.assets, "fonts/$fontName")
            }else {
                null
            }
        }
    }
}