package com.lixm.notes.appearance.impl

import com.lixm.notes.appearance.NetWorkLoad
import java.io.InputStream

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class NetWorkLoadImpl : NetWorkLoad{
    override fun loadByNetWork(url: String?): InputStream? {
        println("从网络中下载")
        return null
    }
}