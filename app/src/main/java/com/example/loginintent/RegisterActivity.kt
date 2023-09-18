package com.example.loginintent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.loginintent.databinding.ActivityMainBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    companion object{
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_EMAIL = "extra_email"
        const val EXTRA_PHONE = "extra_phone"
        const val EXTRA_PASS = "extra_pass"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            registerButton.setOnClickListener {
                val username = usernameInput.text.toString()
                val email = emailInput.text.toString()
                val phone = phoneInput.text.toString()
                val password = passwordInput.text.toString()
                val agreeChecked = agreeCheckBox.isChecked

                if (agreeChecked) {
                    val intentToLoginActivity = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intentToLoginActivity.putExtra(EXTRA_NAME, username)
                    intentToLoginActivity.putExtra(EXTRA_EMAIL, email)
                    intentToLoginActivity.putExtra(EXTRA_PHONE, phone)
                    intentToLoginActivity.putExtra(EXTRA_PASS, password)
                    startActivity(intentToLoginActivity)
                } else {
                    Toast.makeText(this@RegisterActivity, "Please agree to the Terms and Conditions.", Toast.LENGTH_SHORT).show()
                }
            }
            val loginHereTextView = findViewById<TextView>(R.id.loginHere)

            loginHereTextView.setOnClickListener {
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                startActivity(intent)
            }

        }

    }
}