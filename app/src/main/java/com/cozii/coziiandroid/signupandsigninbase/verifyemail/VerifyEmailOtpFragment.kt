package com.cozii.coziiandroid.signupandsigninbase.verifyemail

import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.fragment_verify_email_otp.*

class VerifyEmailOtpFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verify_email_otp, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        confirm_otp_button.setOnClickListener{
            val handler = Handler()
            handler.postDelayed({
                layout_verification_parent.setBackgroundColor(Color.parseColor("#d83f2587"))
            }, 100)
            it.findNavController().navigate(R.id.action_verifyEmailOtpFragment_to_customVerifiedDialogFragment2)
        }
    }
}
