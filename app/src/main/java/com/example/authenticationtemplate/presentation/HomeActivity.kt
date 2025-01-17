package com.example.authenticationtemplate.presentation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.authenticationtemplate.data.FirebaseManager
import com.example.authenticationtemplate.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var firebaseManager: FirebaseManager
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseManager = FirebaseManager()

        firebaseManager.getCurrentUser()?.let { user ->
            binding.txtName.text = user.displayName
            binding.txtEmail.text = user.email
            Glide.with(this).load(user.photoUrl).into(binding.imgProfile)
        }

        binding.btnLogout.setOnClickListener {
            firebaseManager.logoutUser()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}
