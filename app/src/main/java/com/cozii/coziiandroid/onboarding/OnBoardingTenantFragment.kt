package com.cozii.coziiandroid.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cozii.coziiandroid.R
import kotlinx.android.synthetic.main.fragment_onboarding_0.*
import kotlinx.android.synthetic.main.fragment_onboarding_2.*
import kotlinx.android.synthetic.main.fragment_onboarding_2.tv_on_board_next
import kotlinx.android.synthetic.main.fragment_onboarding_2.tv_on_board_back


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
        return inflater.inflate(R.layout.fragment_onboarding_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var counter = 1;

        tv_on_board_next.setOnClickListener{
            counter++;
            if(counter == 1){
                on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.second_onboard_tenant_logo))

                welcome.setText( R.string.onboarding_description_3)
            }
            if(counter == 2){
                on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.third_onboard_tenant_logo))
                welcome.setText( R.string.onboarding_description_5)
            }
            if(counter == 3){
                on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.fith_onboard_tenant_logo))
                welcome.setText( R.string.onboarding_description_6)
                tv_tenant_salutation.setText(R.string.onboarding_description_7)
            }

        }

        tv_on_board_back.setOnClickListener {
            counter--;
            if(counter == 1){
                on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!, R.drawable.second_onboard_tenant_logo))

                welcome.setText( R.string.onboarding_description_3)
            }
            if(counter == 2){
                on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.third_onboard_tenant_logo))
                welcome.setText( R.string.onboarding_description_5)
            }
            if(counter == 3){
                on_board_first_logo.setImageDrawable(ContextCompat.getDrawable(context!!,R.drawable.fith_onboard_tenant_logo))
                welcome.setText( R.string.onboarding_description_6)
                tv_tenant_salutation.setText(R.string.onboarding_description_7)
            }

        }


        }



}
