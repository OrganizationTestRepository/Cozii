package com.cozii.coziiandroid.home.tenant.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.coziicustomviews.CoziiTextView
import com.cozii.coziiandroid.home.tenant.models.TenantHomeOptions

class TenantHomeOptionsAdapter(private val tenantOptions: List<TenantHomeOptions>) :
    RecyclerView.Adapter<TenantHomeOptionsAdapter.TenantOptionViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): TenantHomeOptionsAdapter.TenantOptionViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_layout_tenant_option, parent, false)
        return TenantOptionViewHolder(v)
    }

    override fun getItemCount(): Int {
        return tenantOptions.size
    }

    override fun onBindViewHolder(
        holder: TenantHomeOptionsAdapter.TenantOptionViewHolder,
        position: Int
    ) {
        holder.bindView(tenantOptions[position], position)
    }

    class TenantOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindView(tenantOption: TenantHomeOptions, position: Int) {
            val optionImage = itemView.findViewById(R.id.iv_tenant_option) as ImageView
            val optionText = itemView.findViewById(R.id.tv_tenant_option) as CoziiTextView
            val divider = itemView.findViewById(R.id.rv_divider) as View

            optionImage.setImageDrawable(tenantOption.optionImage)
            optionText.text = tenantOption.option

            if (position == 2) {
                divider.isVisible = false
            }
        }

    }
}