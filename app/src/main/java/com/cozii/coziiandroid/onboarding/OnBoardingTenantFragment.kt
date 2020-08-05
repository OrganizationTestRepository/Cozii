package com.cozii.coziiandroid.onboarding

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.cozii.coziiandroid.Home.OnBoardingLandingActivity
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import kotlinx.android.synthetic.main.fragment_onboarding.*
import kotlinx.android.synthetic.main.fragment_onboarding.tv_on_board_next
import kotlinx.android.synthetic.main.fragment_onboarding.tv_on_board_back


class OnBoardingTenantFragment : Fragment() {

    companion object {
        private const val ARG_POSITION = "ARG_POSITION"

        fun getInstance(position: Int) = OnBoardingTenantFragment().apply {
            arguments = bundleOf(ARG_POSITION to position)
        }
    }

    private lateinit var binding: FragmentOnBoardingBinding

    override fun onCreateView(inflater: LayoutInflater,container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val position = requireArguments().getInt(ARG_POSITION)
        val onBoardingTitles = requireContext().resources.getStringArray(R.array.on_boarding_titles)
        val onBoardingTexts = requireContext().resources.getStringArray(R.array.on_boarding_texts)
        val onBoardingImages = getOnBoardAssetsLocation()
        with(binding) {
            onBoardingImage.setImageFromRaw(onBoardingImages[position])
            onBoardingTextTitle.text = onBoardingTitles[position]
            onBoardingTextMsg.text = onBoardingTexts[position]
        }
    }

    private fun getOnBoardAssetsLocation(): List<Int> {
        val onBoardAssets: MutableList<Int> = ArrayList()
        onBoardAssets.add(R.raw.on_board_img1_land)
        onBoardAssets.add(R.raw.on_board_img2_land)
        onBoardAssets.add(R.raw.on_board_img3_land)
        return onBoardAssets
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }


}
