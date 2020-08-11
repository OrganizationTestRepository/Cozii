package com.cozii.coziiandroid.signupandsigninbase.login.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.cozii.coziiandroid.BR
import com.cozii.coziiandroid.R
import java.util.regex.Pattern


class LoginForm : BaseObservable() {
    private val fields = LoginFields()
    private val loginErrorFields = LoginErrorFields()
    private val loginButtonClick = MutableLiveData<LoginFields>()

    @Bindable
    fun isValid(): Boolean {
        var valid = isEmailValid()
        valid = isPasswordValid() && valid
        notifyPropertyChanged(BR.emailError)
        notifyPropertyChanged(BR.passwordError)
        return valid
    }


    private fun isEmailValid(): Boolean {
        if (fields.email?.length!! > 0) {
            return if (isValidEmail(fields.email)) {
                loginErrorFields.email = null
                notifyPropertyChanged(BR.valid)
                true
            } else {
                loginErrorFields.email = R.string.invalid_email
                notifyPropertyChanged(BR.valid)
                false
            }
        } else {
            loginErrorFields.email = R.string.empty_email
            notifyPropertyChanged(BR.valid)
        }
        return false
    }

    private fun isPasswordValid(): Boolean {
        return when {
            fields.password?.length!! > 2 -> {
                loginErrorFields.password = null
                notifyPropertyChanged(BR.valid)
                true
            }
            fields.password?.length!! in 1..2 -> {
                loginErrorFields.password = R.string.invalid_password
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                loginErrorFields.password = R.string.empty_password
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    // validating email id
    private fun isValidEmail(email: String?): Boolean {
        val emailPattern = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun onClick() {
        if (isValid()) {
            loginButtonClick.value = fields
        }
    }

    fun getLoginFields(): MutableLiveData<LoginFields> {
        return loginButtonClick
    }

    fun getFields(): LoginFields {
        return fields
    }

    @Bindable
    fun getEmailError(): Int? {
        return loginErrorFields.email
    }

    @Bindable
    fun getPasswordError(): Int? {
        return loginErrorFields.password
    }
}