package com.example.experiment.lifecycle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experiment.R
import com.example.experiment.databinding.ActivityLifeCycleBinding

class LifeCycleActivity : AppCompatActivity() {
    lateinit var binding: ActivityLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifeCycleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycle.addObserver(MyObserver())
    }
}