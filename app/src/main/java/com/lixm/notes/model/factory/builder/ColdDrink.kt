package com.lixm.notes.model.factory.builderabstract class ColdDrink : Item {    override fun packing(): Packing {        return Wrapper()    }    abstract override fun price(): Float}