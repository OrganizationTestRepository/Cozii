package com.cozii.coziiandroid.home.viewmodel

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.models.HomeSuggestions
import com.cozii.coziiandroid.home.models.HomeOptions
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel
import com.cozii.coziiandroid.util.stringPreference

class HomeViewModel : ViewModel() {

    private var typeOfUser = stringPreference(OnBoardingSharedViewModel.USER_TYPE, "cozii_android")
    private  var userType : String? = ""

    private fun setTenantHomeOptions(context: Context): List<HomeOptions> {
        return listOf(
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_first_option),
                "Request repairs from landlord", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_tenant_and_landlord_second_option
                ), "Book handyman", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_third_option),
                "Pay rent & utilities", View.GONE
            )
        )
    }

    private fun setLandlordHomeOptions(context: Context): List<HomeOptions> {
        return listOf(
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_landlord_first_option),
                "Track maintenance request", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_tenant_and_landlord_second_option
                ), "Book handyman", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_landlord_third_option),
                "Request payment from tenant", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_landlord_fourth_option),
                "Send notices", View.GONE
            )
        )
    }

    private fun setHandymanHomeOptions(context: Context): List<HomeOptions> {
        return listOf(
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_first_option),
                "Request repairs from landlord", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_tenant_and_landlord_second_option
                ), "Book handyman", View.VISIBLE
            ),
            HomeOptions(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_third_option),
                "Pay rent & utilities", View.GONE
            )
        )
    }

    fun setHomeOptionsForUser(context: Context): List<HomeOptions> {
        return when (typeOfUser.getValue(context, ::typeOfUser)) {
            "Tenant" -> {
                setTenantHomeOptions(context)
            }
            "Landlord" -> {
                setLandlordHomeOptions(context)
            }
            else -> setHandymanHomeOptions(context)
        }
    }

    private fun setSuggestedRentalOptions(context: Context): List<HomeSuggestions> {
        return listOf(
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_test),
                "Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"
            )
        )
    }

    private fun setSuggestedHappenings(context: Context): List<HomeSuggestions> {
        return listOf(
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            )
        )
    }

    private fun setSuggestedHandymanOptions(context: Context): List<HomeSuggestions> {
        return listOf(
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            ),
            HomeSuggestions(
                ContextCompat.getDrawable(context, R.drawable.ic_suggested_happening),
                "Get the home ready for warmer days with these service"
            )
        )
    }

    fun setHomeSuggestionsForUser(context: Context): List<HomeSuggestions> {
        userType = typeOfUser.getValue(context, ::typeOfUser)
        return when (userType) {
            "Tenant" -> {
                setSuggestedRentalOptions(context)
            }
            "Landlord" -> {
                setSuggestedHappenings(context)
            }
            else -> setSuggestedHandymanOptions(context)
        }
    }

    fun getSuggestionTitle(): String {
        return when (userType) {
            "Tenant" -> {
                "Suggest listing for rent"
            }
            "Landlord" -> {
                "See what’s happening"
            }
            else -> "Handyman"
        }
    }
}