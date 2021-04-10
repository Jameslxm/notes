package com.lixm.notes.adapter.demo3

import java.util.*

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class ExecutorCallAdapterFactory : CallAdapter.Factory(){
    override fun get(): CallAdapter<*, *> {
        return object : CallAdapter<Objects, Call<*>> {
            override fun adapter(call: Call<Objects>): Call<*> {
                println("default")
                return ExecutorCallBack<Objects>()
            }
        }
    }
    class ExecutorCallBack<T> : Call<T>{
        override fun enqueue() {

        }
    }
}