package com.fmm.jk_lib.lambda

import java.util.function.Function

fun main() {

    // 一、函数的声明
    val method1: () -> Unit

    val method2: (Int, Int) -> Unit

    val method3: (String, Double) -> Any

    val method4: (Int, Double, Long, String) -> Boolean

    // 二、函数的声明 + 实现
    // 2.1、 : (参数)-> 返回 ___> 基本上属于声明
    // 2.2、 = {参数->方式 } ___> 基本上属于声明实现结合
    val method01: () -> Unit = {
        println("method01 函数被调用了")
    }
    // ()  操作符重载 invoke操作符
    method01()
    method01.invoke()

    val method02 = {
        println("method02 函数被调用了")
    }
    // method02.invoke()
    method02()

    val method02s: () -> Unit = {
        println("method02s 函数被调用了")
    }
    method02s()

    val method03: (String) -> Unit = {
        println("method03 $it ")
        "111"
    }
    method03("999")
    // 再函数的实现处: 声明函数类型，函数类型自动推断
    val method03s = { str: String ->
        println("method03s $str ")
        "sdad"
        11
    }
    method03s("777")

    val method03ss: (String) -> Int = { str: String ->
        println("method03ss $str ")
        "sdad"
        11
    }
    method03ss("111")
    // 先声明   后实现
    val method06: (Int) -> String // 先声明
    method06 = fun(value: Int): String = "method06 : $value"
    println(method06.invoke(999))

    // 声明 + 实现 一气呵成
    val method08: (Int) -> String = { value -> "method08 $value" }
    println(method08(33))

    val method11: (Int) -> Unit = {
        when (it) {
            1 -> {
                println("你传递进来的是一")
            }

            in 2..60 -> {
                println("你传递的是 20 到 60 之内的数字")
            }

            else -> {
                println("都不满足")
            }
        }
    }
    method11(11)
    // _ 拒收，可以提高一点点性能
    val method13: (String, Int, Char) -> Int = { name, age, _ ->
        println("你的名字$name 年龄$age ")
        age
    }
    println(method13("tom", 12, 'a'))
    // 需求：你传入什么，我就打印什么 并且输出
    val method17: (Any) -> Any = {
        println("你传递了 $it")
        it
    }
    println(method17("老铁真的很6！"))

    // 对String 类型添加一个 method19() 拓展方法
    val method19: String.() -> Unit = {
        println("你是 $this")
    }
    "老弟来啦".method19()
    "lalal".past()

    val method20: Int.(Int) -> Int = {
        this + it
    }
    println(10.method20(20))

    // 三、函数的输出类型
    fun t01() {
        println("aa") // 默认 返回Unit
    }

    fun t04(): String {
        return "你来啦！"
    }

    // 函数 调用 后 返回函数类型，可以接着自己调用！
    // t04s 函数 调用后 返回 String 类型
    fun t04s(): String = "你来啦！"

    // s01 函数 调用后 返回 () -> Unit // 类型
    fun s01(): () -> Unit = {} //

    // 等于
    fun s01s(): () -> Unit {
        return {}
    }

    fun s02(str: String): (String) -> Int = {
        11
    }

    fun s02s(str: String): (String) -> Int {
        return {
            11
        }
    }
    println(s02("fff").invoke("fmm"))

    val methodX1: (String) -> Int = fun(str: String): Int {
        // 这里不是lambda体{}，而是方法体
        return str.length
    }

    // 自动类型推断
    val methodX2 = { str: String ->
        str.length
    }
//    val methodX2s:(String)->Int = { str: String ->
//        str.length
//    }
    // Function1<String, Int>  等价于  (String) -> Int
    val methodX3: Function1<String, Int> = {
        it.length
    }
    // Function0<String> 等价于 ()->String
    val methodX3s: Function0<String> = {
        "111"
    }

    // 高阶函数 = Lambda + 函数
    fun aa() {} // 普通函数
    val bb = {} // bb是一个 ()->Unit 类型的变量
    val aa3 = bb // 属于函数引用
    val aa4 = ::aa // :: 就是这个实打实的函数，变成 函数引用 所以可以赋值传递 给另外一个变量

    // 普通函数 才支撑默认参数
    fun show(name: String = "default") {

    }






}


// 对String 添加一个扩展方法
fun String.past() {
    println(this)
}