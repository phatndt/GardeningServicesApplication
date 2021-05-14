package com.example.gardeningservices.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.R
import com.example.gardeningservices.activity.SeeAllCategoryActivity
import com.example.gardeningservices.activity.SeeAllSpecialPackageActivity
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.adapter.SpecialPackageAdapter
import com.example.gardeningservices.databinding.FragmentHomeBinding
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.model.SpecialPackage
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.category.CategoryApi
import com.example.gardeningservices.network.category.SpecialPackageApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class HomeFragment: Fragment(){

    val TAG = "HomeFragment"
    private lateinit var binding: FragmentHomeBinding

    private lateinit var btnOpenCategory: TextView
    private lateinit var btnOpenSpecialPackage: TextView
    public  lateinit var contextFragment: Context

    override fun onAttach(context: Context) {
        Log.d(TAG, "onAttach")
        super.onAttach(context)
        this.contextFragment = context;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate")
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        Log.d(TAG, "onCreateView")
        return  inflater.inflate(R.layout.fragment_home, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)
        btnOpenCategory = view.findViewById(R.id.tx_see_all_categories)
        btnOpenCategory.setOnClickListener {
            val intent = Intent(activity, SeeAllCategoryActivity::class.java)
            startActivity(intent)
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.rcV_category_home)
        recyclerView.setHasFixedSize(true);
        callAPI(recyclerView, this.contextFragment)

        btnOpenSpecialPackage = view.findViewById(R.id.tx_see_all_special_offers)
        btnOpenSpecialPackage.setOnClickListener {
            val intent = Intent(activity, SeeAllSpecialPackageActivity::class.java)
            startActivity(intent)
        }
       val recyclerViewPackage: RecyclerView = view.findViewById(R.id.rcV_package_home)
        recyclerViewPackage.setHasFixedSize(true)
        callAPIPackage(recyclerViewPackage, this.contextFragment)

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
    private fun callAPI(recyclerView: RecyclerView,context: Context ) {
        var categoryAdapter: CategoryAdapter

        var listCategoryItem: List<Category>

        var categoryApi: CategoryApi? = null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        categoryApi= getRetrofit.getClient()!!.create(CategoryApi::class.java)

        val call: Call<List<Category>> = categoryApi!!.getCategoryHome()

        call.enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                listCategoryItem = response.body()!!
                categoryAdapter = CategoryAdapter(context,listCategoryItem )
                recyclerView.adapter = categoryAdapter
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(activity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun callAPIPackage(recyclerView: RecyclerView,context: Context ) {
        var specialPackageAdapter: SpecialPackageAdapter

        var listSpecialPackageItem: List<SpecialPackage>

        var specialPackageApi: SpecialPackageApi? = null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        specialPackageApi= getRetrofit.getClient()!!.create(SpecialPackageApi::class.java)

        val call: Call<List<SpecialPackage>> = specialPackageApi!!.getSpecialPackageHome()

        call.enqueue(object : Callback<List<SpecialPackage>> {
            override fun onResponse(
                call: Call<List<SpecialPackage>>,
                response: Response<List<SpecialPackage>>
            ) {
                listSpecialPackageItem = response.body()!!
                specialPackageAdapter = SpecialPackageAdapter(context,listSpecialPackageItem)
                recyclerView.adapter = specialPackageAdapter
            }

            override fun onFailure(call: Call<List<SpecialPackage>>, t: Throwable) {
                Toast.makeText(activity,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }

        })
    }
}