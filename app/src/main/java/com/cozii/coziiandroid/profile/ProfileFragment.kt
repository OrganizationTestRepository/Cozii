package com.cozii.coziiandroid.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.home.viewmodel.HomeSharedViewModel
import com.cozii.coziiandroid.profile.models.ProfileInterface
import com.cozii.coziiandroid.profile.models.VerificationParams
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment(),
    VerificationClickListener {

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
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.profile_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(false)

        rv_three_steps_verification.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = VerificationListAdapter(homeViewModel.setVerificationList(context),this@ProfileFragment)
        }
    }

    override fun onVerificationItemClick(data: ProfileInterface) {
        if (data is VerificationParams){
            if (data.verificationName.equals("ID verification",false)){
                this.findNavController().navigate(R.id.action_profileFragment_to_documentInfoLandingFragment)
            }else if (data.verificationName.equals("Edit Profile",false)){
                this.findNavController().navigate(R.id.action_profileFragment_to_editProfileFragment)
            }
        }
    }
}
