package com.cozii.coziiandroid.signupandsigninbase.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.signupandsigninbase.login.models.LoginFields
import com.cozii.coziiandroid.signupandsigninbase.login.models.LoginForm

class LoginViewModel : ViewModel() {

    val page = "login"

    private var loginForm = LoginForm()


    fun getLogin(): LoginForm {
        return loginForm
    }

    fun onLoginButtonClick() {
        loginForm.onClick()
    }

    fun getLoginFields(): MutableLiveData<LoginFields> {
        return loginForm.getLoginFields()
    }
}