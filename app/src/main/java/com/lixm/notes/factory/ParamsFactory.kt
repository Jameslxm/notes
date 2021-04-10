package com.lixm.notes.factory

/**
 * Desc
 * Author xm li
 * Date :2021/3/13
 */
object ParamsFactory {
    fun createApi(params: Int): Api?{
        when(params){
            1 ->{
                return Api1Iml()
            }
            2 -> {
                return Api2Iml()
            }
            else -> {
                return null
            }
        }
    }
}