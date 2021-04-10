package com.lixm.notes.appearance

import com.lixm.notes.appearance.impl.DiskCacheImpl
import com.lixm.notes.appearance.impl.MemoryCacheImpl
import com.lixm.notes.appearance.impl.NetWorkLoadImpl

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class Facade {
    private var mUrl: String? = null
    private var mDiskCache: DiskCache? = null
    private var mMemoryCache: MemoryCache? = null
    private var mNetWorkLoad: NetWorkLoad? = null
    constructor(mUrl: String?) {
        this.mUrl = mUrl
        mDiskCache = DiskCacheImpl()
        mMemoryCache = MemoryCacheImpl()
        mNetWorkLoad = NetWorkLoadImpl()
    }

    fun load(){
        mMemoryCache?.findByMemory(mUrl)
        mDiskCache?.findByDisk(mUrl)
        mNetWorkLoad?.loadByNetWork(mUrl)

    }
}