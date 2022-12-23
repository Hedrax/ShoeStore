package com.udacity.shoestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.ViewGroup
import androidx.coordinatorlayout.widget.ViewGroupUtils
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.ViewGroupBindingAdapter
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)
        val toolbar = binding.toolbar
        setSupportActionBar(toolbar)

        val appBarConfig = AppBarConfiguration(setOf(
            R.id.loginFragment,
            R.id.instructionsFragment,
            R.id.listingFragment,
            R.id.welcomeFragment
            )

        )


        val navHostFragment = NavHostFragment.
        findNavController(supportFragmentManager.findFragmentById(R.id.navHostFragment)!!)
        NavigationUI.setupWithNavController(toolbar, navHostFragment,appBarConfig)

    }



}
