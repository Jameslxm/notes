package com.lixm.notes.animatorlib

/**
 * Desc
 * Author xm li
 * Date :2021/4/1
 */
class MyFloatKeyframe {
    var mFraction: Float? = null
    var mValueType: Class<*>? = null
    var mValue: Float? = null

    constructor(mFraction: Float?, mValue: Float?) {
        this.mFraction = mFraction
        this.mValue = mValue
        mValueType = Float.javaClass
    }


}