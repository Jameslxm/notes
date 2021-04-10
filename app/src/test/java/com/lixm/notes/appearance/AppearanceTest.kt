package com.lixm.notes.appearance

import org.junit.Test

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class AppearanceTest {
    @Test
    fun test(){
//        var memoryCache: MemoryCache = MemoryCacheImpl()
//        memoryCache.findByMemory("")
//
//        var diskCache : DiskCache = DiskCacheImpl()
//        diskCache.findByDisk("")
//
//        var netWorkLoad: NetWorkLoad = NetWorkLoadImpl()
//        netWorkLoad.loadByNetWork("")

        Facade("").load()
    }
}