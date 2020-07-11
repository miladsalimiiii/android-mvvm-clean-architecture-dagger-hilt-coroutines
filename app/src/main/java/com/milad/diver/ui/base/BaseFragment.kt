package com.milad.diver.ui.base

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateToolbar()
        initComponents()
        initUiListeners()
        initObservers()
    }

    protected abstract fun initComponents()
    protected abstract fun initUiListeners()
    protected abstract fun initObservers()
    protected abstract fun updateToolbar()

}