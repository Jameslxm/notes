package com.lixm.notes.adaptation.px

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lixm.notes.R

/**
 * Desc
 * Author xm li
 * Date :2021/4/7
 */
class PxTestActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_px_test)
    }
    companion object {
        fun getIntent(context: Context): Intent{
            return Intent(context,PxTestActivity::class.java)
        }
    }
}