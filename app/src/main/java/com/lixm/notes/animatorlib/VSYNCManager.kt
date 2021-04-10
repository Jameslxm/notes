package com.lixm.notes.animatorlib

/**
 * Desc
 * Author xm li
 * Date :2021/4/1
 */
class VSYNCManager {
    val ourInstance: VSYNCManager = VSYNCManager()

    var list: MutableList<AnimationFrameCallback> = ArrayList()
    fun getInstance() : VSYNCManager{
        return ourInstance
    }
    var runnable: Runnable = object : Runnable{
        override fun run() {
            Thread.sleep(16)
            list.forEach {
                it.doAnimationFrame(System.currentTimeMillis())
            }
        }

    }
    init {
        Thread(runnable).start()
    }
   interface AnimationFrameCallback{
       fun doAnimationFrame(currentTime: Long): Boolean
   }
    fun add(animationFrameCallback: AnimationFrameCallback){
        list.add(animationFrameCallback)
    }
}