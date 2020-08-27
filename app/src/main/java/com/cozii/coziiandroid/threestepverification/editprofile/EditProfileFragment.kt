package com.cozii.coziiandroid.threestepverification.editprofile

import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.databinding.FragmentEditProfileBinding
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.google.android.libraries.places.api.Places
import java.util.*


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

        val apiKey = getString(R.string.api_key)
        if (!Places.isInitialized()){
            editProfileViewModel.initiatePlacesApi(requireContext(),apiKey)
        }

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.edit_profile_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        binding.etAddress.threshold = 4

        editProfileViewModel.placeList.observe(viewLifecycleOwner, Observer {
            binding.etAddress.setAdapter(ArrayAdapter(requireContext(), R.layout.select_address_dialog, it))
        })

        binding.etAddress.onItemClickListener = AdapterView.OnItemClickListener{
                parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position).toString()
            val addressList = editProfileViewModel.splitSelectedAddress(selectedItem)
            binding.etAddress.setText(addressList[0])
            binding.etCity.setText(addressList[1])
            binding.etProvince.setText(addressList[2])
            binding.etCountry.setText(addressList[3])
            binding.etPostalCode.setText(editProfileViewModel.getPostalCode(requireContext(),addressList[0]))

        }
    }
}
