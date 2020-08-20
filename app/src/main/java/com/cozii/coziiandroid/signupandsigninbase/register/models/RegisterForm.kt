package com.cozii.coziiandroid.signupandsigninbase.register.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.cozii.coziiandroid.BR
import com.cozii.coziiandroid.R
import java.util.regex.Pattern


class RegisterForm : BaseObservable() {
    private val registerFirstFields = RegisterFirstFields()
    private val registerFirstErrorFields = RegisterFirstErrorFields()
    private val registerSecondFields = RegisterSecondFields()
    private val registerSecondErrorFields = RegisterSecondErrorFields()
    private val registerFirstClick = MutableLiveData<RegisterFirstFields>()
    private val registerSecondClick = MutableLiveData<RegisterSecondFields>()

    @Bindable
    fun isFirstRegisterValid(): Boolean {
        var valid = isFirstNameValid()
        valid = isLastNameValid() && valid
        notifyPropertyChanged(BR.firstNameError)
        notifyPropertyChanged(BR.lastNameError)
        return valid
    }

    @Bindable
    fun isSecondRegisterValid(): Boolean {
        var valid = isEmailValid()
        valid = isPasswordValid() && valid
        valid = isConfirmPasswordValid() && valid
        notifyPropertyChanged(BR.emailError)
        notifyPropertyChanged(BR.passwordError)
        notifyPropertyChanged(BR.confirmPasswordError)
        return valid
    }


    private fun isFirstNameValid(): Boolean {
        return when {
            registerFirstFields.firstname?.length!! > 2 -> {
                registerFirstErrorFields.firstname = null
                notifyPropertyChanged(BR.valid)
                true
            }
            registerFirstFields.firstname?.length!! in 1..2 -> {
                registerFirstErrorFields.firstname = R.string.invalid_first_name
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                registerFirstErrorFields.firstname = R.string.empty_first_name
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isLastNameValid(): Boolean {
        return when {
            registerFirstFields.lastname?.length!! > 2 -> {
                registerFirstErrorFields.lastname = null
                notifyPropertyChanged(BR.valid)
                true
            }
            registerFirstFields.lastname?.length!! in 1..2 -> {
                registerFirstErrorFields.lastname = R.string.invalid_last_name
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                registerFirstErrorFields.lastname = R.string.empty_last_name
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isEmailValid(): Boolean {
        if (registerSecondFields.email_address?.length!! > 0) {
            return if (isValidEmail(registerSecondFields.email_address)) {
                registerSecondErrorFields.email_address = null
                notifyPropertyChanged(BR.valid)
                true
            } else {
                registerSecondErrorFields.email_address = R.string.invalid_email
                notifyPropertyChanged(BR.valid)
                false
            }
        } else {
            registerSecondErrorFields.email_address = R.string.empty_email
            notifyPropertyChanged(BR.valid)
        }
        return false
    }

    private fun isPasswordValid(): Boolean {
        return when {
            registerSecondFields.password?.length!! > 2 -> {
                registerSecondErrorFields.password = null
                notifyPropertyChanged(BR.valid)
                true
            }
            registerSecondFields.password?.length!! in 1..2 -> {
                registerSecondErrorFields.password = R.string.invalid_password
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                registerSecondErrorFields.password = R.string.empty_password
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isConfirmPasswordValid(): Boolean {
        if (registerSecondFields.confirm_password?.length!! > 0) {
            return if (registerSecondFields.confirm_password == registerSecondFields.password) {
                registerSecondErrorFields.confirm_password = null
                notifyPropertyChanged(BR.valid)
                true
            } else {
                registerSecondErrorFields.confirm_password = R.string.non_matching_passwords
                notifyPropertyChanged(BR.valid)
                false
            }
        } else {
            registerSecondErrorFields.confirm_password = R.string.empty_password
            notifyPropertyChanged(BR.valid)
        }
        return false
    }

    // validating email id
    private fun isValidEmail(email: String?): Boolean {
        val emailPattern = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        val pattern = Pattern.compile(emailPattern)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun onFirstRegisterButtonClick() {
        if (isFirstRegisterValid()) {
            registerFirstClick.value = registerFirstFields
        }
    }

    fun getRegisterFirstFields(): MutableLiveData<RegisterFirstFields> {
        return registerFirstClick
    }

    fun getFirstRegisterFields(): RegisterFirstFields {
        return registerFirstFields
    }

    fun onSecondRegisterButtonClick() {
        if (isSecondRegisterValid()) {
            registerSecondClick.value = registerSecondFields
        }
    }

    fun getRegisterSecondFields(): MutableLiveData<RegisterSecondFields> {
        return registerSecondClick
    }

    fun getSecondRegisterFields(): RegisterSecondFields {
        return registerSecondFields
    }

    @Bindable
    fun getFirstNameError(): Int? {
        return registerFirstErrorFields.firstname
    }

    @Bindable
    fun getLastNameError(): Int? {
        return registerFirstErrorFields.lastname
    }

    @Bindable
    fun getEmailError(): Int? {
        return registerSecondErrorFields.email_address
    }

    @Bindable
    fun getPasswordError(): Int? {
        return registerSecondErrorFields.password
    }

    @Bindable
    fun getConfirmPasswordError(): Int? {
        return registerSecondErrorFields.confirm_password
    }
}