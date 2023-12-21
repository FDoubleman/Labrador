package com.fmm.jk_lib.lambda.higher

fun main() {
    // 1、String拓展函数调用
    "fmm".run0p()
    // 2、带参数的 String拓展函数 调用
    "fmm".run1p("巴拉巴拉小魔仙")
    // 3、带参数 lambda的拓展函数, lambda的方法实现体中，没有this
    "fmm".run2p {
        println("String 的 拓展函数中 调用参数block 方法体实现")
//        println("run2p   this :$this")
//        println("run2p   it :$it")
    }

    // 4、带参数的lambda的拓展函数，
    // lambda的方法实现体中，有this，而这个this 是 fmm
    "fmm".run3p {
        println("String 的 拓展函数中 调用参数block 方法体实现")
        println("run3p   this :$this")
//        println("run2p   it :$it")
    }

    // 5、带参数的lambda的拓展函数，
    // lambda的方法实现体中，有this，it
    // 而这个this 是 fmm,  it是 lambda 中的参数 是个固定值： 11
    "fmm".run4p {
        println("String 的 拓展函数中 调用参数block 方法体实现")
        println("run4p   this :$this")
        println("run4p   it :$it")
    }

    // 6、带参数的lambda的拓展函数，
    // lambda的方法实现体中，有this，it
    // 而这个this 是 fmm,
    // it是 lambda 中的参数 是run5p方法参数 传入的值
    "fmm".run5p(16){
        println("String 的 拓展函数中 调用参数block 方法体实现")
        println("run5p   this :$this")
        println("run5p   it :$it")
    }



}

// 0、非高阶函数，不含lambda
// 就是一个普通的拓展函数，只是函数方法体内含有 this，可以使用
fun String.run0p() {
    // 方法体中没有It
    println("扩展函数中 run0p 有：$this ")
}

// 1、非高阶函数，不含lambda
// 就是一个普通的拓展函数，只是函数方法体内含有 this，可以使用
fun String.run1p(name: String) {
    // 方法体中没有It
    println("扩展函数中 run1p 有：$this 传入的参数是：$name")
}

// 2、高阶函数，参数中含有lambda
fun String.run2p(block: () -> Unit) {
    // 方法体中没有It
    println("扩展函数中 run2p 有：$this 传入并调用的参数是 block")
    block()
}

fun String.run3p(block: String.() -> Unit) {
    // 方法体中没有It
    println("扩展函数中 run3p 有：$this 传入并调用的参数是 block")
    block()
}

fun String.run4p(block: String.(Int) -> Unit) {
    // 方法体中没有It
    println("扩展函数中 run4p 有：$this  传入并调用的参数是 block")
    block(11)
}

fun String.run5p(age: Int, block: String.(Int) -> Unit) {
    // 方法体中没有It
    println("扩展函数中 run5p 有：$this  传入并调用的参数是 block")
    block(age)
}

