package com.fmm.jk_lib.lambda.higher

// TODO 高阶函数入门 说白了：函数中有lambda就是属于高阶函数， 函数的函数就是高阶函数
fun main() {
    var r : String = show01(99) { /*it: Int ->*/
        "Str it:$it"
    }
    println(r)

    // 三数相乘
    show02(1, 2, 3) { n1, n2, n3 ->
        println(n1 * n2 * n3)
    }

    // 三数相加
    show02(1, 2, 300) { n1, n2, n3 ->
        println(n1 + n2 + n3)
    }

    // 三数相除
    show02(100, 2, 2) { n1, n2, n3 ->
        println(n1 / n2 / n3)
    }
}

// show01 返回的是什么类型？ String 因为Lambda是返回String
fun show01(number: Int, lambda : (Int) -> String) : String = lambda.invoke(number)

// 需求：三数相乘  三数相加 三数相除  由用户指定，我只定义规则（高阶函数）
fun show02(number1: Int, number2: Int, number3: Int, lambda: (Int, Int, Int) -> Unit) =
    lambda(number1, number2, number3) // 调用Lambda而已