package com.example.kotlinroom.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.kotlinroom.R
import com.example.kotlinroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        replaceFragment(HomeFragment())


        binding.bottomNavigationView.setOnItemSelectedListener {

            when(it.itemId){

                R.id.HomeFragment -> replaceFragment(HomeFragment())
                R.id.MyPhotos -> replaceFragment(MyPhotos())

                else -> {

                }


            }
            true

        }


    }


    private fun replaceFragment(fragment : Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FrameLayout,fragment)
        fragmentTransaction.commit()


    }



}