package com.example.debugbikeservice

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.debugbikeservice.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    lateinit var sharedPreferences: SharedPreferences
    lateinit var  LoginBinding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        LoginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(LoginBinding.root)


        LoginBinding.signUp.setOnClickListener() {
            startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
        }
        LoginBinding.Login.setOnClickListener {

            sharedPreferences = getSharedPreferences("Sign up", MODE_PRIVATE)
            var email = sharedPreferences.getString("Email", "")
            var pass = sharedPreferences.getString("Password", "")
            if (LoginBinding.editEmail.text.toString() == email && LoginBinding.editPassword.text.toString() == pass) {
                var intent = Intent(this@LoginActivity , DashActivity:: class.java)
                startActivity(intent)
                    //toast message




            }
            else{
                //toast message


        }
    }






    }
}