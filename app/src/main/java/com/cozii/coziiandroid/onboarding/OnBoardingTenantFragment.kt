package com.cozii.coziiandroid.onboarding

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentOnboardingBinding


class OnBoardingTenantFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = OnBoardingTenantFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    private lateinit var binding: FragmentOnboardingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnboardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        (activity as OnBoardViewPagerActivity).updateStatusBarColor("#3f2587")
        val position = requireArguments().getInt(ARG_POSITION)
        val onBoardingTitles =  resources.getStringArray(R.array.on_boarding_titles)
        val onBoardingImages = getOnBoardAssetsLocation()
        with(binding) {
            onBoardFirstLogo.setImageDrawable(onBoardingImages[position])
            welcome.text = onBoardingTitles[position]
        }
    }

    private fun getOnBoardAssetsLocation(): List<Drawable?> {
        return listOf(
            ContextCompat.getDrawable(requireContext(),R.drawable.first_on_board_tenant_logo),
            ContextCompat.getDrawable(requireContext(),R.drawable.second_onboard_tenant_logo),
            ContextCompat.getDrawable(requireContext(),R.drawable.third_onboard_tenant_logo),
            ContextCompat.getDrawable(requireContext(),R.drawable.fith_onboard_tenant_logo)
            )
    }
}
