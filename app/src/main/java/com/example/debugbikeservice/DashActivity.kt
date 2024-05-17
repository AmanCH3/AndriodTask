package com.example.debugbikeservice

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.debugbikeservice.Fragment.HomeFragment
import com.example.debugbikeservice.Fragment.ListFragment
import com.example.debugbikeservice.Fragment.ProfileFragment
import com.example.debugbikeservice.Fragment.SearchFragment
import com.example.debugbikeservice.databinding.ActivityDashBinding

class DashActivity : AppCompatActivity() {

    lateinit var DashBinding: ActivityDashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        DashBinding = ActivityDashBinding.inflate(layoutInflater)
        setContentView(DashBinding.root)

        DashBinding.navMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.home -> replaceFragment(HomeFragment())
                R.id.search->replaceFragment(SearchFragment())
                R.id.list -> replaceFragment(ListFragment())
                R.id.Person->replaceFragment(ProfileFragment())
                else->{}
            }
            true
        }


    }

    private fun replaceFragment(fragment: Fragment ){
        val fragmentManager: FragmentManager =supportFragmentManager
        val fragmentTransaction: FragmentTransaction =fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout,fragment)
        fragmentTransaction.commit()

    }

}




