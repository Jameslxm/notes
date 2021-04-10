package com.lixm.notes.appearance

import android.graphics.Bitmap

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
interface MemoryCache {
    fun findByMemory(url: String?): Bitmap?
}