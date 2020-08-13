package com.cozii.coziiandroid.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentTenantHomeBinding
import com.cozii.coziiandroid.home.adapters.HomeSuggestionsAdapter
import com.cozii.coziiandroid.home.adapters.HomeOptionsAdapter
import com.cozii.coziiandroid.home.viewmodel.HomeViewModel
import com.cozii.coziiandroid.onboarding.viewmodel.OnBoardingSharedViewModel
import com.cozii.coziiandroid.util.stringPreference
import kotlinx.android.synthetic.main.fragment_tenant_home.*
import kotlinx.android.synthetic.main.home_rent_suggestion_layout.*

class HomeFragment : Fragment() {

    private val homeViewModel: HomeViewModel by activityViewModels()

    private lateinit var binding: FragmentTenantHomeBinding

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
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_tenant_home, container, false)

        binding.homeViewModel = homeViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.home_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(false)

        rv_suggested_rentals.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter =
                HomeSuggestionsAdapter(
                    homeViewModel.setHomeSuggestionsForUser(context)
                )
        }

        rv_tenant_options.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = HomeOptionsAdapter(
                homeViewModel.setHomeOptionsForUser(context)
            )
        }

        layout_verification.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }
}
