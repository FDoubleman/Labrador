package com.fmm.jk_lib.lambda.higher

fun main() {
    // 以前的做法(匿名函数体)，规则 输入为整形，输出为字符串
    showActionP {
        "lambda 的参数值： $it"
    }
    // 一般源码的做法(具名函数，可以随意传递)
    showActionP(::lambdaImp)

    val r1: Function1<Int, String> = ::lambdaImpl
    val r2: (Int) -> String = r1
    // 这里 的 Int.() 等价于 (Int)    Int.()  Int.属于来源，会自动把来源作为第一个参数
    val r3:Int.() ->String = r2

    // Int.(String) -> Unit 是两个输入参数的？  等价于  (Int, String) -> Unit
}


fun lambdaImp(value: Int): String {
    return "lambdaImp ....$value"
}

fun showActionP(action: (Int) -> String) {
    println(action(888))// 调用 打印Lambda的返回值
}