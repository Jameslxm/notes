package com.lixm.notes.factory.bean

/**
 * Desc
 * Author xm li
 * Date :2021/3/13
 */
class UserInfoBean {
    var name: String? = null
    var age: Int = 0
    override fun toString(): String {
        return "name:${name},age:${age}"
    }
}