package com.cozii.coziiandroid.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel
import com.cozii.coziiandroid.util.stringPreference
import kotlinx.android.synthetic.main.fragment_user_selection.*


class OnBoardUserSelectionFragment : Fragment(), View.OnClickListener {

    private val onBoardingViewModel: OnBoardingSharedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_user_selection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as OnBoardingLandingActivity).updateStatusBarColor("#3f2587")

        tv_on_board_next.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_onBoardUserSelectionFragment_to_onBoardViewPagerFragment)
        }

        tenant_view.setOnClickListener(this)
        landlord_view.setOnClickListener(this)
        handyman_view.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tenant_view -> {
                tenant_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.rectangular_outline_coloured
                )
                landlord_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.on_boarding_rectangle_outline
                )
                handyman_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.on_boarding_rectangle_outline
                )
                tv_on_board_back.visibility = View.VISIBLE
                tv_on_board_next.visibility = View.VISIBLE
                onBoardingViewModel.getSelectedUserType(requireContext(),"Tenant")
            }
            R.id.landlord_view -> {
                landlord_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.rectangular_outline_coloured
                )
                tenant_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.on_boarding_rectangle_outline
                )
                handyman_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.on_boarding_rectangle_outline
                )
                tv_on_board_back.visibility = View.VISIBLE
                tv_on_board_next.visibility = View.VISIBLE
                onBoardingViewModel.getSelectedUserType(requireContext(),"Landlord")
            }
            R.id.handyman_view -> {
                handyman_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.rectangular_outline_coloured
                )
                tenant_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.on_boarding_rectangle_outline
                )
                landlord_view.background = ContextCompat.getDrawable(
                    requireActivity(),
                    R.drawable.on_boarding_rectangle_outline
                )
                tv_on_board_back.visibility = View.VISIBLE
                tv_on_board_next.visibility = View.VISIBLE
                onBoardingViewModel.getSelectedUserType(requireContext(),"Handyman")
            }
            else -> {
                tv_on_board_back.visibility = View.GONE
                tv_on_board_next.visibility = View.GONE
            }
        }
    }

}
