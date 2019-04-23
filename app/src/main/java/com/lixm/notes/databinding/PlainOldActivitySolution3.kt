package com.lixm.notes.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.lixm.notes.R

class PlainOldActivitySolution3 : AppCompatActivity(){
    private val viewModel by lazy { ViewModelProviders.of(this).get(SimpleViewModel::class.java) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : PlainActivitySolution3Binding = DataBindingUtil.setContentView(this, R.layout.plain_activity_solution_3)
        binding.viewModel1 = viewModel
    }
}