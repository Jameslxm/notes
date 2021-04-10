package com.lixm.notes.eventlib.listener

import com.lixm.notes.eventlib.MotionEvent
import com.lixm.notes.eventlib.View

/**
 * Desc
 * Author xm li
 * Date :2021/3/20
 */
interface OnTouchListener {
    fun onTouch(view: View,motionEvent: MotionEvent): Boolean
}