package com.lixm.notes.model.factory.bridgingabstract class Shape(drawAPI: DrawAPI) {    protected var drawAPI: DrawAPI? = null    init {        this.drawAPI = drawAPI    }    abstract fun draw()}