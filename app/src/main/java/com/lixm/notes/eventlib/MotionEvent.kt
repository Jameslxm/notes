package com.lixm.notes.eventlib

/**
 * Desc
 * Author xm li
 * Date :2021/3/20
 */
class MotionEvent {
    companion object{
        val ACTION_DOWN = 0
        val ACTION_UP = 1
        val ACTION_MOVE = 2
        val ACTION_CANCEL = 3
    }
    var actionMasked: Int = 0
    var x: Int = 0
    var y: Int = 0

    constructor()
    constructor(x: Int, y: Int) {
        this.x = x
        this.y = y
    }

}