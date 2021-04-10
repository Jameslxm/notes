package com.lixm.notes.adapter.demo2

import java.io.InputStream
import java.io.InputStreamReader

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class IsReaderImpl: IsReader {
    private var inputStream: InputStream? = null

    constructor(inputStream: InputStream?) {
        this.inputStream = inputStream
    }

    override fun getIsReader(): InputStreamReader {
        return InputStreamReader(inputStream)
    }
}