package com.milad.diver.ui.transactions

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.milad.diver.R
import com.milad.diver.data.model.Transaction
import kotlinx.android.synthetic.main.item_transaction.view.*

class TransactionViewHolder(itemView:View) :BaseViewHolder(itemView) {

    override fun clear() {}
    override fun onBind(position: Int, transactionList: List<Transaction>) {
        super.onBind(position, transactionList)
        itemView.textView_transaction_amount.text= transactionList[position].mAmount.toString()
        itemView.textView_transaction_name.text=transactionList[position].mFirstChat
        itemView.textView_transaction_lableName.text=fixStatus(transactionList[position])

        Glide.with(itemView.context)
            .load(transactionList[position].mAvatar)
            .apply(RequestOptions.circleCropTransform())
            .error(R.drawable.icon_main_setting)
            .into(itemView.imageView_transaction_item)

    }

   private fun fixStatus(viewType:Transaction):String{

        return when(viewType.mViewType){

            1->{itemView.context.getString(R.string.transactionItem_send)}
            2->{itemView.context.getString(R.string.transactionItem_receive)}
            3->{itemView.context.getString(R.string.transactionItem_diverCharge)}
            4->{itemView.context.getString(R.string.transactionItem_DiverWithdraw)}
            5->{itemView.context.getString(R.string.transactionItem_requestMe)}
            6->{itemView.context.getString(R.string.transactionItem_requestHis)}
            else -> {"خطا"}
        }
    }
}