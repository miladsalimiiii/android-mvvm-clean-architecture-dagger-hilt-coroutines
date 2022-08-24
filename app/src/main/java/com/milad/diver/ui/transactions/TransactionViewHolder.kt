package com.milad.diver.ui.transactions

import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.milad.diver.R
import com.milad.diver.data.model.Item
import com.milad.diver.databinding.ItemTransactionBinding

private const val IMAGE_TYPE="drawable"
private const val CHARGE_DIVER_ICON_NAME="icon_transaction_chargediver"
private const val WITHDRAW_DIVER_ICON_NAME="icon_transaction_withdrawdiver"

class TransactionViewHolder(private val binding: ItemTransactionBinding) : BaseViewHolder(binding.root) {


   // private val mUtilDateAndTime: UtilDateAndTime by inject()
    private lateinit var mTransactionList: List<Item>

    override fun clear() {}
    override fun onBind(position: Int, transactionList: List<Item>) {
        super.onBind(position, transactionList)
        mTransactionList = transactionList

        binding.textViewUserName.text = transactionList[position].mDisplayName

        Glide.with(itemView.context)
            .load(mTransactionList[currentPosition].mProfileImage)
            .error(R.drawable.icon_all_emptyprofilepicture)
            .apply(RequestOptions.circleCropTransform())
            .into(binding.imageViewProfile)

    }
    private fun uploadProfileImage(imageAddressInDrawable: String? = null) {

            Glide.with(itemView.context)
                .load(mTransactionList[currentPosition].mProfileImage)
                .error(R.drawable.icon_all_emptyprofilepicture)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.imageViewProfile)
       // }
    }

    enum class VIEWTYPE{
        SENDTO,
        RECEIVEFROM,
        CHARGEDIVER,
        WITHDRAWDIVER,
        REQUESTME,
        REQUESTHIS
    }
}