package com.lixm.notes.factory

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lixm.notes.R

/**
 * Desc
 * Author xm li
 * Date :2021/3/13
 */
class FactoryTestActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factory_test)
//        var api: Api = ApiIml()
//        api.create()

//        SampleFactory.createApi().create()

//        ParamsFactory.createApi(2)?.create()
    }
    companion object {
        fun getIntent(context: Context): Intent{
            return Intent(context,FactoryTestActivity::class.java)
        }
    }
}