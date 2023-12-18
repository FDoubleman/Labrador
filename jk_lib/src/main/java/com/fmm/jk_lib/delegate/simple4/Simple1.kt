package com.fmm.jk_lib.delegate.simple4

import kotlin.reflect.KProperty

private var userName : String by UserNameDelegate()

class UserNameDelegate {
    private var realUserName = "真实姓名"
    operator fun getValue(thisRef : Any? , property : KProperty<*>) : String {
        println("委托了属性获取")
        return realUserName
    }

    operator fun setValue(thisRef : Any?, property : KProperty<*>, value : String) {
        println("委托了属性设置")
        realUserName = value
    }
}

var name1: String = "九阳神功"
var name2: String by ::name1

fun main() {

    name2 = "三分归元气"

    println("name1:$name1")
    println("name2:$name2")

    println()

    userName = "AAA"
    println(userName)
}