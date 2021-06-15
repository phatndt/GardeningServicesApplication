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
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.gardeningservices.MainActivity
import com.example.gardeningservices.R
import com.example.gardeningservices.SignInActivity
import com.example.gardeningservices.activity.EditProfileActivity
import com.example.gardeningservices.adapter.CartAdapter
import com.example.gardeningservices.model.Cart
import com.example.gardeningservices.model.CartDetail
import com.example.gardeningservices.model.Products
import com.example.gardeningservices.model.Users
import com.example.gardeningservices.utilities.Status
import com.example.gardeningservices.viewmodel.CartViewModel
import com.example.gardeningservices.utilities.Status.SUCCESS
import com.example.gardeningservices.utilities.Status.ERROR
import com.example.gardeningservices.utilities.Status.LOADING
import com.example.gardeningservices.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class CartFragment: Fragment(), CartAdapter.CartInterface  {
    val TAG = "HomeFragment"
    private  lateinit var contextFragment: Context
    private lateinit var cartViewModel: CartViewModel
    private  lateinit var productViewModel: ProductViewModel
    private var idCart: Int = 0
    private lateinit var recyclerView: RecyclerView
    private var listProduct: ArrayList<Products> = arrayListOf()
    private  var listCartDetail: ArrayList<CartDetail> = arrayListOf()
    private lateinit  var cartAdapter: CartAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        this.contextFragment = context;
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return  inflater.inflate(R.layout.fragment_cart, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val myValue = this.arguments?.getInt("id")

        this.recyclerView = view.findViewById(R.id.rvC_list_cart)
        this.recyclerView.layoutManager = GridLayoutManager(contextFragment,1, GridLayoutManager.VERTICAL,false)

        this.cartViewModel = ViewModelProvider(this).get(CartViewModel::class.java)
        this.productViewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        listProduct.clear()
        listCartDetail.clear()
        getCart(myValue!!)
        val a = view.findViewById<AppCompatButton>(R.id.cart_apply_discount)
        a.setOnClickListener {
            Toast.makeText(this.contextFragment,this.listProduct.size.toString(),Toast.LENGTH_LONG).show()
        }
    }
    private fun getCart(myValue: Int) {
        this.cartViewModel.getCartByUser(myValue).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        idCart = it.data!!.idUser
                        resource.data?.let { idc -> getCartDetail(idc) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this.contextFragment, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                } }
        })
    }
    private fun getCartDetail(cart: Cart) {
        this.cartViewModel.getCartDetailByCart(cart.id).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        resource.data?.let { idc -> addListProduct(idc) }
                    }
                    Status.ERROR -> {
                        Toast.makeText(this.contextFragment, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                } }
        })
    }
    private  fun addListProduct(list: List<CartDetail>) {
        for (n in list) {
            this.listCartDetail.add(n)
            getProduct(n.idProduct)
        }
    }
    private fun getProduct(n: Int) {
        this.productViewModel.getProductById(n).observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        listProduct.add(it.data!!)
                        setUp()
                    }
                    Status.ERROR -> {
                        Toast.makeText(this.contextFragment, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                    }
                } }
        })
        setUp()
    }
    private fun setUp() {
        cartAdapter = CartAdapter(this.contextFragment,this.listCartDetail,this.listProduct,this)
        recyclerView.adapter = cartAdapter
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

    override fun deleteItem(position : Int) {
        cartViewModel.postDeleteCartDetail(position)
        listCartDetail.removeAt(position)
        listProduct.removeAt(position)
        cartAdapter.notifyDataSetChanged()
    }
}