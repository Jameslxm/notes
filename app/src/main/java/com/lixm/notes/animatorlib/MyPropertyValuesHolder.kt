package com.lixm.notes.animatorlib

import android.view.View
import java.lang.reflect.Method

/**
 * Desc 属性管理器
 * Author xm li
 * Date :2021/4/1
 */
class MyPropertyValuesHolder(propertyName: String?, values: FloatArray) {
    var mPropertyName: String? = null
    var mSetter: Method? = null
    init {
        this.mPropertyName = propertyName
//        mValueType = Float.javaClass
//        mKeyframeSet = MyAnimationSet.ofFloat(value)
    }
    fun setupSetter(){
        if(mPropertyName == null) return
        var firstLetter: Char = Character.toUpperCase(mPropertyName!![0])
        var theRest = mPropertyName?.substring(1)
        var methodName = "set$firstLetter$theRest"
        mSetter = View::class.java.getMethod(methodName,Float.javaClass)
    }
    fun setAnimatedValue(view: View,fraction: Float){

    }
}