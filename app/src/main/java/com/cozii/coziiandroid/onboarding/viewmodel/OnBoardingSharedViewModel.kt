package com.cozii.coziiandroid.onboarding.viewmodel

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.util.stringPreference

class OnBoardingSharedViewModel : ViewModel() {

    private var typeOfUser = stringPreference(USER_TYPE,"cozii_android")
    private lateinit var userType : String

    companion object Key {
        const val USER_TYPE = "cozii_android"
    }

    private fun getOnBoardAssetsTenant(context: Context): List<Drawable?> {
        return listOf(
            ContextCompat.getDrawable(context, R.drawable.first_on_board_tenant_logo),
            ContextCompat.getDrawable(context, R.drawable.second_onboard_tenant_logo),
            ContextCompat.getDrawable(context, R.drawable.third_onboard_tenant_logo),
            ContextCompat.getDrawable(context, R.drawable.fith_onboard_tenant_logo)
        )
    }

    private fun getOnBoardAssetsLandlord(context: Context): List<Drawable?> {
        return listOf(
            ContextCompat.getDrawable(context, R.drawable.first_onboard_landlord_logo),
            ContextCompat.getDrawable(context, R.drawable.second_onboard_landlord_logo),
            ContextCompat.getDrawable(context, R.drawable.third_onboard_landlord_logo),
            ContextCompat.getDrawable(context, R.drawable.first_onboard_landlord_logo)
        )
    }

    private fun getOnBoardAssetsHandyMan(context: Context): List<Drawable?> {
        return listOf(
            ContextCompat.getDrawable(context, R.drawable.handyman_first_onboard_logo),
            ContextCompat.getDrawable(context, R.drawable.handyman_onboard_second_logo),
            ContextCompat.getDrawable(context, R.drawable.handyman_third_onboard_logo),
            ContextCompat.getDrawable(context, R.drawable.handyman_fourth_onboard_logo)
        )
    }

    fun getSelectedUserType(context: Context, selectedUser: String){
        userType = selectedUser
        typeOfUser.setValue(context,::typeOfUser,selectedUser)
    }

    fun getOnBoardingImages(context: Context): List<Drawable?> {
        return if (userType.equals("Tenant")){
            getOnBoardAssetsTenant(context)
        }else if (userType.equals("Landlord")){
            getOnBoardAssetsLandlord(context)
        }else {
            getOnBoardAssetsHandyMan(context)
        }
    }
}