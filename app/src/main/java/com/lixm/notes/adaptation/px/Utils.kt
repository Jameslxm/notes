package com.lixm.notes.adaptation.px

import android.content.Context
import android.util.DisplayMetrics
import android.view.WindowManager

/**
 * Desc
 * Author xm li
 * Date :2021/4/7
 */
class Utils(context: Context) {
    private var mDisplayWidth: Int = 0
    private var mDisplayHeight: Int = 0

    companion object {
        const val STANDARD_WIDTH = 720
        const val STANDARD_HEIGHT = 1080
        private var instance: Utils? = null
        fun getInstance(context: Context): Utils {
            if (instance == null) {
                instance = Utils(context)
            }
            return instance!!
        }
    }

    init {
        if (mDisplayWidth == 0 || mDisplayHeight == 0) {
            var manager: WindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            var displayMetrics = DisplayMetrics()
            manager.defaultDisplay.getMetrics(displayMetrics)
            if (displayMetrics.widthPixels > displayMetrics.heightPixels) {
                mDisplayWidth = displayMetrics.heightPixels
                mDisplayHeight = displayMetrics.widthPixels
            } else {
                mDisplayWidth = displayMetrics.widthPixels
                mDisplayHeight = displayMetrics.heightPixels - getStatusBarHeight(context)
            }
        }
    }
    private fun getStatusBarHeight(context: Context): Int{
        var resId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
        if(resId > 0){
            return context.resources.getDimensionPixelSize(resId)
        }
        return 0
    }

    fun getHorizontalScale(): Float {
        return (mDisplayWidth / (STANDARD_WIDTH * 1.0)).toFloat()
    }

    fun getVerticalScale(): Float {
        return (mDisplayHeight / (STANDARD_HEIGHT * 1.0)).toFloat()
    }

}