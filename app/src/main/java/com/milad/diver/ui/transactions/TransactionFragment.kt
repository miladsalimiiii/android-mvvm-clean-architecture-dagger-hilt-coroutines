package com.milad.diver.ui.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.milad.diver.R
import com.milad.diver.data.model.Item
import com.milad.diver.data.model.common.Status
import com.milad.diver.databinding.FragmentTransactionBinding
import com.milad.diver.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionFragment : BaseFragment() {

    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!

    private val mTransactionViewModel: TransactionViewModel by viewModels()
    private lateinit var mTransactionsList: List<Item>
    private lateinit var mLinearLayoutManager: LinearLayoutManager
    private var mAdapter = TransactionListAdapter(ArrayList())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun initComponents() {
        setUpRecyclerView()
        mTransactionViewModel.getTransactions()
    }

    override fun initUiListeners() {

    }

    override fun initObservers() {
        mTransactionViewModel.mGetInformationLiveData.observe(this, Observer {
            when (it.status) {
                Status.SUCCESS -> {
                    mTransactionsList = it.data?.mItems!!
                    mAdapter.updateData(mTransactionsList)
                }
                else -> {}
            }
        })
    }

    override fun updateToolbar() {

    }

   private fun setUpRecyclerView() {

        mLinearLayoutManager = LinearLayoutManager(context)
        binding.recyclerviewTransactionTransactionsList.layoutManager = mLinearLayoutManager
       binding.recyclerviewTransactionTransactionsList.adapter = mAdapter
        val dividerItemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        context?.let { context ->
            ContextCompat.getDrawable(context, R.drawable.drawable_all_dividerforrecyclerview)
                ?.let { drawable ->
                    dividerItemDecoration.setDrawable(
                        drawable
                    )
                }
        }
       binding.recyclerviewTransactionTransactionsList.addItemDecoration(dividerItemDecoration)
    }
}