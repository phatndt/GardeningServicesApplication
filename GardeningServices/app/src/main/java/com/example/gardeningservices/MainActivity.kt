package com.example.gardeningservices

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.fragment.FavoriteFragment
import com.example.gardeningservices.fragment.HomeFragment
import com.example.gardeningservices.fragment.ProfileFragment
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.category.CategoryApi
import com.google.android.material.bottomnavigation.BottomNavigationView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val homeFragment = HomeFragment()
    private val favoriteFragment = FavoriteFragment()
    private val profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        makeCurrentFragment(homeFragment)

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.btm_navigation)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> makeCurrentFragment(homeFragment)
                R.id.favorite -> makeCurrentFragment(favoriteFragment)
                R.id.person -> makeCurrentFragment(profileFragment)
            }
            true
        }
    }
    private fun makeCurrentFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

}