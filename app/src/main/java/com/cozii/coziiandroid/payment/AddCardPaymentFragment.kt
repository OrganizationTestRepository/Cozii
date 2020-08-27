package com.cozii.coziiandroid.payment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.home.CoziiHomeActivity
import com.cozii.coziiandroid.payment.adapter.CountrySpinnerAdapter
import com.cozii.coziiandroid.payment.viewmodels.PaymentInformationViewModel
import io.card.payment.CardIOActivity
import io.card.payment.CreditCard
import kotlinx.android.synthetic.main.fragment_add_card_payment.*


class AddCardPaymentFragment : Fragment() {

    private val paymentInformationViewModel: PaymentInformationViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_card_payment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as CoziiHomeActivity).updateToolbarTitle(getString(R.string.add_payment_toolbar_title))

        (activity as CoziiHomeActivity).changeToolbarBackVisibity(true)

        sp_country.adapter = CountrySpinnerAdapter(paymentInformationViewModel.setPaymentCountries(requireContext()),requireContext())

        iv_scan_card.setOnClickListener {
            val scanIntent = Intent(requireContext(), CardIOActivity::class.java)

            scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_EXPIRY, true)
            scanIntent.putExtra(CardIOActivity.EXTRA_REQUIRE_CARDHOLDER_NAME,true)
            scanIntent.putExtra(CardIOActivity.EXTRA_SUPPRESS_MANUAL_ENTRY, true)
            startActivityForResult(scanIntent, 222)
        }

//        sp_country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
//            override fun onNothingSelected(parent: AdapterView<*>?) {
//
//            }
//
//            override fun onItemSelected(
//                parent: AdapterView<*>?,
//                view: View?,
//                position: Int,
//                id: Long
//            ) {
//                val selectedCountry = parent?.getItemAtPosition(position).toString()
//                if (selectedCountry == "Canada"){
//                    tv_postal_code.text = "Postal Code"
//                }else if (selectedCountry == "United States"){
//                    tv_postal_code.text = "Zip Code"
//                }
//            }
//
//        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 222){
            if (data != null && data.hasExtra(CardIOActivity.EXTRA_SCAN_RESULT)){
                val cardDetails : CreditCard = data.getParcelableExtra(CardIOActivity.EXTRA_SCAN_RESULT)
                et_card_number.setText(paymentInformationViewModel.formatCardNumber(cardDetails.cardNumber))
                et_card_holder_name.setText(cardDetails.cardholderName)
                et_card_expiry.setText(cardDetails.expiryMonth.toString() + "/" + cardDetails.expiryYear.toString())
            }
        }
    }


}
