package com.example.experiment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experiment.databinding.MainActivityBinding
import com.example.experiment.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: MainActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}