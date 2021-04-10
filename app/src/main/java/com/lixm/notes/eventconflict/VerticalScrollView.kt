package com.lixm.notes.eventconflict

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.widget.ScrollView

/**
 * Desc
 * Author xm li
 * Date :2021/3/21
 */
class VerticalScrollView : ScrollView {
    var mDouwnPosX: Float = 0f
    var mDownPosY: Float = 0f
    constructor(context: Context?) : this(context,null)
    constructor(context: Context?, attrs: AttributeSet?) : this(
        context,
        attrs,0
    )

    constructor(
        context: Context?,
        attrs: AttributeSet?,
        defStyleAttr: Int
    ) : super(context, attrs, defStyleAttr) {

    }

    override fun dispatchTouchEvent(ev: MotionEvent?): Boolean {
        if(ev == null) return super.dispatchTouchEvent(ev)
        var x = ev.x
        var y = ev.y

        when(ev?.action){
            MotionEvent.ACTION_DOWN -> {
                mDouwnPosX = x
                mDownPosY = y
                parent.requestDisallowInterceptTouchEvent(true)
            }
            MotionEvent.ACTION_MOVE -> {
                var deltaY = y - mDownPosY
                if(y - mDownPosY > 0){
                    if(scrollY == 0){
                        parent.requestDisallowInterceptTouchEvent(false)

                    }
                }else if(scrollY >= getChildAt(0).height - height){
                    //height 是这个VerticalScrollView的高，getChildAt(0).height是第一个视图设置的高
                    //整个意思是否滑到底
                    parent.requestDisallowInterceptTouchEvent(false)
                }
            }
        }
        return super.dispatchTouchEvent(ev)
    }
}