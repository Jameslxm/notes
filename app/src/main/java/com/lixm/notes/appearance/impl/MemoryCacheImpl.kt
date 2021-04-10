package com.lixm.notes.appearance.impl

import android.graphics.Bitmap
import com.lixm.notes.appearance.MemoryCache

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class MemoryCacheImpl: MemoryCache {
    override fun findByMemory(url: String?): Bitmap? {
        println("从内存中获取")
        return null
    }

}