package com.milad.diver.ui.transactions

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.Transaction

abstract class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {
    var currentPosition = 0
        private set

    protected abstract fun clear()
    open fun onBind(position: Int, transactionList:List<Transaction>) {
        currentPosition = position
        clear()
    }
}