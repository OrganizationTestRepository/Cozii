package com.cozii.coziiandroid.payment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.payment.models.CountrySpinnerItem
import kotlinx.android.synthetic.main.layout_single_spinner_item.view.*

class CountrySpinnerAdapter(private val countrySpinnerItems: List<CountrySpinnerItem>, context: Context) : BaseAdapter(){

    private val inflater = LayoutInflater.from(context)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = inflater.inflate(R.layout.layout_single_spinner_item,parent,false)
        view.iv_country_image.setImageDrawable(countrySpinnerItems[position].countryIcon)
        view.tv_country.text = countrySpinnerItems[position].country
        return view
    }

    override fun getItem(position: Int): Any? {
       return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return countrySpinnerItems.size
    }
}