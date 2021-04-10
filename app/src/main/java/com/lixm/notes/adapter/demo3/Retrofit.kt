package com.lixm.notes.adapter.demo3

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class Retrofit {
    var factory: CallAdapter.Factory? = null

    constructor(factory: CallAdapter.Factory?) {
        this.factory = factory
    }
    fun callAdapter(): CallAdapter<*,*>?{
        return factory?.get()
    }

    fun<T> create(): T?{
        var serviceMethod: ServiceMethod<Any,T> = ServiceMethod.Builder<Any,T>(this).build()
        var okHttpCall: OkHttpCall<Any> = OkHttpCall()
        return serviceMethod.adapt(okHttpCall)

    }
    class Builder{
        var factory: CallAdapter.Factory? = null
        fun addCallAdapterFactory(factory: CallAdapter.Factory?) : Builder{
            this.factory = factory
            return this
        }
        fun build(): Retrofit{
            if(factory == null){
                factory = ExecutorCallAdapterFactory()
            }
            return Retrofit(factory)
        }
    }
}