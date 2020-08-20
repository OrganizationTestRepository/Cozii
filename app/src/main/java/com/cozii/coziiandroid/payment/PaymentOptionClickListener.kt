package com.cozii.coziiandroid.payment

import com.cozii.coziiandroid.payment.models.PaymentMethods
import com.cozii.coziiandroid.profile.models.ProfileInterface

interface PaymentOptionClickListener {
    fun onPaymentOptionClick(data: PaymentMethods)
}