package com.fmm.jk_lib.lambda.customrxjava.rxjava5

// TODO KT精华 难度极高

fun main() {
    create {
        "Derry"
    }.map {
        length
    }.map {
        "内容的长度是:$this"
    }.map {
        "【$this】"
    }.consumer { // 不需要返回，直接消费，就不需要 R，所以是 Unit
        println("消费:$this")
    }
}

fun <R> create(action: () -> R) : R = action() // 把 "Derry"保存到R泛型里面去
fun<T, R> T.map(action: T.() -> R) : R = action(this) // this == "Derry"     R=length 5
fun<T> T.consumer(action: T.() -> Unit) = action(this) // this == length 5


