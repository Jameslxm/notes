package com.lixm.notes.model.factoryclass ShapeFactory {    //使用 getShape 方法获取形状类型的对象    fun getShape(shapeType: String?): Shape? {        if (shapeType == null) {            return null        }        return when {            shapeType.equals("CIRCLE", ignoreCase = true) -> Circle()            shapeType.equals("RECTANGLE", ignoreCase = true) -> Rectangle()            shapeType.equals("SQUARE", ignoreCase = true) -> Square()            else -> null        }    }}