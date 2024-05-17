package com.example.debugbikeservice

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.get
import com.example.debugbikeservice.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    var data = arrayOf("male" , "Female")

    lateinit var RegisterBinding : ActivityRegisterBinding

    lateinit var  sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()





        RegisterBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(RegisterBinding.root)

        var adapter = ArrayAdapter(this@RegisterActivity, android.R.layout.simple_spinner_dropdown_item , data)
        RegisterBinding.genderSpinner.adapter = adapter
        RegisterBinding.genderSpinner.onItemSelectedListener = this

        RegisterBinding.signUpButton.setOnClickListener{
            sharedPreferences = getSharedPreferences("Sign up" , MODE_PRIVATE)

            var editor = sharedPreferences.edit()
            editor.putString("name",RegisterBinding.signName.text.toString())
            editor.putString("Email",RegisterBinding.signEmail.text.toString())
            editor.putString("Password",RegisterBinding.signPassword.text.toString())
            editor.putString("Cofirm Password",RegisterBinding.confirmPassword.text.toString())

            var getPass = RegisterBinding.signPassword.text.toString()
            if(RegisterBinding.confirmPassword.text.toString().equals(getPass)){
                editor.putString("Confirm password" ,RegisterBinding.confirmPassword.text.toString())
            }
            else{
                RegisterBinding.confirmPassword.error = "Incorrent creditentagm"
            }

            editor.putString("gender" , RegisterBinding.genderSpinner.selectedItem.toString())
            if (RegisterBinding.termsCheckup.isChecked){
                var intent = Intent(this@RegisterActivity , DashActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                RegisterBinding.termsCheckup.error = "Please read the term and condition make the check uo box"
            }

            editor.apply()
        }





    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(parent  !=null){
            var selectionItem = parent.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}