package com.example.habari2.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.habari2.R

class NewsActivity : AppCompatActivity() {
    lateinit var navController:NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.NavHostContainer) as NavHostFragment
        navController=navHostFragment.navController
        setupActionBarWithNavController(navController)






    }
}