package com.example.bootkotlin.template

interface TextTemplate<T> {
    val template: T
    var prefix: String
    var suffix: String

    fun replace(vars: Map<String, Any>): String
}
