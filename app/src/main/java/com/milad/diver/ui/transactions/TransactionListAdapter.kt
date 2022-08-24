package com.milad.diver.ui.transactions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.milad.diver.R
import com.milad.diver.data.model.Item
import com.milad.diver.data.model.User
import com.milad.diver.databinding.FragmentTransactionBinding
import com.milad.diver.databinding.ItemTransactionBinding

class TransactionListAdapter(transactionList: ArrayList<Item>) :
    RecyclerView.Adapter<BaseViewHolder>() {

    private var _binding: ItemTransactionBinding? = null
    private val binding get() = _binding!!

    private var mTransactionList = transactionList
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {

        return TransactionViewHolder(
            ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    fun updateData(transactionList:List<Item>){
        mTransactionList= transactionList as ArrayList<Item>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return mTransactionList.size
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.onBind(position,mTransactionList)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        _binding = null
    }
}