package com.lixm.notes.adapter.demo3


/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class ServiceMethod<R,T> {

    var callAdapter: CallAdapter<R,T>? = null
    constructor(buidler:Builder<R,T>){
        callAdapter = buidler.callAdapter
    }
    fun adapt(call: Call<R>): T? {
        return callAdapter?.adapter(call)
    }

    class Builder<R,T>{
        var callAdapter: CallAdapter<R,T>? = null
        var retrofit: Retrofit? = null

        constructor(retrofit: Retrofit?) {
            this.retrofit = retrofit
        }
        fun build(): ServiceMethod<R,T> {
            callAdapter = createCallAdapter()
            return ServiceMethod(this)
        }
        private fun <R, T> createCallAdapter(): CallAdapter<R, T>? {
            return retrofit?.callAdapter() as? CallAdapter<R, T>
        }
    }

}