package com.cozii.coziiandroid.onboarding

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentOnBoardViewPagerBinding
import com.cozii.coziiandroid.onboarding.adapter.OnBoardingAdapter
import com.cozii.coziiandroid.signupandsigninbase.SignUpAndSignInBaseActivity
import kotlinx.android.synthetic.main.fragment_on_board_view_pager.*


class OnBoardViewPagerFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentOnBoardViewPagerBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentOnBoardViewPagerBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as OnBoardingLandingActivity).updateStatusBarColor("#3f2587")

        val numberOfScreens = resources.getStringArray(R.array.on_boarding_tenant_titles).size
        val onBoardingAdapter = OnBoardingAdapter(this, numberOfScreens)
        binding.onBoardingViewPager.adapter = onBoardingAdapter

        setViewPagerDotControls(binding.onBoardingViewPager, onBoardingAdapter)

        tv_on_board_back.setOnClickListener(this)
        tv_on_board_next.setOnClickListener(this)
    }


    private fun setViewPagerDotControls(
        onBoardingViewPager: ViewPager2,
        onBoardingAdapter: OnBoardingAdapter
    ) {
        val dotsCount = onBoardingAdapter.itemCount
        var circularDots = arrayOfNulls<ImageView>(dotsCount)

        for (i in 0 until dotsCount) {
            circularDots[i] = ImageView(context)
            circularDots[i]?.setImageDrawable(
                ContextCompat.getDrawable(
                    requireContext(),
                    R.drawable.inactive_dot
                )
            )
            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(8, 0, 8, 0)
            binding.sliderDots.addView(circularDots[i], params)
        }

        circularDots[0]?.setImageDrawable(
            ContextCompat.getDrawable(
                requireContext(),
                R.drawable.active_dot
            )
        )

        onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                for (i in 0 until dotsCount) {
                    circularDots[i]?.setImageDrawable(
                        ContextCompat.getDrawable(
                            requireContext(),
                            R.drawable.inactive_dot
                        )
                    )
                }

                circularDots[position]?.setImageDrawable(
                    ContextCompat.getDrawable(
                        requireContext(),
                        R.drawable.active_dot
                    )
                )

            }
        })
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_on_board_back -> {
                if (getItemofViewpager(binding.onBoardingViewPager) in 1..3) {
                    binding.onBoardingViewPager.setCurrentItem(
                        getItemofViewpager(binding.onBoardingViewPager) - 1,
                        true
                    )
                } else if (getItemofViewpager(binding.onBoardingViewPager) == 0) {
                    activity?.finish()
                }
            }
            R.id.tv_on_board_next -> {
                if (getItemofViewpager(binding.onBoardingViewPager) in 0..2) {
                    binding.onBoardingViewPager.setCurrentItem(
                        getItemofViewpager(binding.onBoardingViewPager) + 1,
                        true
                    )
                } else if (getItemofViewpager(binding.onBoardingViewPager) == 3) {
                    val intent = Intent(
                        activity,
                        SignUpAndSignInBaseActivity::class.java
                    )
                    startActivity(intent)
                    activity?.finish()
                }
            }
        }
    }

    private fun getItemofViewpager(onBoardingViewPager: ViewPager2): Int {
        return onBoardingViewPager.currentItem
    }
}
