package com.udacity.shoestore.screens.login

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.LoginBinding

class LoginFragment: Fragment() {
    private lateinit var binding:LoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = LoginBinding.inflate(inflater, container, false)
        binding.registerButton.setOnClickListener{isValidData(it)}
        binding.loginButton.setOnClickListener{isValidData(it)}

        return binding.root
    }

    private fun isValidData(view: View){
        val email = binding.emailEntry
        val password = binding.editTextTextPassword
        var validation = true
        if (email.text == null || !Patterns.EMAIL_ADDRESS.matcher(email.text).matches()){
            email.setError("Invalid Data")
            validation = false
        }
        if (password.text == null || password.text.length < 8){
            password.setError("Must be at least 8 chars or digits")
            validation = false
        }
        if (validation)
            view.findNavController().
            navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
    }
    //validating entry data

}