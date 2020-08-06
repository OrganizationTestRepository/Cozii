package com.cozii.coziiandroid.onboarding.viewmodel

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R

class OnBoardingSharedViewModel : ViewModel() {

    fun getOnBoardAssetsLocation(context: Context): List<Drawable?> {
        return listOf(
            ContextCompat.getDrawable(context, R.drawable.first_on_board_tenant_logo),
            ContextCompat.getDrawable(context, R.drawable.second_onboard_tenant_logo),
            ContextCompat.getDrawable(context, R.drawable.third_onboard_tenant_logo),
            ContextCompat.getDrawable(context, R.drawable.fith_onboard_tenant_logo)
        )
    }
}