package com.cozii.coziiandroid.threestepverification.editprofile.models

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.lifecycle.MutableLiveData
import com.cozii.coziiandroid.BR
import com.cozii.coziiandroid.R
import java.util.regex.Pattern


class EditProfileForm : BaseObservable() {
    private val editProfileFields = EditProfileFields()
    private val editProfileErrorFields = EditProfileErrorFields()
    private val saveButtonClick = MutableLiveData<EditProfileFields>()

    @Bindable
    fun isProfileDetailsValid(): Boolean {
        var valid = isFirstNameValid()
        valid = isLastNameValid() && valid
        valid = isEmailValid() && valid
        valid = isPhoneNumberValid() && valid
        valid = isStreetNameValid() && valid
        valid = isCityValid() && valid
        valid = isProvinceValid() && valid
        valid = isPostalCodeValid() && valid
        notifyPropertyChanged(BR.firstNameError)
        notifyPropertyChanged(BR.lastNameError)
        notifyPropertyChanged(BR.emailError)
        notifyPropertyChanged(BR.phoneError)
        notifyPropertyChanged(BR.streetNameError)
        notifyPropertyChanged(BR.cityNameError)
        notifyPropertyChanged(BR.provinceError)
        notifyPropertyChanged(BR.postalCodeError)
        return valid
    }

    private fun isFirstNameValid(): Boolean {
        return when {
            editProfileFields.firstname?.length!! > 2 -> {
                editProfileErrorFields.firstname = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.firstname?.length!! in 1..2 -> {
                editProfileErrorFields.firstname = R.string.invalid_first_name
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.firstname = R.string.empty_first_name
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isLastNameValid(): Boolean {
        return when {
            editProfileFields.lastname?.length!! > 2 -> {
                editProfileErrorFields.lastname = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.lastname?.length!! in 1..2 -> {
                editProfileErrorFields.lastname = R.string.invalid_last_name
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.lastname = R.string.empty_last_name
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }


    private fun isEmailValid(): Boolean {
        if (editProfileFields.email?.length!! > 0) {
            return if (isValidEmail(editProfileFields.email)) {
                editProfileErrorFields.email = null
                notifyPropertyChanged(BR.valid)
                true
            } else {
                editProfileErrorFields.email = R.string.invalid_email
                notifyPropertyChanged(BR.valid)
                false
            }
        } else {
            editProfileErrorFields.email = R.string.empty_email
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

    private fun isPhoneNumberValid(): Boolean {
        return when {
            editProfileFields.phone?.length!! > 6 -> {
                editProfileErrorFields.phone = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.phone?.length!! in 1..6 -> {
                editProfileErrorFields.phone = R.string.invalid_phone
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.phone = R.string.empty_phone
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isStreetNameValid(): Boolean {
        return when {
            editProfileFields.streetname?.length!! > 2 -> {
                editProfileErrorFields.streetname = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.streetname?.length!! in 1..2 -> {
                editProfileErrorFields.streetname = R.string.invalid_street
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.streetname = R.string.empty_street
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isCityValid(): Boolean {
        return when {
            editProfileFields.city?.length!! > 2 -> {
                editProfileErrorFields.city = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.city?.length!! in 1..2 -> {
                editProfileErrorFields.city = R.string.invalid_city
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.city = R.string.empty_city
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isProvinceValid(): Boolean {
        return when {
            editProfileFields.province?.length!! > 2 -> {
                editProfileErrorFields.province = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.province?.length!! in 1..2 -> {
                editProfileErrorFields.province = R.string.invalid_province
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.province = R.string.empty_province
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    private fun isPostalCodeValid(): Boolean {
        return when {
            editProfileFields.postalcode?.length!! == 5 -> {
                editProfileErrorFields.postalcode = null
                notifyPropertyChanged(BR.valid)
                true
            }
            editProfileFields.postalcode?.length!! in 1..5 -> {
                editProfileErrorFields.postalcode = R.string.invalid_postal_code
                notifyPropertyChanged(BR.valid)
                true
            }
            else -> {
                editProfileErrorFields.postalcode = R.string.empty_postal_code
                notifyPropertyChanged(BR.valid)
                false
            }
        }
    }

    fun onClick() {
        if (isProfileDetailsValid()) {
            saveButtonClick.value = editProfileFields
        }
    }

    fun getProfileFields(): MutableLiveData<EditProfileFields> {
        return saveButtonClick
    }

    fun getEditFields(): EditProfileFields {
        return editProfileFields
    }

    @Bindable
    fun getEmailError(): Int? {
        return editProfileErrorFields.email
    }

    @Bindable
    fun getFirstNameError(): Int? {
        return editProfileErrorFields.firstname
    }

    @Bindable
    fun getLastNameError(): Int? {
        return editProfileErrorFields.lastname
    }

    @Bindable
    fun getPhoneError(): Int? {
        return editProfileErrorFields.phone
    }

    @Bindable
    fun getStreetNameError(): Int? {
        return editProfileErrorFields.streetname
    }

    @Bindable
    fun getProvinceError(): Int? {
        return editProfileErrorFields.province
    }

    @Bindable
    fun getCityNameError(): Int? {
        return editProfileErrorFields.city
    }

    @Bindable
    fun getPostalCodeError(): Int? {
        return editProfileErrorFields.postalcode
    }
}