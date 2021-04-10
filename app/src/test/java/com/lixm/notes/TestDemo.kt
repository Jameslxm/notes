package com.lixm.notes

import com.lixm.notes.eventlib.MotionEvent
import com.lixm.notes.eventlib.View
import com.lixm.notes.eventlib.ViewGroup
import com.lixm.notes.eventlib.listener.OnTouchListener
import org.junit.Test

/**
 * Desc
 * Author xm li
 * Date :2021/3/21
 */
class TestDemo {
    @Test
    fun test1(){
//        loop@ for (i in 1..3) {
//            for (j in 1..100) {
//                System.out.println("j=$j")
//                if (j < 3) continue@loop
//            }
//            System.out.println("i=$i")
//        }
//        System.out.println("test1")
        foo()
    }

    fun foo() {
//        run loop@{
            listOf(1, 2, 3, 4, 5).forEach {
                if (it == 3) return@forEach // 从传入 run 的 lambda 表达式非局部返回
                print(it)
            }
//        }
        print(" done with nested loop")
    }

    @Test
    fun testEvent(){
        var viewGroup = ViewGroup(0, 0, 1080, 1920)
        viewGroup.name = "顶层容器"

        var viewGroup1 = ViewGroup(0, 0, 1080, 1920)
        viewGroup1.name = "第二级容器"

        var view = View(0, 0, 300, 600)
        view.name = "子控件"

        viewGroup1.addView(view)
        viewGroup.addView(viewGroup1)
        viewGroup?.onTouchListener = object : OnTouchListener {
            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
                println("顶层容器 onTouch")
                return false
            }
        }
        viewGroup1?.onTouchListener = object : OnTouchListener {
            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
                println("第二级容器 onTouch")
                return false
            }
        }
        view?.onTouchListener = object : OnTouchListener {
            override fun onTouch(view: View, motionEvent: MotionEvent): Boolean {
                println("子控件 onTouch")
                return false
            }
        }
//        view?.onClickListener = object : OnClickListener{
//            override fun onClick(view: View) {
//                println("子控件 onClick")
//            }
//
//        }

        var motionEvent = MotionEvent(100, 100)
        motionEvent.actionMasked = MotionEvent.ACTION_DOWN
        viewGroup.dispatchTouchEvent(motionEvent)


    }
}