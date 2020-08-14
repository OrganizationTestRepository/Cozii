package com.cozii.coziiandroid.payment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.databinding.LayoutSinglePaymentBinding
import com.cozii.coziiandroid.payment.PaymentOptionClickListener
import com.cozii.coziiandroid.payment.models.PaymentMethods

class PaymentMethodsAdapter(private val paymentOptions: List<PaymentMethods>,private val paymentClickListener: PaymentOptionClickListener) :
    RecyclerView.Adapter<PaymentMethodsAdapter.PaymentOptionViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentOptionViewHolder {
        return PaymentOptionViewHolder.from(
            parent
        )
    }

    override fun getItemCount(): Int {
        return paymentOptions.size
    }

    override fun onBindViewHolder(
        holder: PaymentOptionViewHolder,
        position: Int
    ) {
        val paymentOption = paymentOptions[position]
        holder.bindView(paymentOption,paymentClickListener)
    }

    class PaymentOptionViewHolder(private val binding: LayoutSinglePaymentBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindView(paymentOption: PaymentMethods,paymentOptionClickListener: PaymentOptionClickListener) {
            binding.paymentOptions = paymentOption
            binding.paymentOption = View.OnClickListener {
                paymentOptionClickListener.onPaymentOptionClick(paymentOption)
            }
        }

        companion object {
            fun from(parent: ViewGroup): PaymentOptionViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = LayoutSinglePaymentBinding.inflate(layoutInflater, parent, false)
                return PaymentOptionViewHolder(
                    binding
                )
            }
        }

    }
}