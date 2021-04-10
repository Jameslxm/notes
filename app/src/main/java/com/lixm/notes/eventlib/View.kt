package com.lixm.notes.eventlib

import com.lixm.notes.eventlib.listener.OnClickListener
import com.lixm.notes.eventlib.listener.OnTouchListener


/**
 * Desc
 * Author xm li
 * Date :2021/3/20
 */
open class View {
    var name: String? = null
    var left: Int = 0
    var top: Int = 0
    var right: Int = 0
    var bottom: Int = 0
    var onTouchListener: OnTouchListener? = null
    var onClickListener: OnClickListener? = null

    constructor(left: Int, top: Int, right: Int, bottom: Int) {
        this.left = left
        this.top = top
        this.right = right
        this.bottom = bottom
    }


    fun isContain(x: Int, y: Int): Boolean {
        if(x > left && x < right && y > top && y < bottom){
            return true
        }
        return false
    }

    open fun dispatchTouchEvent(event: MotionEvent): Boolean {
        System.out.println("${name} View dispatchTouchEvent")
        var result = false
        if(onTouchListener != null && onTouchListener!!.onTouch(this,event)){
            result = true
        }
        if(!result && onTouchEvent(event)){
            result = true
        }
        return result
    }
    fun onTouchEvent(event: MotionEvent): Boolean{
        System.out.println("${name} View onTouchEvent")
        if(onClickListener != null){
            onClickListener?.onClick(this)
            return true
        }
        return false
    }

    override fun toString(): String {
        return "name:${name}"
    }

}