package com.lixm.notes.factory

import android.util.Log
import com.lixm.notes.factory.bean.UserInfoBean

/**
 * Desc
 * Author xm li
 * Date :2021/3/13
 */
class Api2Iml : Api {
    override fun create(): UserInfoBean? {
        var userInfoBean = UserInfoBean()
        userInfoBean.name = "张三"
        userInfoBean.age = 18
        Log.d("lxm",">>>${userInfoBean?.toString()}")
        return userInfoBean
    }
}