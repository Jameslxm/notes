package com.lixm.notes.adapter

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class ChargeAdapter : ChinaCharge {
    private var usaCharge: UsaCharge? = null

    constructor(usaCharge: UsaCharge?) : super() {
        this.usaCharge = usaCharge
    }

    override fun chinaCharge() {
        if(usaCharge != null && usaCharge!!.usaCharge().equals(220)){
            println("符合中国用电")
        }else{
            println("电器被烧毁")
        }
    }
}