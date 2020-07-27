package com.cozii.coziiandroid.home.tenant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.coziicustomviews.CoziiTextView
import com.cozii.coziiandroid.home.tenant.models.SuggestedRentals

class SuggestedRentalsAdapter(private val suggestedRentals: List<SuggestedRentals>) :
    RecyclerView.Adapter<SuggestedRentalsAdapter.SuggestedRentalsViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SuggestedRentalsAdapter.SuggestedRentalsViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_layout_suggested_rental, parent, false)
        return SuggestedRentalsViewHolder(v)
    }

    override fun getItemCount(): Int {
        return suggestedRentals.size
    }

    override fun onBindViewHolder(
        holder: SuggestedRentalsAdapter.SuggestedRentalsViewHolder,
        position: Int
    ) {
        holder.bindView(suggestedRentals[position])
    }

    class SuggestedRentalsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(rentalOption: SuggestedRentals) {
            val rentalImage = itemView.findViewById(R.id.iv_suggested_rental) as ImageView
            val rentalDesc = itemView.findViewById(R.id.tv_rental_desc) as CoziiTextView

            rentalImage.setImageDrawable(rentalOption.suggestedRentalImage)
            rentalDesc.text = rentalOption.rentalDesc
        }

    }
}