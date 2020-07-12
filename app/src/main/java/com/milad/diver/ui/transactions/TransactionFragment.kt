package com.milad.diver.ui.transactions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.milad.diver.R
import com.milad.diver.ui.base.BaseFragment

class TransactionFragment : BaseFragment() {

    private lateinit var transactionViewModel: TransactionViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_transaction, container, false)
    }

    override fun initComponents() {

    }

    override fun initUiListeners() {

    }

    override fun initObservers() {

    }

    override fun updateToolbar() {

    }
}