package com.lixm.notes.appearance

import java.io.InputStream

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
interface NetWorkLoad {
    fun loadByNetWork(url: String?): InputStream?
}