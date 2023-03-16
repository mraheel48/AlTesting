package com.example.altesting

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import com.example.altesting.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.login.setOnClickListener {
            performLogin()
        }
    }

    private fun performLogin() {
        // Get the email and password from the EditText views
        val email = binding.email.text.toString().trim()
        val password = binding.password.text.toString().trim()

        // Check if the email and password are empty
        if (email.isEmpty()) {
            binding.email.error = "Please enter your email"
            binding.email.requestFocus()
            return
        }

        if (!isEmailValid(email)) {
            binding.email.error = "Please enter a valid email"
            binding.email.requestFocus()
            return
        }

        if (password.isEmpty()) {
            binding.password.error = "Please enter your password"
            binding.password.requestFocus()
            return
        }

        // Perform the login logic here

    }

    private fun isEmailValid(email: String): Boolean {
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(email).matches()
    }

}