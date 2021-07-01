package com.example.gardeningservices.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.gardeningservices.MainActivity
import com.example.gardeningservices.R
import com.example.gardeningservices.viewmodel.CartViewModel
import com.example.gardeningservices.viewmodel.OrderViewModel
import kotlinx.android.synthetic.main.activity_check_out_complete.*
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class CheckOutCompleteActivity : AppCompatActivity() {


    private var total: Int = 0
    private var idOrder: Int = 0
    @SuppressLint("SetTextI18n", "UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_check_out_complete)

        total = intent.getIntExtra("total", -1)
        idOrder = intent.getIntExtra("idOrder",-1)

        if (idOrder ==0) {
            complete_state.text = "Order False"
            complete_image.setImageDrawable(getDrawable(R.drawable.ic_baseline_error_24))
            complete_total.text = ""
        }

        if (idOrder != 0 && idOrder != -1) {
            complete_state.text = "Order Success"
            complete_image.setImageDrawable(getDrawable(R.drawable.ic_baseline_done_24))
            complete_total.text = "Please prepare $total to pay"
        }

        complete_continue.setOnClickListener {
            val intentFinish = Intent(this, MainActivity::class.java)
            startActivity(intentFinish)
            finishAffinity()
        }
    }
}