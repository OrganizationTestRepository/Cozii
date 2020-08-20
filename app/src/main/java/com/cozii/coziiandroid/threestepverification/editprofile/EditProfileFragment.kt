package com.cozii.coziiandroid.threestepverification.editprofile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentEditProfileBinding
import com.cozii.coziiandroid.home.CoziiHomeActivity


class EditProfileFragment : Fragment() {

    private val editProfileViewModel: EditProfileViewModel by activityViewModels()

    private lateinit var binding: FragmentEditProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_profile, container, false)

        binding.editProfileViewModel = editProfileViewModel

        binding.lifecycleOwner = viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.edit_profile_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)
    }
}
