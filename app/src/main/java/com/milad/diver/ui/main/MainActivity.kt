package com.milad.diver.ui.main

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.milad.diver.R
import com.milad.diver.ui.base.BaseActivity

class MainActivity : BaseActivity() {

    private lateinit var mNavView:BottomNavigationView
    private lateinit var mNavController:NavController

    override fun initComponents() {
        mNavView = findViewById(R.id.nav_view)
        mNavController = findNavController(R.id.nav_host_fragment)
        mNavView.setupWithNavController(mNavController)
        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_transaction,
            R.id.navigation_contacts,
            R.id.navigation_setting
        ))
    }

    override fun initUiListeners() {

    }

    override fun getLayoutResourceId(): Int {
        return R.layout.activity_main
    }

    override fun initObservers() {
    }
}