package com.fmm.jk_lib.lambda.higher

fun main() {
    // 第一版
    show01p(10, {
        "lambda 中返回的参数"
    })
    // 第二版
    show01p(20) {
        "lambda 中返回的参数"
    }

//    show02p(1,2,3,{ v1,v2,v3 ->
//        v1+v2+v3
//    })
    // 具体实现 ，规则由调用者自己实现
    val add = show02p(1,2,3) { v1, v2, v3 ->
        v1 + v2 + v3
    }
    println(add)

    val minus = show02p(5,2,1){v1, v2, v3 ->
        v1 - v2 - v3
    }
    println(minus)
}


fun show01p(namber: Int, block: () -> String) {
    println("show01p 参数namber 的值：$namber")
    println(block())
}

// 定义 规则
fun show02p(v1: Int, v2: Int, v3: Int, block: (Int, Int,Int) -> Int):Int {
    return block(v1,v2,v3)
}