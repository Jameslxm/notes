package com.lixm.notes.mvvm.vm

import android.os.SystemClock
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import com.lixm.notes.databinding.ActivityLoginMvBinding
import com.lixm.notes.mvvm.model.UserInfo

/**
 * Desc
 * Author xm li
 * Date :2021/3/12
 */
class LoginViewModel(binding: ActivityLoginMvBinding) {
    var userInfo: UserInfo? = null
    init {
        userInfo = UserInfo()
        binding.viewModel = this
    }
    var nameTextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            userInfo?.name?.set(s?.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }
    var pwdTextWatcher = object: TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            userInfo?.pwd?.set(s?.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }

    }
    var loginClickListener = View.OnClickListener {
//        userInfo?.name?.set("zhangsan")
//        if("lixm".equals(userInfo?.name?.get()) && "123".equals(userInfo?.pwd?.get())){
//            Log.d(">>>","登录成功")
//        }else{
//            Log.d(">>>","登录失败")
//        }
        Thread(object : Runnable{
            override fun run() {
                SystemClock.sleep(3000)
                Log.d(">>>","姓名：${userInfo?.name?.get()}")
            }

        }).start()

    }
}