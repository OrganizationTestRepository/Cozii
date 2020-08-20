package com.cozii.coziiandroid.payment.viewmodels

import android.content.Context
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel
import com.cozii.coziiandroid.payment.models.PaymentMethods
import com.cozii.coziiandroid.util.stringPreference

class PaymentSelectionViewModel : ViewModel() {

    private var typeOfUser = stringPreference(OnBoardingSharedViewModel.USER_TYPE, "cozii_android")

    private fun setTenantPaymentOptions(context: Context): List<PaymentMethods> {
        return listOf(
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_credit_card),
                "Credit or Debit Card", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_paypal
                ), "PayPal", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_gift_card),
                "Gift Card", View.INVISIBLE
            )
        )
    }

    private fun setLandlordPaymentOptions(context: Context): List<PaymentMethods> {
        return listOf(
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_bank_account),
                "Bank Account", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_credit_card
                ), "Credit or Debit Card", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_paypal),
                "PayPal", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_gift_card),
                "Gift Card", View.INVISIBLE
            )
        )
    }

    private fun setHandymanHomeOptions(context: Context): List<PaymentMethods> {
        return listOf(
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_first_option),
                "Request repairs from landlord", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(
                    context,
                    R.drawable.ic_tenant_and_landlord_second_option
                ), "Book handyman", View.VISIBLE
            ),
            PaymentMethods(
                ContextCompat.getDrawable(context, R.drawable.ic_tenant_third_option),
                "Pay rent & utilities", View.INVISIBLE
            )
        )
    }

    fun setPaymentOptionsForUser(context: Context): List<PaymentMethods> {
        return when (typeOfUser.getValue(context, ::typeOfUser)) {
            "Tenant" -> {
                setTenantPaymentOptions(context)
            }
            "Landlord" -> {
                setLandlordPaymentOptions(context)
            }
            else -> setHandymanHomeOptions(context)
        }
    }
}