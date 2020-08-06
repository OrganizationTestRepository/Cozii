package com.cozii.coziiandroid.home.tenant

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.home.tenant.adapters.SuggestedRentalsAdapter
import com.cozii.coziiandroid.home.tenant.adapters.TenantHomeOptionsAdapter
import com.cozii.coziiandroid.home.viewmodel.HomeSharedViewModel
import kotlinx.android.synthetic.main.fragment_tenant_home.*
import kotlinx.android.synthetic.main.home_rent_suggestion_layout.*

class TenantHomeFragment : Fragment() {

    private val homeViewModel: HomeSharedViewModel by activityViewModels()

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
        return inflater.inflate(R.layout.fragment_tenant_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.home_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(false)

        if (homeViewModel.checkVerificationStatus()) {
            rv_suggested_rentals.apply {
                layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
                adapter = SuggestedRentalsAdapter(homeViewModel.setSuggestedRentalOptions(context))
            }
        }

        rv_tenant_options.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TenantHomeOptionsAdapter(homeViewModel.setTenantHomeOptions(context))
        }

        layout_verification.setOnClickListener {
            it.findNavController().navigate(R.id.action_homeFragment_to_profileFragment)
        }
    }
}
