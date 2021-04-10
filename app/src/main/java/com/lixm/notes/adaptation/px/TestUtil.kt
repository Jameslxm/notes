package com.lixm.notes.adaptation.px

import android.content.Context

/**
 * Desc
 * Author xm li
 * Date :2021/4/7
 */
class TestUtil(context: Context) {
    companion object {
        private var instance: TestUtil? = null
        fun getInstance(context: Context): TestUtil? {
            if (instance == null) {
                instance = TestUtil(context)
            }
            return instance
        }
    }

    init {
        context.applicationContext.assets
    }
}