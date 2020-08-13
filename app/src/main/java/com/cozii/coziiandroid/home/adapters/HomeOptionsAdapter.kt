package com.cozii.coziiandroid.home.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.databinding.SingleLayoutTenantOptionBinding
import com.cozii.coziiandroid.home.models.HomeOptions

class HomeOptionsAdapter(private val tenantOptions: List<HomeOptions>) :
    RecyclerView.Adapter<HomeOptionsAdapter.TenantOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TenantOptionViewHolder {
        return TenantOptionViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int {
        return tenantOptions.size
    }

    override fun onBindViewHolder(
        holder: TenantOptionViewHolder,
        position: Int
    ) {
        val tenantOption = tenantOptions[position]
        holder.bindView(tenantOption)
    }

    class TenantOptionViewHolder(private val binding: SingleLayoutTenantOptionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(tenantOption: HomeOptions) {
            binding.homeOptions = tenantOption
        }

        companion object {
            fun from(parent: ViewGroup): TenantOptionViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = SingleLayoutTenantOptionBinding.inflate(layoutInflater, parent, false)
                return TenantOptionViewHolder(
                    binding
                )
            }
        }

    }
}