package com.cozii.coziiandroid.profile.viewmodel

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel
import com.cozii.coziiandroid.profile.models.AddlandlordParams
import com.cozii.coziiandroid.profile.models.ProfileInterface
import com.cozii.coziiandroid.profile.models.ProfileOptions
import com.cozii.coziiandroid.profile.models.VerificationParams
import com.cozii.coziiandroid.threestepverification.models.VerificationDocs
import com.cozii.coziiandroid.util.stringPreference

class ProfileViewModel : ViewModel() {

    private fun setVerificationList(context: Context): List<ProfileInterface> {
        return listOf(
            VerificationParams(
                ContextCompat.getDrawable(context, R.drawable.ic_id_verification),
                "ID verification"
            ),
            VerificationParams(
                ContextCompat.getDrawable(context, R.drawable.ic_edit_profile),
                "Edit Profile"
            ),
            VerificationParams(
                ContextCompat.getDrawable(context, R.drawable.ic_payment_method),
                "Payment method"
            ),
            AddlandlordParams(ContextCompat.getDrawable(context, R.drawable.ic_disabled_add_landlord),"Add Landlord"),
            AddlandlordParams(ContextCompat.getDrawable(context, R.drawable.ic_profile_disabled_home),"My properties"),
            AddlandlordParams(ContextCompat.getDrawable(context, R.drawable.ic_disabled_add_landlord),"Tenants"),
            ProfileOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_disabled_invite_icon),
                "Invite friends"
            ),
            ProfileOptions(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_disabled_payment_history
                ), "Service payment history"
            ),
            ProfileOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_disabled_settings_icon),
                "Settings"
            ),
            ProfileOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_disabled_help),
                "Help and support"
            ),
            ProfileOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_disabled_help),
                "Sign out"
            )
        )
    }

    fun filterProfileOptions(context: Context, userType: String?): MutableList<ProfileInterface> {
        val profileOptions = setVerificationList(context)
        val finalProfileOptions = profileOptions.toMutableList()
        if (userType == "Tenant") {
            finalProfileOptions.removeAt(4)
            finalProfileOptions.removeAt(4)
        } else if (userType == "Landlord") {
            finalProfileOptions.removeAt(3)
        }
        return finalProfileOptions
    }

    fun checkVerificationStatus(): Boolean {
        return true
    }

    fun setListOfVerificationDocsNeeded(context: Context): List<VerificationDocs> {
        return listOf(
            VerificationDocs(
                ContextCompat.getDrawable(context, R.drawable.ic_passport),
                "Passport"
            ),
            VerificationDocs(
                ContextCompat.getDrawable(context, R.drawable.ic_driving_license),
                "Driver’s License"
            ),
            VerificationDocs(
                ContextCompat.getDrawable(context, R.drawable.ic_national_doc),
                "National ID Card"
            ),
            VerificationDocs(
                ContextCompat.getDrawable(context, R.drawable.ic_residence_permit),
                "Residence Permit"
            )
        )
    }
}