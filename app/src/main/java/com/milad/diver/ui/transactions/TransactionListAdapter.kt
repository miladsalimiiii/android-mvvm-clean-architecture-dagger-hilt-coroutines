package com.milad.diver.ui.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milad.diver.R
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.Transaction

class TransactionListAdapter(transactionList: ArrayList<Transaction>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var mTransactionList = transactionList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return TransactionViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_transaction, parent, false)
        )
    }

    override fun getItemCount(): Int {

        return mTransactionList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {

        holder.onBind(position,mTransactionList)
    }
}