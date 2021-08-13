package com.example.experiment.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.experiment.databinding.LinearFieldViewBinding
import com.example.experiment.databinding.MainFragmentBinding
import com.example.experiment.lifecycle.LifeCycleActivity

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

        /** ViewModelProvider is responsible to return ViewModel Objects
         * ViewModelProvider needs lifeCycleOwner and internally ViewModelProvider uses ViewModelStore and Factory

         * ViewModel creation needs ViewmodelProvider
         * ViewmodelProvider needs two things: Viewmodelstore and Factory
         * Activity/Fragment implements ViewmodelStoreOwner internally and is responsible to provide Viewmodelstore
         * Viewmodelstore is a Map where key is the  name of Viewmodel class and value is Viewmodel object itself.
         * so Viewmodelstore checks if key already exists, it returns the already existing object for viewmodel, else creates new one.
         * When activity rotates , it is Viewmodelstore that is retained (system retains the NonConfigurationInstance
         * which actually hold the Viewmodelstore object)

         * P.S:- it is the factory that creates viewmodel object. **/

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        binding.btnAddView.setOnClickListener {
            addView()
        }
        binding.btnLifecycle.setOnClickListener {
            startActivity(Intent(context, LifeCycleActivity::class.java))
        }


        binding.btnAddition.setOnClickListener {
            viewModel.counter++
            updateTextView()
        }
        updateTextView()
    }

    private fun updateTextView() {
        binding.tvCounter.text = viewModel.counter.toString()
    }

    private fun addView() {
        val fieldViewBinding = LinearFieldViewBinding.inflate(layoutInflater, null, false)
        fieldViewBinding.removeName.setOnClickListener {
            binding.nameView.removeView(fieldViewBinding.root)
        }
        binding.nameView.addView(fieldViewBinding.root)
    }
}