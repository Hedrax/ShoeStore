package com.udacity.shoestore.screens.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.text.isDigitsOnly
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.databinding.DetailsBinding
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.screens.listingFragment.ListingViewModel

class DetailsFragment : Fragment() {
    private lateinit var binding: DetailsBinding
    private val viewModel: ListingViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DetailsBinding.inflate(inflater,container,false)
        binding.cancelButton.setOnClickListener{findNavController()
            .navigate(DetailsFragmentDirections.actionDetailsFragmentToListingFragment())}
        binding.doneButton.setOnClickListener{
            done()
        }
        binding.vm = viewModel

        return binding.root
    }

    private fun done(){
        viewModel.addItem()
        findNavController().navigate(DetailsFragmentDirections
            .actionDetailsFragmentToListingFragment())
    }

}