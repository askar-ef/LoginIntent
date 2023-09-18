package com.example.loginintent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)

        val txtAccount = findViewById<TextView>(R.id.txt_account)

        val username = intent.getStringExtra("username")
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")

        val accountText =
            "Welcome $username\nYour $email has been activated\nYour $phone has been registered"
        txtAccount.text = accountText
    }
}
