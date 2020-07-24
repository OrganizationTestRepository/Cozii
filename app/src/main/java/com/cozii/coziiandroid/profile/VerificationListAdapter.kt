package com.cozii.coziiandroid.profile

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.cozii.coziiandroid.R
import com.cozii.coziiandroid.coziicustomviews.CoziiTextView
import com.cozii.coziiandroid.profile.models.AddlandlordParams
import com.cozii.coziiandroid.profile.models.ProfileInterface
import com.cozii.coziiandroid.profile.models.ProfileOptions
import com.cozii.coziiandroid.profile.models.VerificationParams

class VerificationListAdapter(private val profileOptions: List<ProfileInterface>) :
    RecyclerView.Adapter<VerificationListAdapter.ProfileBaseViewHolder<*>>() {

    companion object {
        private const val TYPE_VERIFY_OPTIONS = 0
        private const val TYPE_ADD_LANDLORD = 1
        private const val TYPE_PROFILE_OPTIONS = 2
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): VerificationListAdapter.ProfileBaseViewHolder<*> {
        return when (viewType) {
            TYPE_VERIFY_OPTIONS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_single_step_verification, parent, false)
                VerificationOptionsViewHolder(view)
            }
            TYPE_ADD_LANDLORD -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_single_add_landlord, parent, false)
                AddLandlordViewHolder(view)
            }
            TYPE_PROFILE_OPTIONS -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.layout_single_profile_option, parent, false)
                ProfileOptionsViewHolder(view)
            }
            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return profileOptions.size
    }

    override fun getItemViewType(position: Int): Int {
        return when (profileOptions[position]) {
            is VerificationParams -> TYPE_VERIFY_OPTIONS
            is AddlandlordParams -> TYPE_ADD_LANDLORD
            is ProfileOptions -> TYPE_PROFILE_OPTIONS
            else -> throw IllegalArgumentException("Invalid type of data $position")
        }
    }

    override fun onBindViewHolder(
        holder: VerificationListAdapter.ProfileBaseViewHolder<*>,
        position: Int
    ) {
        val element = profileOptions[position]
        when (holder) {
            is VerificationOptionsViewHolder -> holder.bind(element as VerificationParams,position)
            is AddLandlordViewHolder -> holder.bind(element as AddlandlordParams,position)
            is ProfileOptionsViewHolder -> holder.bind(element as ProfileOptions,position)
            else -> throw IllegalArgumentException()
        }
    }

    abstract class ProfileBaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T,position: Int)
    }

    class VerificationOptionsViewHolder(itemView: View) : ProfileBaseViewHolder<VerificationParams>(itemView) {

        private val verifyOptionImage = itemView.findViewById(R.id.iv_verification_image) as ImageView
        private val verifyOption = itemView.findViewById(R.id.tv_verification_option) as CoziiTextView
        private val divider = itemView.findViewById(R.id.rv_verification_divider) as View

        override fun bind(item: VerificationParams, position: Int) {
            verifyOptionImage.setImageDrawable(item.verificationIcon)
            verifyOption.text = item.verificationName

            if (position == 2) {
                divider.visibility = View.INVISIBLE
            }
        }

    }

    class AddLandlordViewHolder(itemView: View) : ProfileBaseViewHolder<AddlandlordParams>(itemView) {

        private val landlordTitle = itemView.findViewById(R.id.tv_add_landlord) as CoziiTextView

        override fun bind(item: AddlandlordParams, position: Int) {
            landlordTitle.text = item.title
        }

    }

    class ProfileOptionsViewHolder(itemView: View) : ProfileBaseViewHolder<ProfileOptions>(itemView) {

        private val profileIcon = itemView.findViewById(R.id.iv_profile_option_icon) as ImageView
        private val profileOption = itemView.findViewById(R.id.tv_profile_option) as CoziiTextView

        override fun bind(item: ProfileOptions, position: Int) {
            profileIcon.setImageDrawable(item.profileOptionIcon)
            profileOption.text = item.profileOption
        }

    }
}
