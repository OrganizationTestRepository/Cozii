package com.cozii.coziiandroid.payment.viewmodels

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.payment.models.CountrySpinnerItem

class PaymentInformationViewModel : ViewModel() {

    fun setPaymentCountries(context: Context): List<CountrySpinnerItem>{
        return listOf(
            CountrySpinnerItem(
                ContextCompat.getDrawable(context, R.drawable.ic_canada),
                "Canada"
            ),
            CountrySpinnerItem(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_united_states
                ), "United States"
            )
        )
    }
}