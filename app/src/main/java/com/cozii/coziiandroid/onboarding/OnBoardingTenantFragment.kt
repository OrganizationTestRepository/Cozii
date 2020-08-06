package com.cozii.coziiandroid.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentOnboardingBinding
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel


class OnBoardingTenantFragment : Fragment() {

    private val onBoardingViewModel: OnBoardingSharedViewModel by activityViewModels()

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
        (activity as OnBoardingLandingActivity).updateStatusBarColor("#3f2587")
        val position = requireArguments().getInt(ARG_POSITION)
        val onBoardingSalutations = resources.getStringArray(R.array.on_boarding_salutation)
        val onBoardingTitles = resources.getStringArray(R.array.on_boarding_titles)
        val onBoardingImages =
            onBoardingViewModel.getOnBoardAssetsLocation(activity as OnBoardingLandingActivity)
        with(binding) {
            onBoardFirstLogo.setImageDrawable(onBoardingImages[position])
            welcome.text = onBoardingTitles[position]
            tvTenantSalutation.text = onBoardingSalutations[position]

        }
    }
}
