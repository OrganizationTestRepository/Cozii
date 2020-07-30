package com.cozii.coziiandroid.threestepverification.adapters

import com.cozii.coziiandroid.profile.models.ProfileInterface

interface VerificationClickListener {
    fun onVerificationItemClick(data: ProfileInterface)
}