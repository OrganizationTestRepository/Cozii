package com.cozii.coziiandroid.profile.viewmodel

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.profile.models.AddlandlordParams
import com.cozii.coziiandroid.profile.models.ProfileInterface
import com.cozii.coziiandroid.profile.models.ProfileOptions
import com.cozii.coziiandroid.profile.models.VerificationParams
import com.cozii.coziiandroid.threestepverification.models.VerificationDocs

class ProfileViewModel : ViewModel() {

    fun setVerificationList(context: Context): List<ProfileInterface> {
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
            AddlandlordParams("Add Landlord"),
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