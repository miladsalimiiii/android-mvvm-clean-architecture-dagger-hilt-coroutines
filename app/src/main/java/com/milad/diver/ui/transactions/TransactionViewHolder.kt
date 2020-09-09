package com.milad.diver.ui.transactions

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.milad.diver.R
import com.milad.diver.data.model.Information
import com.milad.diver.ui.util.UtilDateAndTime
import kotlinx.android.synthetic.main.item_transaction.view.*
import org.koin.core.KoinComponent
import org.koin.core.inject

private const val IMAGE_TYPE="drawable"
private const val CHARGE_DIVER_ICON_NAME="icon_transaction_chargediver"
private const val WITHDRAW_DIVER_ICON_NAME="icon_transaction_withdrawdiver"

class TransactionViewHolder(itemView: View) : BaseViewHolder(itemView), KoinComponent {


    private val mUtilDateAndTime: UtilDateAndTime by inject()
    private lateinit var mTransactionList: List<Information>

    override fun clear() {}
    override fun onBind(position: Int, transactionList: List<Information>) {
        super.onBind(position, transactionList)
        mTransactionList = transactionList
        itemView.textView_transaction_status.visibility = View.GONE
        itemView.textView_transaction_plus.visibility = View.GONE

        itemView.textView_transaction_amount.text = transactionList[position].mProduct
        itemView.textView_transaction_name.text = itemView.context.getString(
            R.string.all_twoVariable,
            transactionList[position].mVideoTitle,
            transactionList[position].mVideoCode
        )
      //  itemView.textView_transaction_lableName.text = fixLabelNameFontSizeFontColor(transactionList[position])

//        val localDateFromUTC =
//            mUtilDateAndTime.getDataFromUTC(transactionList[position].mDateReleased.toString())
//        val convertDateToJalali = localDateFromUTC?.first?.toInt()
//            .let {
//                it?.let { year ->
//                    localDateFromUTC?.third?.toInt()?.let { day->
//                        mUtilDateAndTime.gregorianToJalali(
//                            year,
//                            localDateFromUTC.second.toInt(),
//                            day
//                        )
//                    }
//                }
//            }

//        itemView.textView_transaction_time.text =
//            mUtilDateAndTime.getTimeFromUTC(transactionList[position].mId.toString())

//        itemView.textView_transaction_date.text = itemView.context.getString(
//            R.string.all_threeVariable,
//            convertDateToJalali?.get(2).toString(),
//            convertDateToJalali?.get(1)?.let { mUtilDateAndTime.getMonthName(it) },
//            convertDateToJalali?.get(0).toString()
       // )
    }

//    private fun fixLabelNameFontSizeFontColor(viewType: Information): String {
//        return when (viewType.mViewType) {
//
//            VIEWTYPE.SENDTO.ordinal+1 -> {
//                itemView.textView_transaction_amount.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextDark
//                    )
//                )
//                itemView.textView_transaction_lableName.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorText
//                    )
//                )
//                uploadProfileImage()
//                itemView.context.getString(R.string.transactionItem_send)
//            }
//            VIEWTYPE.RECEIVEFROM.ordinal+1 -> {
//                itemView.textView_transaction_amount.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextPositive
//                    )
//                )
//                itemView.textView_transaction_plus.visibility = View.VISIBLE
//                itemView.textView_transaction_plus.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextPositive
//                    )
//                )
//                itemView.textView_transaction_lableName.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorText
//                    )
//                )
//                uploadProfileImage()
//                itemView.context.getString(R.string.transactionItem_receive)
//            }
//            VIEWTYPE.CHARGEDIVER.ordinal+1 -> {
//                itemView.textView_transaction_amount.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextPositive
//                    )
//                )
//                itemView.textView_transaction_plus.visibility = View.VISIBLE
//                itemView.textView_transaction_plus.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextPositive
//                    )
//                )
//                itemView.textView_transaction_lableName.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextDark
//                    )
//                )
//                uploadProfileImage(CHARGE_DIVER_ICON_NAME)
//                itemView.context.getString(R.string.transactionItem_diverCharge)
//            }
//            VIEWTYPE.WITHDRAWDIVER.ordinal+1 -> {
//                itemView.textView_transaction_amount.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextDark
//                    )
//                )
//                itemView.textView_transaction_lableName.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextDark
//                    )
//                )
//                uploadProfileImage(WITHDRAW_DIVER_ICON_NAME)
//                itemView.context.getString(R.string.transactionItem_DiverWithdraw)
//            }
//            VIEWTYPE.REQUESTME.ordinal+1 -> {
//                itemView.textView_transaction_plus.visibility = View.VISIBLE
//                itemView.textView_transaction_plus.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextLight
//                    )
//                )
//                itemView.textView_transaction_amount.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextLight
//                    )
//                )
//                itemView.textView_transaction_lableName.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextPositive
//                    )
//                )
//                uploadProfileImage()
//                itemView.context.getString(R.string.transactionItem_requestMe)
//            }
//            VIEWTYPE.REQUESTHIS.ordinal+1 -> {
//                itemView.textView_transaction_lableName.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextHint
//                    )
//                )
//                itemView.textView_transaction_status.visibility = View.VISIBLE
//                itemView.textView_transaction_amount.setTextColor(
//                    ContextCompat.getColor(
//                        itemView.context,
//                        R.color.colorTextLight
//                    )
//                )
//                uploadProfileImage()
//                itemView.context.getString(R.string.transactionItem_requestHis)
//            }
//            else -> {
//                itemView.context.getString(R.string.transactionItem_error)
//            }
//        }
//    }

    private fun uploadProfileImage(imageAddressInDrawable: String? = null) {

        if (imageAddressInDrawable != null) {
            Glide.with(itemView.context)
                .load(
                    itemView.resources.getIdentifier(
                        imageAddressInDrawable,
                        IMAGE_TYPE,
                        itemView.context.packageName
                    )
                )
                .error(R.drawable.icon_all_emptyprofilepicture)
                .apply(RequestOptions.circleCropTransform())
                .into(itemView.imageView_transaction_item)
        } else {
//            Glide.with(itemView.context)
//                .load(mTransactionList[currentPosition].mAvatar)
//                .error(R.drawable.icon_all_emptyprofilepicture)
//                .apply(RequestOptions.circleCropTransform())
//                .into(itemView.imageView_transaction_item)
        }
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