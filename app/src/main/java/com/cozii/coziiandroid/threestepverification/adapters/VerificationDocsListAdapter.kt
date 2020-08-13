package com.cozii.coziiandroid.threestepverification.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.coziicustomviews.CoziiTextView
import com.cozii.coziiandroid.threestepverification.models.VerificationDocs

class VerificationDocsListAdapter(
    private val verificationDocs: List<VerificationDocs>,
    private val documentClickListener: DocumentClickListener
) :
    RecyclerView.Adapter<VerificationDocsListAdapter.VerificationDocViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerificationDocsListAdapter.VerificationDocViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.layout_single_document_selection, parent, false)
        return VerificationDocViewHolder(v)
    }

    override fun getItemCount(): Int {
        return verificationDocs.size
    }

    override fun onBindViewHolder(
        holder: VerificationDocsListAdapter.VerificationDocViewHolder,
        position: Int
    ) {
        holder.bindView(verificationDocs[position], documentClickListener)
    }

    class VerificationDocViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(
            verificationDoc: VerificationDocs,
            documentClickListener: DocumentClickListener
        ) {
            val docImage = itemView.findViewById(R.id.iv_document_image) as ImageView
            val documentName = itemView.findViewById(R.id.tv_document_title) as CoziiTextView

            docImage.setImageDrawable(verificationDoc.verificationDocImage)
            documentName.text = verificationDoc.verificationDocName

            itemView.setOnClickListener {
                itemView.setBackgroundResource(R.drawable.rectangular_outline_coloured)
                documentClickListener.onDocumentItemClick(verificationDoc)
            }
        }

    }
}