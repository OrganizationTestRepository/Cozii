package com.cozii.coziiandroid.signupandsigninbase.register

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.signupandsigninbase.register.models.RegisterFirstFields
import com.cozii.coziiandroid.signupandsigninbase.register.models.RegisterForm
import com.cozii.coziiandroid.signupandsigninbase.register.models.RegisterSecondFields

class RegisterViewModel : ViewModel() {

    val page = "register"

    private var registerForm = RegisterForm()


    fun getRegisterForm(): RegisterForm {
        return registerForm
    }

    fun onFirstRegisterButtonClick() {
        registerForm.onFirstRegisterButtonClick()
    }

    fun getFirstRegisterFields(): MutableLiveData<RegisterFirstFields> {
        return registerForm.getRegisterFirstFields()
    }

    fun onSecondRegisterButtonClick() {
        registerForm.onSecondRegisterButtonClick()
    }

    fun getSecondRegisterFields(): MutableLiveData<RegisterSecondFields> {
        return registerForm.getRegisterSecondFields()
    }
}