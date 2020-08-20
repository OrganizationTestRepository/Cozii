package com.cozii.coziiandroid.signupandsigninbase.binding

import android.annotation.SuppressLint
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.databinding.BindingAdapter
import com.cozii.coziiandroid.R


@BindingAdapter("error")
fun setError(editText: EditText, strOrResId: Any?) {
    if (strOrResId is Int) {
        editText.error = editText.context.getString((strOrResId as Int?)!!)
    } else {
        editText.error = strOrResId as String?
    }
}

@SuppressLint("ClickableViewAccessibility")
@BindingAdapter(value = ["showPassword", "typeOfPage"])
fun showOrHidePassword(editText: EditText, value: Boolean, page: String) {
    if (value)
        editText.setOnTouchListener(OnTouchListener { _, event ->
            val DRAWABLE_END = 2
            if (event.action == MotionEvent.ACTION_DOWN) {
                if (event.rawX >= editText.right - editText.compoundDrawables[DRAWABLE_END].bounds.width()) {
                    if (editText.tag.toString() == "0") {
                        editText.tag = 1
                        if (page == "login")
                            editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                R.drawable.ic_password,
                                0,
                                R.drawable.ic_visible,
                                0
                            )
                        else {
                            editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                0,
                                0,
                                R.drawable.ic_visible,
                                0
                            )
                        }
                        editText.transformationMethod = PasswordTransformationMethod.getInstance()
                    } else if (editText.tag.toString() == "1") {
                        editText.tag = 0
                        if (page == "login")
                            editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                R.drawable.ic_password,
                                0,
                                R.drawable.ic_invisible,
                                0
                            )
                        else {
                            editText.setCompoundDrawablesRelativeWithIntrinsicBounds(
                                0,
                                0,
                                R.drawable.ic_invisible,
                                0
                            )
                        }
                        editText.transformationMethod =
                            HideReturnsTransformationMethod.getInstance()
                    }
                    return@OnTouchListener true
                }
            }
            false
        })
}