package com.lixm.notes.kotlin.commissionclass BaseImpl(var x: Int) : Base {    override val message: String        get() = "BaseImpl: x = $x"    override fun print() {        println(message)    }}