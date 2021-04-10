package com.lixm.notes.adaptation.density

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lixm.notes.R

/**
 * Desc density 适配
 * Author xm li
 * Date :2021/4/10
 */
class DensityActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Density.setDensity(application,this)
        setContentView(R.layout.activity_density)
    }
    companion object{
        fun getIntent(context: Context): Intent {
            return Intent(context,DensityActivity::class.java)
        }
    }
}