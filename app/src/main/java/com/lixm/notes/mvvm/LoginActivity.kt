package com.lixm.notes.mvvm

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.lixm.notes.R
import com.lixm.notes.databinding.ActivityLoginMvBinding
import com.lixm.notes.mvvm.vm.LoginViewModel

/**
 * Desc
 * Author xm li
 * Date :2021/3/12
 */
class LoginActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var activityLoginMvBinding :ActivityLoginMvBinding = DataBindingUtil.setContentView(LoginActivity@this, R.layout.activity_login_mv)
        LoginViewModel(activityLoginMvBinding)

    }
    companion object{
        fun getIntent(context: Context): Intent{
            return Intent(context,LoginActivity::class.java)
        }
    }
}