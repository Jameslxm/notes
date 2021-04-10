package com.lixm.notes.adapter.demo2

import java.io.BufferedReader

/**
 * Desc
 * Author xm li
 * Date :2021/3/14
 */
class ReaderAdapter : BReader{
    private var isReader: IsReader? = null

    constructor(isReader: IsReader?) {
        this.isReader = isReader
    }

    override fun getBReader(): BufferedReader? {
        return BufferedReader(isReader?.getIsReader())
    }

}