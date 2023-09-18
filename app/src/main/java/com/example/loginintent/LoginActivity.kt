package com.example.loginintent

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginintent.databinding.ActivityHomepageBinding
import com.example.loginintent.databinding.ActivityLoginpageBinding
import com.example.loginintent.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginpageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginpageBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val username = binding.usernameLogin
        val password = binding.passwordLogin
        val loginButton = binding.loginButton

        with(binding){
            loginButton.setOnClickListener{

                val usernameInput = username.text.toString()
                val passwordInput = password.text.toString()

                val registeredUsername = intent.getStringExtra(RegisterActivity.EXTRA_NAME)
                val registeredEmail = intent.getStringExtra(RegisterActivity.EXTRA_EMAIL)
                val registeredPhone = intent.getStringExtra(RegisterActivity.EXTRA_PHONE)
                val registeredPassword = intent.getStringExtra(RegisterActivity.EXTRA_PASS)

                if (usernameInput == registeredUsername && passwordInput == registeredPassword) {
                    val intentToHomeActivity = Intent(this@LoginActivity, HomeActivity::class.java)
                    intentToHomeActivity.putExtra("username", registeredUsername)
                    intentToHomeActivity.putExtra("email", registeredEmail)
                    intentToHomeActivity.putExtra("phone", registeredPhone)
                    startActivity(intentToHomeActivity)
                } else {
                    Toast.makeText(
                        this@LoginActivity, "Login failed. Invalid username or password.", Toast.LENGTH_SHORT).show()
                }

            }
        }

    }

}

