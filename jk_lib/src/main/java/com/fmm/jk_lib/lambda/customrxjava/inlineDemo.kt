package com.fmm.jk_lib.lambda.customrxjava

fun main() {
    // 不加inline的效果
    // show((Function0)null.INSTANCE);  对象开辟的浪费

    // 加inline的效果
    /*String var2 = "AAA";
    System.out.println(var2);*/

    show {
        println("AAA")
    }

    // 相当于 C++ 宏替换 文本替换  inline会做优化，不需要你开辟空间浪费
}

// 高阶函数，尽量加inline
inline fun show(lambda: () -> Unit) {
    lambda()
}