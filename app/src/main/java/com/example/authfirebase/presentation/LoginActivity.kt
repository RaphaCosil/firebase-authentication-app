package com.example.authfirebase.presentation

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authfirebase.data.FirebaseManager
import com.example.authfirebase.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseManager: FirebaseManager
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseManager = FirebaseManager()

        if (firebaseManager.isUserLoggedIn()) {
            redirectToMain()
        }

        binding.textRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.btnLogin.setOnClickListener {
            val email = binding.editLoginEmail.text.toString()
            val password = binding.editLoginPassword.text.toString()

            loginUser(email, password)
        }
    }

    private fun loginUser(email: String, password: String) {
        firebaseManager.loginUser(email, password, onSuccess = {
            redirectToMain()
        }, onFailure = { exception ->
            handleLoginError(exception)
        })
    }

    private fun redirectToMain() {
        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

    private fun handleLoginError(exception: Exception?) {
        val message = when (exception) {
            is FirebaseAuthInvalidUserException -> "Invalid user"
            is FirebaseAuthInvalidCredentialsException -> "Invalid credentials"
            else -> exception?.localizedMessage ?: "Unknown error"
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
