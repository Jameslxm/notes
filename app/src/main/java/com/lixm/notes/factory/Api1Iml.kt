package com.lixm.notes.factory

import android.util.Log
import com.lixm.notes.factory.bean.UserInfoBean

/**
 * Desc
 * Author xm li
 * Date :2021/3/13
 */
class Api1Iml : Api {
    override fun create(): UserInfoBean? {
        var userInfoBean = UserInfoBean()
        Log.d("lxm",">>>${userInfoBean?.toString()}")
        return null
    }
}