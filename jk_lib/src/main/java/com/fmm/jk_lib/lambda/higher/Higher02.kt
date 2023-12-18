package com.fmm.jk_lib.lambda.higher

// TODO lambda上节课 的考试，此考试意味着，考试掌握的话，你后面会轻松 （KT精华 有难度是很正常）
fun main() {

    // （int，int）->String这个应该是返回值类型声明吧
    // 考试：函数返回一个函数
    val fun4 = fun(n1aaa: Int, n2aaa: Int)  // fun4函数本身

            : (Int, Int) -> String // fun4函数的函数 以返回值返回了这个函数

            = {n1, n2 -> "两个数相加:${n1 + n2}  n1aaa:$n1aaa" } // fun4函数的函数 以返回值返回了这个函数 的 实现

    println(fun4(100, 100)(1000, 1000))

    // 考试：你掌握了，你的lambda基本上每一对手了
    val k01 : (String) -> (String) -> (Boolean) -> (Int) -> (String) -> Int =
    { it: String ->
        { it: String ->
            { it: Boolean ->
                { it: Int ->
                    { it: String ->
                        99
                    }
                }
            }
        }
    }
    println(k01("AAA")("BBB")(true)(888)("Derry"))

}