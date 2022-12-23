package com.udacity.shoestore.screens.instructions

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.InstructionsBinding

class InstructionsFragment:Fragment() {

    lateinit var binding: InstructionsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = InstructionsBinding.inflate(inflater,container,false)
        binding.navButtonInstructionLayout.setOnClickListener{
            it.findNavController().
            navigate(InstructionsFragmentDirections.actionInstructionsFragmentToListingFragment())
        }
        return binding.root
    }

}