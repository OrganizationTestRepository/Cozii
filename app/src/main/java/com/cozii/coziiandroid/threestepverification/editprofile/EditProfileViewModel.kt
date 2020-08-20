package com.cozii.coziiandroid.threestepverification.editprofile

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.threestepverification.editprofile.models.EditProfileFields
import com.cozii.coziiandroid.threestepverification.editprofile.models.EditProfileForm

class EditProfileViewModel : ViewModel() {
    private var editProfileForm = EditProfileForm()


    fun getEditProfileForm(): EditProfileForm {
        return editProfileForm
    }

    fun onSaveButtonClick() {
        editProfileForm.onClick()
    }

    fun getEditProfileFields(): MutableLiveData<EditProfileFields> {
        return editProfileForm.getProfileFields()
    }
}