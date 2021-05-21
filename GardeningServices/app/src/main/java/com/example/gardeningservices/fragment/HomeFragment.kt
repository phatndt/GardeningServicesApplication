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
import com.example.gardeningservices.activity.SeeAllServicesActivity
import com.example.gardeningservices.activity.SeeAllSpecialPackageActivity
import com.example.gardeningservices.adapter.SpecialPackageAdapter
import com.example.gardeningservices.adapter.CategoryAdapter
import com.example.gardeningservices.adapter.ProductAdapter
import com.example.gardeningservices.adapter.ServicesAdapter
import com.example.gardeningservices.databinding.FragmentHomeBinding
import com.example.gardeningservices.model.SpecialPackage
import com.example.gardeningservices.model.Category
import com.example.gardeningservices.model.Products
import com.example.gardeningservices.model.Services
import com.example.gardeningservices.network.category.SpecialPackageApi
import com.example.gardeningservices.network.ApiUtils
import com.example.gardeningservices.network.ServerRetrofit
import com.example.gardeningservices.network.category.CategoryApi
import com.example.gardeningservices.network.services.ServicesApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class HomeFragment: Fragment(){
    val TAG = "HomeFragment"
    private lateinit var binding: FragmentHomeBinding

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
        val btnOpenCategory: TextView = view.findViewById(R.id.tx_see_all_categories)
        val btnOpenServices:TextView = view.findViewById(R.id.tv_see_all_service)
        val btnOpenSpecialPackage: TextView = view.findViewById(R.id.tx_see_all_special_offers)
        btnOpenCategory.setOnClickListener {
            val intent = Intent(activity, SeeAllCategoryActivity::class.java)
            startActivity(intent)
        }
        btnOpenServices.setOnClickListener {
            val intent=Intent(activity,SeeAllServicesActivity::class.java)
            startActivity(intent)
        }
        btnOpenSpecialPackage.setOnClickListener {
            val intent = Intent(activity, SeeAllSpecialPackageActivity::class.java)
            startActivity(intent)
        }
        val recyclerView: RecyclerView = view.findViewById(R.id.rcV_category_home)
        recyclerView.setHasFixedSize(true);
        getCategory(recyclerView, this.contextFragment)

        val recyclerView1: RecyclerView = view.findViewById(R.id.rcV_services_home)
        recyclerView1.setHasFixedSize(true);
        callAPISV(recyclerView1, this.contextFragment)

        val recyclerViewSale: RecyclerView = view.findViewById((R.id.rcV_sale))
        recyclerViewSale.setHasFixedSize(true)
        getFlashSale(recyclerViewSale,this.contextFragment)

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
    private fun getCategory(recyclerView: RecyclerView,context: Context ) {

        var categoryAdapter: CategoryAdapter

        var listCategoryItem: List<Category>

        val categoryApi = ApiUtils.getCategoryApi()

        categoryApi.getCategoryHome().enqueue(object : Callback<List<Category>> {
            override fun onResponse(call: Call<List<Category>>, response: Response<List<Category>>) {
                listCategoryItem = response.body()!!
                categoryAdapter = CategoryAdapter(context,listCategoryItem )
                recyclerView.adapter = categoryAdapter
            }

            override fun onFailure(call: Call<List<Category>>, t: Throwable?) {
                Toast.makeText(context,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
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
                specialPackageAdapter = SpecialPackageAdapter(context, listSpecialPackageItem)
                recyclerView.adapter = specialPackageAdapter
            }

            override fun onFailure(call: Call<List<SpecialPackage>>, t: Throwable) {
                Toast.makeText(context, "Error " + t.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun callAPISV(recyclerView1: RecyclerView,context: Context) {
        var servicesAdapter: ServicesAdapter

        var listServicesItem:List<Services>

        var servicesApi: ServicesApi?=null

        val getRetrofit: ServerRetrofit = ServerRetrofit()

        servicesApi = getRetrofit.getClient()!!.create(ServicesApi::class.java)

        val call: Call<List<Services>> = servicesApi!!.getServicesHome()
        call.enqueue(object : Callback<List<Services>>
        {
            override fun onResponse(call: Call<List<Services>>, response: Response<List<Services>>) {
                listServicesItem= response.body()!!
                servicesAdapter = ServicesAdapter(context, listServicesItem)
                recyclerView1.adapter = servicesAdapter
            }
            override fun onFailure(call: Call<List<Services>>, t: Throwable) {
                Toast.makeText(context,"Error " + t.toString() , Toast.LENGTH_SHORT).show()
            }
        })
    }
    private fun getFlashSale(recyclerView: RecyclerView,context: Context ) {

        var productAdapter: ProductAdapter

        var listProduct: List<Products>

        val productApi = ApiUtils.createProductApi()

        productApi.getSaleHome().enqueue(object : Callback<List<Products>> {
            override fun onFailure(call: Call<List<Products>>, t: Throwable) {
                Toast.makeText(context, "Error $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Products>>, response: Response<List<Products>>) {
                listProduct = response.body()!!
                productAdapter = ProductAdapter(context,listProduct)
                recyclerView.adapter = productAdapter;
            }

        })
    }
}