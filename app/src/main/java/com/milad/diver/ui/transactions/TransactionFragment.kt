package com.milad.diver.ui.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.milad.diver.R
import com.milad.diver.data.model.Information
import com.milad.diver.data.model.common.Status
import com.milad.diver.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_transaction.*
import org.koin.android.ext.android.inject

class TransactionFragment : BaseFragment() {

    private val mTransactionViewModel: TransactionViewModel by inject()
    private lateinit var mTransactionsList: List<Information>
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private var mAdapter = TransactionListAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun initComponents() {
        setUpRecyclerView()
        mTransactionViewModel.getTransactions()
    }

    override fun initUiListeners() {

    }

    private fun fixAmountAndProfileAvatar(information:Information){

       // appCompatView_transaction_balance.text=information.mBalance.toString()
        setAvatar(information)
    }

    private fun setAvatar(information:Information){

        Glide.with(this)
            .load(information.mId)
            .error(R.drawable.icon_all_emptyprofilepicture)
            .apply(RequestOptions.circleCropTransform())
            .into(imageview_transaction_profile)
    }

    override fun initObservers() {


        mTransactionViewModel.mGetInformationLiveData.observe(this, Observer {

            when (it.status) {

                Status.SUCCESS -> {
                    mTransactionsList = it.data?.toList()!!
                    mAdapter.updateData(mTransactionsList)
                    //fixAmountAndProfileAvatar(it.data!!)
                }
            }
        })
    }

    override fun updateToolbar() {

    }

   private fun setUpRecyclerView() {

        mLinearLayoutManager = LinearLayoutManager(context)
        recyclerview_transaction_transactionsList.layoutManager = mLinearLayoutManager
        recyclerview_transaction_transactionsList.adapter = mAdapter
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        context?.let { context ->
            ContextCompat.getDrawable(context, R.drawable.drawable_all_dividerforrecyclerview)
                ?.let { drawable ->
                    dividerItemDecoration.setDrawable(
                        drawable
                    )
                }
        }
        recyclerview_transaction_transactionsList.addItemDecoration(dividerItemDecoration)
    }

    override fun onDestroy() {
        super.onDestroy()
       // mTransactionViewModel.onCleared()
    }
}