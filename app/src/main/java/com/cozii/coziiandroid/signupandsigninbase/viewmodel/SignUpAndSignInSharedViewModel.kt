package com.cozii.coziiandroid.signupandsigninbase.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.signupandsigninbase.login.models.LoginFields
import com.cozii.coziiandroid.signupandsigninbase.login.models.LoginForm

class SignUpAndSignInSharedViewModel : ViewModel() {
    private var loginForm = LoginForm()


    fun getLogin(): LoginForm{
        return loginForm
    }

    fun onLoginButtonClick() {
        loginForm.onClick()
    }

    fun getLoginFields(): MutableLiveData<LoginFields>{
        return loginForm.getLoginFields()
    }
}