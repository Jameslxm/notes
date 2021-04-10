package com.lixm.notes.adapter

import com.lixm.notes.adapter.demo2.IsReaderImpl
import com.lixm.notes.adapter.demo2.ReaderAdapter
import com.lixm.notes.adapter.demo3.Retrofit
import org.junit.Test
import java.io.FileInputStream

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class AdapterTest {
    @Test
    fun test(){
        var chargeAdapter = ChargeAdapter(Usa())
        chargeAdapter.chinaCharge()
    }

    @Test
    fun test2(){
        var fileInputStream = FileInputStream("/Users/lixinman/Desktop/jiekou/Attainment.txt")
        var readerAdapter = ReaderAdapter(IsReaderImpl(fileInputStream))
        var bReader = readerAdapter.getBReader()
        println(bReader?.readLines())
    }

    @Test
    fun test3(){
        var retrofit: Retrofit = Retrofit
            .Builder()
//            .addCallAdapterFactory(RxJavaCallAdapterFactory())
            .build()
        retrofit.create<Any>()
    }

}