package com.udacity.shoestore

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.udacity.shoestore.databinding.ActivityMainBinding
import timber.log.Timber

/**
 * The Main [Activity] for Shoe Store app. Responsible for setting main content, navigation, and
 * fab visibility.
 *
 * @author Gil Cunningham
 */
class MainActivity : AppCompatActivity() {

    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView()
        setupNavController()
        observeViewModel()
        Timber.plant(Timber.DebugTree())
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(this, R.id.nav_host).navigateUp()
    }

    private fun setContentView() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        binding.viewModel = mainViewModel
        setContentView(binding.root)
    }

    private fun setupNavController() {
        val toolbar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        val navController = findNavController(this, R.id.nav_host)
        val appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun observeViewModel() {
        mainViewModel.fabShown.observe(this) { fabShown ->
            binding.fab.visibility = if (fabShown) View.VISIBLE else View.GONE
        }
    }
}
