package com.fmm.jk_lib.lambda.higher

class AndroidClickListenerP<T> {
    // 定义集合存储，action.  可以理解为接口！
    private val actions = mutableListOf<(T?) -> Unit>()
    private val values = mutableListOf<T?>()

    fun addListener(value: T?, action: (T?) -> Unit) {
        actions += action // add 添加用户自定义的事件 到 集合
        values += value // add 添加用户自定义的数据 到 集合
    }

    fun touchListeners() {
        if (actions.isEmpty()) {
            println("你还没有添加任何事件呀")
            return
        }
        actions.forEachIndexed { index, function ->
            function(values[index])
        }
        actions.forEachIndexed { index, function: (T?) -> Unit ->
            function(values[index])
        }
    }
}


fun main() {

    val func = AndroidClickListenerP<String>()
    func.touchListeners()

    func.addListener("Java") {
        println("事件 被触发 ，学习 $it")
    }

    func.addListener("Kotlin") {
        println("事件 被触发 ，学习 $it")
    }

    func.addListener("Python") {
        println("事件 被触发 ，学习 $it")
    }

    func.touchListeners()
    println()

    // 我很好奇 为什么show1P 没有传递参数，
    // 其实 -> ::show1P  是 (T?) -> Unit 的类型
    // 具名函数作为事件
    func.addListener("老铁666", ::show1P)

    // Lambda 不支持泛型 ，用Any代替，  Lambda不支持 默认参数
    // val result: (T?) -> Unit = ::show1P

    // 具名函数事件随意传递
    val result: (Any?) -> Unit = ::show1P
    // 直接作为变量 不需要 ::
    func.addListener("PHP", result)

    val result2:(Any?)->Unit ={

    }

}

fun <T> show1P(value: T?) {
    println("事件 被触发 ，学习 $value")
}

