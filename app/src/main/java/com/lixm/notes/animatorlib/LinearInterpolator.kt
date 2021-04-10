package com.lixm.notes.animatorlib

/**
 * Desc
 * Author xm li
 * Date :2021/4/1
 */
class LinearInterpolator: TimeInterpolator {
    override fun getInterpolator(input: Float): Float {
        return input
    }
}