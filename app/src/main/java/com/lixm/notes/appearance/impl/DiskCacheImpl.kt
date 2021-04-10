package com.lixm.notes.appearance.impl

import android.graphics.Bitmap
import com.lixm.notes.appearance.DiskCache

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class DiskCacheImpl: DiskCache {
    override fun findByDisk(url: String?): Bitmap? {
        println("从磁盘中获取")
        return null
    }
}