package com.udacity.shoestore

import android.content.Context
import android.os.Bundle
import android.util.AttributeSet
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

/**
 * The Main Activity.
 */
class MainActivity : AppCompatActivity() {

    protected val mainViewModel : MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        setupNavController()
        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this, R.id.nav_host).navigateUp()
    }

    private fun setContentView() {
        val binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = mainViewModel
        setContentView(binding.root)
        println("**** activity viewmodel = $mainViewModel")
    }

    private fun setupNavController() {
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navController = findNavController(this, R.id.nav_host)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}
