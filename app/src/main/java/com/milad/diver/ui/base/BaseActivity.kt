package com.milad.diver.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {

    protected abstract fun initComponents()
    protected abstract fun initUiListeners()
    protected abstract fun getLayoutResourceId(): Int
    protected abstract fun initObservers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutResourceId())
        initComponents()
        initUiListeners()
        initObservers()
    }
}