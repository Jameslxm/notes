package com.lixm.notes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val service = Executors.newScheduledThreadPool(4)
        service.schedule(Runnable { println(Thread.currentThread().name + "延迟三秒执行") }, 3, TimeUnit.SECONDS)
        service.scheduleAtFixedRate(
            Runnable { println(Thread.currentThread().name + "延迟三秒后每隔2秒执行") },
            3,
            2,
            TimeUnit.SECONDS
        )
    }
}
