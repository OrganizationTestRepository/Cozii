package com.cozii.coziiandroid.signupandsigninbase.binding

import android.widget.EditText
import androidx.databinding.BindingAdapter

@BindingAdapter("error")
fun setError(editText: EditText, strOrResId: Any?) {
    if (strOrResId is Int) {
        editText.error = editText.context.getString((strOrResId as Int?)!!)
    } else {
        editText.error = strOrResId as String?
    }
}