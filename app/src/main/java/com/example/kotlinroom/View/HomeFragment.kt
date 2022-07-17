package com.example.kotlinroom.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinroom.Adapter.HomeRecyclerViewAdapter
import com.example.kotlinroom.Model.PhotoModel
import com.example.kotlinroom.R
import com.example.kotlinroom.ViewModel.HomeViewModel
import com.example.kotlinroom.databinding.FragmentHomeBinding
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext


class HomeFragment : Fragment() {

    private lateinit var viewModel:HomeViewModel
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter:HomeRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Fragment Çalıştı")

    }


    @OptIn(DelicateCoroutinesApi::class)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

      GlobalScope.launch (Dispatchers.IO){

          println("Await üstünde")
          async { viewModel.getDataFromApi() }.await()
          println("Await bitti")

      }
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        val view = binding.root

        viewModel.returnPhotoModelList().observe(viewLifecycleOwner, Observer {

            adapter = HomeRecyclerViewAdapter(it)
            binding.homeRecyclerView.layoutManager = GridLayoutManager(context,2)
            binding.homeRecyclerView.adapter = adapter



        })

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }




}