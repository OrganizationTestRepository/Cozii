package com.cozii.coziiandroid.threestepverification.documentverification

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import kotlinx.android.synthetic.main.fragment_upload_document.*

class UploadDocumentFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upload_document, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        submit_button.setOnClickListener {
            it.findNavController()
                .navigate(R.id.action_uploadDocumentFragment_to_documentVerifySuccessFragment)
        }

        iv_doc_front_upload_icon.setOnClickListener{
           selectDocument(111)
        }

        iv_doc_back_upload_icon.setOnClickListener {
            selectDocument(112)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val selectedFile = data?.data

        if (requestCode == 111 && resultCode == RESULT_OK) {
            tv_doc_front.text = selectedFile.toString()
        }else if (requestCode == 112 && resultCode == RESULT_OK) {
            tv_doc_back.text = selectedFile.toString()
        }
    }

    private fun selectDocument(requestCode: Int){
        val intent = Intent()
            .setType("*/*")
            .setAction(Intent.ACTION_GET_CONTENT)

        startActivityForResult(Intent.createChooser(intent, "Select a file"), requestCode)
    }
}
