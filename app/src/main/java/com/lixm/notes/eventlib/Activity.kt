package com.lixm.notes.eventlib

/**
 * Desc
 * Author xm li
 * Date :2021/3/21
 */
class Activity {

    fun main(vararg arg: String){
        var viewGroup = ViewGroup(0, 0, 1080, 1920)
        viewGroup.name = "顶层容器"

        var viewGroup1 = ViewGroup(0, 0, 1080, 1920)
        viewGroup1.name = "第二级容器"

        var view = View(0, 0, 300, 600)
        view.name = "子控件"


    }
}