package com.cozii.coziiandroid.signupandsigninbase.verifyemail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.layout_email_verification_dialog.*

class CustomVerifiedDialogFragment : DialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        isCancelable = false
        return inflater.inflate(R.layout.layout_email_verification_dialog, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        verified_next_button.setOnClickListener{

        }
    }

}