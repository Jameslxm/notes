package com.lixm.notes.adapter

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class Usa : UsaCharge(){
    override fun usaCharge(): Int {
        println("工程师修改了电压")
        return 220
    }
}