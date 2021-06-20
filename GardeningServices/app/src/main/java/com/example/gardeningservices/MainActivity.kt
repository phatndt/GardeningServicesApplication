package com.example.gardeningservices

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gardeningservices.fragment.*
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val cartFragment = CartFragment()
    private val notificationFragment = NotificationFragment()
    private val profileFragment = ProfileFragment()

    private var  id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val intent: Intent = intent
        val id1 = intent.getIntExtra("idUser",-1)
        this.id = intent.getIntExtra("idUser",-1)

        makeCurrentFragment(homeFragment)
        val bottomNavigationView: BottomNavigationView = findViewById(R.id.btm_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.favorite -> makeCurrentFragment(favoriteFragment)
                R.id.shoppingCart -> makeCurrentFragment(cartFragment)
                R.id.notification -> makeCurrentFragment(notificationFragment)
                R.id.person -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        val bundle = Bundle()
        bundle.putInt("id", this.id!!)
        fragment.arguments = bundle
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }
}