package com.cozii.coziiandroid.threestepverification.adapters

import com.cozii.coziiandroid.threestepverification.models.VerificationDocs

interface DocumentClickListener {
    fun onDocumentItemClick(data: VerificationDocs)
}