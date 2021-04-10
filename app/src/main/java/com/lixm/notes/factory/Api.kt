package com.lixm.notes.factory

import com.lixm.notes.factory.bean.UserInfoBean

/**
 * Desc
 * Author xm li
 * Date :2021/3/13
 */
interface Api {
    fun create() : UserInfoBean?
}