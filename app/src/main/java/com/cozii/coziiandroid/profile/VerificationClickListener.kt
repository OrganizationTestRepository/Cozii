package com.cozii.coziiandroid.profile

import com.cozii.coziiandroid.profile.models.ProfileInterface

interface VerificationClickListener {
    fun onVerificationItemClick(data: ProfileInterface)
}