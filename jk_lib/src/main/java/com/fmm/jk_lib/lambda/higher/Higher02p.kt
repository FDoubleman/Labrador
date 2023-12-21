package com.fmm.jk_lib.lambda.higher

fun main() {

    var fun4: (Int, Int) -> String = { v1, v2 ->
        ""
    }

    val fun4s = fun(v1: Int, v2: Int): String {
        return ""
    }

    val fun4ss = fun(n1: Int, n2: Int)// 函数本身
            : (Int, Int) -> String { // 函数返回值定义，只是返回类型为(Int,Int)->String
        return { v1, v2 -> // 返回类型为(Int,Int)->String lambda
            "\"两个数相加:${n1 + n2}  v1:$v1 v2:$v2"
        }
    }
    println(fun4ss(100, 100).invoke(20, 30))

    val k01: (String) -> (String) -> (Int) -> (Boolean) -> (String) -> Int =
        { str: String ->
            { it: String ->
                { it: Int ->
                    { it: Boolean ->
                        { it: String ->
                            11
                        }
                    }
                }
            }
        }

    println(k01("aa")("bb")(12)(false)("ccc"))
}