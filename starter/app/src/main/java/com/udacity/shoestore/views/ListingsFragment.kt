package com.udacity.shoestore.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentListingsBinding
import com.udacity.shoestore.databinding.ItemListShoeBinding
import com.udacity.shoestore.models.Shoe

/**
 * The Shoe Store [Fragment] to display shoe listings and navigate to details entry screen.
 *
 * @author Gil Cunningham
 */
class ListingsFragment : BaseFragment() {

    private lateinit var binding : FragmentListingsBinding
    override val nextScreen: Int = R.id.action_listingsFragment_to_detailsFragment

    private fun createShoeItemView(shoe : Shoe) =
        DataBindingUtil.inflate<ItemListShoeBinding>(
            layoutInflater, R.layout.item_list_shoe, null, false
        ).apply {
            model = shoe
        }.root

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View {
        binding = DataBindingUtil.inflate<FragmentListingsBinding>(
            inflater, R.layout.fragment_listings, container, false
        ).apply {
            viewModel = mainViewModel
            lifecycleOwner = viewLifecycleOwner
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mainViewModel.shoeListings.observe(viewLifecycleOwner) { shoeListings ->
            if (shoeListings.isNotEmpty()) {
                binding.shoeListings.removeAllViews()
            }
            shoeListings.forEach { shoe ->
                binding.shoeListings.apply {
                    addView(createShoeItemView(shoe))
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.onShowFab()
    }

    override fun onPause() {
        super.onPause()
        mainViewModel.onHideFab()
    }
}