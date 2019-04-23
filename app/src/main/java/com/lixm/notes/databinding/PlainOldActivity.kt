package com.lixm.notes.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lixm.notes.R

class PlainOldActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            val binding : PlainActivityBinding= DataBindingUtil.setContentView(this, R.layout.plain_activity)
            binding.name = "Your name"
            binding.lastName = "Your last name"
    }
}