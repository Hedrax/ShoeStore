package com.udacity.shoestore.screens.listingFragment

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ListingFragmentBinding
import com.udacity.shoestore.databinding.ShoeItemBinding
import com.udacity.shoestore.models.Shoe

class ListingFragment:Fragment() {
    private lateinit var binding: ListingFragmentBinding
    private  val viewModel: ListingViewModel by activityViewModels()
    lateinit var item : TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListingFragmentBinding.inflate(inflater,container,false)
        binding.floatingActionButton.setOnClickListener{
            it.findNavController().
            navigate(ListingFragmentDirections.actionListingFragmentToDetailsFragment())


        }
        viewModel.getList().observe(this){ item ->
            item.forEach{
                binding.linearLayoutShoeList.addView(viewCreator(it))
            }
        }

        setMenuVisibility(true)
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu,menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,requireView().findNavController())||super .onOptionsItemSelected(item)
    }

    private fun viewCreator(shoe: Shoe):View{
        val layout =  ShoeItemBinding.
        inflate(LayoutInflater.from(requireContext()),null,false)
        layout.shoeItem = shoe
        return layout.root

    }
}