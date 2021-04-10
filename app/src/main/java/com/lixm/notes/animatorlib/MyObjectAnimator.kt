package com.lixm.notes.animatorlib

import android.view.View
import java.lang.ref.WeakReference

/**
 * Desc
 * Author xm li
 * Date :2021/4/1
 */
class MyObjectAnimator : VSYNCManager.AnimationFrameCallback{
    var mTarget: WeakReference<View>? = null
    var mMyPropertyValuesHolder: MyPropertyValuesHolder? = null
    fun ofFloat(
        target: View?,
        propertyName: String?,
        vararg values: Float
    ): MyObjectAnimator {
        var anim = MyObjectAnimator(target, propertyName, values)
        return anim
    }

    private constructor(
        target: View?,
        propertyName: String?,
        values: FloatArray
    ) {
        mTarget = WeakReference<View>(target)
        mMyPropertyValuesHolder = MyPropertyValuesHolder(propertyName,values)
    }

    override fun doAnimationFrame(currentTime: Long) : Boolean{

        return false
    }

}