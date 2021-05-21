package com.example.gardeningservices.fragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.example.gardeningservices.R
import com.example.gardeningservices.SignInActivity
import com.example.gardeningservices.activity.EditProfileActivity

class ProfileFragment: Fragment() {
    val TAG = "HomeFragment"
    public  lateinit var contextFragment: Context
    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextFragment = context;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_profile, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cvEditProfile: TextView = view.findViewById(R.id.tv_edit_profile)
        cvEditProfile.setOnClickListener {
            val intent = Intent(activity,EditProfileActivity::class.java)
            startActivity(intent)
        }
        val cvlogout: TextView = view.findViewById(R.id.tv_log_out)
        cvlogout.setOnClickListener {
            val intent = Intent(activity,SignInActivity::class.java)
            startActivity(intent)
            activity?.finish()
        }
    }
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.d(TAG, "onActivityCreated")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStart() {
        Log.d(TAG, "onStart")
        super.onStart()

    }

    override fun onResume() {
        Log.d(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }

    override fun onDetach() {
        Log.d(TAG, "onDetach")
        super.onDetach()
    }
}