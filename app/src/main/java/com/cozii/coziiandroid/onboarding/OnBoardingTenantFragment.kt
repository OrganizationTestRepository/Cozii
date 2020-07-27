package com.cozii.coziiandroid.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cozii.coziiandroid.Home.OnBoardingLandingActivity
import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.fragment_onboarding.*
import kotlinx.android.synthetic.main.fragment_onboarding.tv_on_board_next
import kotlinx.android.synthetic.main.fragment_onboarding.tv_on_board_back


class OnBoardingTenantFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as OnBoardingLandingActivity).updateStatusBarColor("#3f2587")
        var counter = 1;

        tv_on_board_next.setOnClickListener {
            if (counter < 4)
                counter++;
            if (counter == 1) {
                on_board_first_logo.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.second_onboard_tenant_logo
                    )
                )

                welcome.setText(R.string.onboarding_description_3)
            }
            if (counter == 2) {
                on_board_first_logo.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.third_onboard_tenant_logo
                    )
                )
                welcome.setText(R.string.onboarding_description_5)
            }
            if (counter == 3) {
                on_board_first_logo.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.fith_onboard_tenant_logo
                    )
                )
                welcome.setText(R.string.onboarding_description_6)
                tv_tenant_salutation.setText(R.string.onboarding_description_7)
            }
            if (counter == 4) {

            }

        }

        tv_on_board_back.setOnClickListener {
            counter--;
            if (counter == 0) {
                it.findNavController()
                    .navigate(R.id.action_onBoardingTenantFragment_to_onBoardUserSelectionFragment)
            }
            if (counter == 1) {
                on_board_first_logo.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.second_onboard_tenant_logo
                    )
                )

                welcome.setText(R.string.onboarding_description_3)
            }
            if (counter == 2) {
                on_board_first_logo.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.third_onboard_tenant_logo
                    )
                )
                welcome.setText(R.string.onboarding_description_5)
                tv_tenant_salutation.setText(R.string.onboarding_description_0)
            }
            if (counter == 3) {
                on_board_first_logo.setImageDrawable(
                    ContextCompat.getDrawable(
                        context!!,
                        R.drawable.fith_onboard_tenant_logo
                    )
                )
                welcome.setText(R.string.onboarding_description_6)
                tv_tenant_salutation.setText(R.string.onboarding_description_0)
            }

        }

    }
}
