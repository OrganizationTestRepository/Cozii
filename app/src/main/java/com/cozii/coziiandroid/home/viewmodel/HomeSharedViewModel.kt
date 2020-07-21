package com.cozii.coziiandroid.home.viewmodel

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.tenant.models.SuggestedRentals
import com.cozii.coziiandroid.home.tenant.models.TenantHomeOptions

class HomeSharedViewModel : ViewModel() {

    fun setTenantHomeOptions(context : Context) : List<TenantHomeOptions>{
        return listOf(
            TenantHomeOptions(ContextCompat.getDrawable(context,R.drawable.ic_tenant_first_option),"Request repairs from landlord"),
            TenantHomeOptions(ContextCompat.getDrawable(context,R.drawable.ic_tenant_second_option),"Book handyman"),
            TenantHomeOptions(ContextCompat.getDrawable(context,R.drawable.ic_tenant_third_option),"Pay rent & utilities")
        )
    }

    fun setSuggestedRentalOptions(context: Context) : List<SuggestedRentals>{
        return listOf(
            SuggestedRentals(ContextCompat.getDrawable(context,R.drawable.ic_suggested_test),"Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"),
            SuggestedRentals(ContextCompat.getDrawable(context,R.drawable.ic_suggested_test),"Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"),
            SuggestedRentals(ContextCompat.getDrawable(context,R.drawable.ic_suggested_test),"Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway"),
            SuggestedRentals(ContextCompat.getDrawable(context,R.drawable.ic_suggested_test),"Suite 104  - 767 Dovercourt Rd, Toronto. 1 min to subway")
        )
    }
}