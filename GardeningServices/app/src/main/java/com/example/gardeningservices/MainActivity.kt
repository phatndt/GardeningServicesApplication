package com.example.gardeningservices

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.gardeningservices.fragment.FavoriteFragment
import com.example.gardeningservices.fragment.HomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        makeCurrentFragment(homeFragment)


        val bottomNavigationView: BottomNavigationView = findViewById(R.id.btm_navigation)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(this@MainActivity,"clickfdsfdsfdsfdsfdsfdsfdsfdsfds", Toast.LENGTH_LONG).show()
                    makeCurrentFragment(homeFragment)}
                R.id.favorite -> makeCurrentFragment(favoriteFragment)
            }
            true
        }

    }
    private fun makeCurrentFragment(fragment: Fragment) {
        if(fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container,fragment)
            transaction.commit()
        }

//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.fragment_container,fragment)
//            commit()
//        }
    }

}