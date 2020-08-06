package com.cozii.coziiandroid.home.viewmodel

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.tenant.models.SuggestedRentals
import com.cozii.coziiandroid.home.tenant.models.TenantHomeOptions
import com.cozii.coziiandroid.profile.models.AddlandlordParams
import com.cozii.coziiandroid.profile.models.ProfileInterface
import com.cozii.coziiandroid.profile.models.ProfileOptions
import com.cozii.coziiandroid.profile.models.VerificationParams
import com.cozii.coziiandroid.threestepverification.models.VerificationDocs

class HomeSharedViewModel : ViewModel() {

    fun setTenantHomeOptions(context: Context): List<TenantHomeOptions> {
        return listOf(
            TenantHomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_first_option),
                "Request repairs from landlord"
            ),
            TenantHomeOptions(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_tenant_second_option
                ), "Book handyman"
            ),
            TenantHomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_third_option),
                "Pay rent & utilities"
            )
        )
    }

    fun setSuggestedRentalOptions(context: Context): List<SuggestedRentals> {
        return listOf(
            SuggestedRentals(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            ),
            SuggestedRentals(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            ),
            SuggestedRentals(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            ),
            SuggestedRentals(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            )
        )
    }

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