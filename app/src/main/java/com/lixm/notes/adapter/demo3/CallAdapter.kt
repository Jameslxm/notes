package com.lixm.notes.adapter.demo3

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
interface CallAdapter<R,T> {
    fun adapter(call: Call<R>): T
    abstract class Factory{
        abstract fun get(): CallAdapter<*,*>
    }
}