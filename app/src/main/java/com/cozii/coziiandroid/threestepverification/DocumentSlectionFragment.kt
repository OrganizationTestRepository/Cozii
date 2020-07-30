package com.cozii.coziiandroid.threestepverification

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.home.viewmodel.HomeSharedViewModel
import com.cozii.coziiandroid.threestepverification.adapters.VerificationDocsListAdapter
import kotlinx.android.synthetic.main.fragment_document_slection.*

class DocumentSlectionFragment : Fragment() {

    private val homeViewModel: HomeSharedViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_document_slection, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.document_selection_toolbar_title))

        rv_document_list.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = VerificationDocsListAdapter(homeViewModel.setListOfVerificationDocsNeeded(context))
        }
    }
}
