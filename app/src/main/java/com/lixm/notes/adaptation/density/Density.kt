package com.lixm.notes.adaptation.density

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration

/**
 * Desc
 * Author xm li
 * Date :2021/4/10
 */
object Density {
    private val WIDTH : Float = 384f
    private var appDensity : Float= 0f
    private var appScaledDensity : Float= 0f
    fun setDensity(application: Application,activity: Activity){
        var displayMetrics = application.resources.displayMetrics
        if(appDensity == 0f){
            //初始化赋值操作
            appDensity = displayMetrics.density
            appScaledDensity = displayMetrics.scaledDensity
            application.registerComponentCallbacks(object : ComponentCallbacks{
                override fun onLowMemory() {

                }

                override fun onConfigurationChanged(newConfig: Configuration?) {
                    if(newConfig != null && newConfig.fontScale > 0){
                        appScaledDensity = application.resources.displayMetrics.scaledDensity
                    }
                }

            })
        }
        var targetDensity = displayMetrics.widthPixels / WIDTH
        var targetScaledDensity = targetDensity * (appScaledDensity / appDensity)
        var targetDensityDpi: Int = (targetDensity / 160).toInt()
        //替换activity 的值
        var dm = activity.resources.displayMetrics
        dm.density = targetDensity
        dm.scaledDensity = targetScaledDensity
        dm.densityDpi = targetDensityDpi
    }
}