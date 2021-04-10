package com.lixm.notes.adapter.demo3

import io.reactivex.Observable
import io.reactivex.ObservableOnSubscribe
import java.util.*

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class RxJavaCallAdapterFactory: CallAdapter.Factory() {
    override fun get(): CallAdapter<*, *> {
        return object : CallAdapter<Objects, Observable<*>> {
            override fun adapter(call: Call<Objects>): Observable<*> {
                println(">>>Observable")
                var subscribe : ObservableOnSubscribe<*> = ObservableOnSubscribe<Objects> {

                }
                return Observable.create(subscribe)

            }
        }
    }
}