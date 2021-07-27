package com.example.experiment.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.experiment.R
import com.example.experiment.databinding.LinearFieldViewBinding
import com.example.experiment.databinding.MainFragmentBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.btnAdd.setOnClickListener {
            addView()
        }
    }

    private fun addView() {
        val fieldViewBinding = LinearFieldViewBinding.inflate(layoutInflater, null, false)
        fieldViewBinding.removeName.setOnClickListener {
            binding.nameView.removeView(fieldViewBinding.root)
        }
        binding.nameView.addView(fieldViewBinding.root)
    }
}