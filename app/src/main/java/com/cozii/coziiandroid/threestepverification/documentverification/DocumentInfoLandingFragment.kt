package com.cozii.coziiandroid.threestepverification.documentverification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import kotlinx.android.synthetic.main.fragment_document_info_landing.*

class DocumentInfoLandingFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document_info_landing, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.document_info_landing_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        verify_now_button.setOnClickListener {
            it.findNavController().navigate(R.id.action_documentInfoLandingFragment_to_documentSlectionFragment)
        }
    }
}
