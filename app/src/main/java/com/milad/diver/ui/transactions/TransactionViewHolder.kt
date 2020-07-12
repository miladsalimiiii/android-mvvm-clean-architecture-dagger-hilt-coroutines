package com.milad.diver.ui.transactions

import android.view.View
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.milad.diver.R
import com.milad.diver.data.model.Transaction
import kotlinx.android.synthetic.main.item_transaction.view.*
import java.text.SimpleDateFormat
import java.util.*

class TransactionViewHolder(itemView: View) : BaseViewHolder(itemView) {

    override fun clear() {}
    override fun onBind(position: Int, transactionList: List<Transaction>) {
        super.onBind(position, transactionList)
        itemView.textView_transaction_status.visibility = View.GONE
        itemView.textView_transaction_plus.visibility = View.GONE

        itemView.textView_transaction_amount.text = transactionList[position].mAmount.toString()
        itemView.textView_transaction_name.text =
            transactionList[position].mFirstName + " " + transactionList[position].mLastName
        itemView.textView_transaction_lableName.text = fixStatus(transactionList[position])
        Glide.with(itemView.context)
            .load(transactionList[position].mAvatar)
            .error(R.drawable.icon_all_emptyprofilepicture)
            .apply(RequestOptions.circleCropTransform())
            .into(itemView.imageView_transaction_item)




        getDate(transactionList[position].mUpdateTime.toString())






    }


    private fun getDate(ourDate: String): String? {
        var ourDate: String? = ourDate
        try {
            val formatter =
                SimpleDateFormat("yyyyMMddHHmmss")
            formatter.timeZone = TimeZone.getTimeZone("UTC")
            val value = formatter.parse(ourDate)
            val dateFormatter =
                SimpleDateFormat("MM-dd-yyyy HH:mm") //this format changeable
            dateFormatter.timeZone = TimeZone.getDefault()
            ourDate = dateFormatter.format(value)

            //Log.d("ourDate", ourDate);
        } catch (e: Exception) {
            ourDate = "00-00-0000 00:00"
        }
        return ourDate
    }

    private fun fixStatus(viewType: Transaction): String {

        return when (viewType.mViewType) {

            1 -> {
                itemView.textView_transaction_amount.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextDark
                    )
                )
                itemView.textView_transaction_lableName.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorText
                    )
                )
                itemView.context.getString(R.string.transactionItem_send)
            }
            2 -> {
                itemView.textView_transaction_amount.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextPositive
                    )
                )
                itemView.textView_transaction_plus.visibility = View.VISIBLE
                itemView.textView_transaction_plus.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextPositive
                    )
                )
                itemView.textView_transaction_lableName.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorText
                    )
                )
                itemView.context.getString(R.string.transactionItem_receive)
            }
            3 -> {
                itemView.textView_transaction_amount.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextPositive
                    )
                )
                itemView.textView_transaction_plus.visibility = View.VISIBLE
                itemView.textView_transaction_plus.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextPositive
                    )
                )
                itemView.textView_transaction_lableName.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextDark
                    )
                )
                itemView.context.getString(R.string.transactionItem_diverCharge)
            }
            4 -> {
                itemView.textView_transaction_amount.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextDark
                    )
                )
                itemView.textView_transaction_lableName.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextDark
                    )
                )
                itemView.context.getString(R.string.transactionItem_DiverWithdraw)
            }
            5 -> {
                itemView.textView_transaction_plus.visibility = View.VISIBLE
                itemView.textView_transaction_plus.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextLight
                    )
                )
                itemView.textView_transaction_amount.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextLight
                    )
                )
                itemView.textView_transaction_lableName.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextPositive
                    )
                )
                itemView.context.getString(R.string.transactionItem_requestMe)
            }
            6 -> {
                itemView.textView_transaction_lableName.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextHint
                    )
                )
                itemView.textView_transaction_status.visibility = View.VISIBLE
                itemView.textView_transaction_amount.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorTextLight
                    )
                )
                itemView.context.getString(R.string.transactionItem_requestHis)
            }
            else -> {
                "خطا"
            }
        }
    }
}