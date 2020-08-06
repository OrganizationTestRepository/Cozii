package com.cozii.coziiandroid.signupandsigninbase.viewmodel

import androidx.lifecycle.ViewModel
import java.util.regex.Pattern

class SignUpAndSignInSharedViewModel : ViewModel() {

    // validating email id
    private fun isValidEmail(email: String): Boolean {
        val PATTERN = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$")
        val pattern = Pattern.compile(PATTERN)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }


    fun validateLoginCredentials(username: String,password: String): Boolean {
        if (!isValidEmail(username) || username == null) {
            return false
        }

        if (password == null && password.length < 6) {
            return false
        }

        return true
    }

    fun validateFirstRegisterCredentials(firstname: String,lastname: String): Boolean {
        if (firstname == null && firstname.length < 2) {
            return false
        }

        if (lastname == null && lastname.length < 2) {
            return false
        }

        return true
    }

}