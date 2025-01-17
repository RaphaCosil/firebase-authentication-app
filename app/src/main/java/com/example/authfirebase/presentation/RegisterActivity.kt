package com.example.authfirebase.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.authfirebase.data.FirebaseManager
import com.example.authfirebase.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var firebaseManager: FirebaseManager
    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseManager = FirebaseManager()

        binding.btnRegister.setOnClickListener {
            val name = binding.editName.text.toString()
            val email = binding.editEmail.text.toString()
            val password = binding.editPassword.text.toString()

            registerUser(name, email, password)
        }
    }

    private fun registerUser(name: String, email: String, password: String) {
        firebaseManager.registerUser(email, password, onSuccess = {
            Toast.makeText(this, "Success register user", Toast.LENGTH_SHORT).show()
            updateProfile(name)
        }, onFailure = {
            Toast.makeText(this, "Failed register user", Toast.LENGTH_SHORT).show()
        })
    }

    private fun updateProfile(name: String) {
        firebaseManager.updateUserProfile(name, onSuccess = {
            finish()
        }, onFailure = {
            Toast.makeText(this, "Failed update user profile", Toast.LENGTH_SHORT).show()
        })
    }
}
