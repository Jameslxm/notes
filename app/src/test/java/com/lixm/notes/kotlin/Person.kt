package com.lixm.notes.kotlinclass Person{    var children: MutableList<Person> = mutableListOf<Person>()    constructor(parent: Person){        parent.children.add(this)    }}