package com.fmm.jk_lib.lambda.customrxjava.rxjava5

fun main() {
    createp { // 没有输入，意味着，没有it 没有this
        "Derry"
        64654
        6546.65
        'A'
        6466.5f // 最后一行作为输出  输出给下一个环节 map
    }.mapp { it: Float -> // it == 6466.5f
        123
    }.mapp { it: Int ->
        true
    }.mapp { it: Boolean ->
        65466.6
    }.consumerp { it: Double ->
        println("消费:$it") // 没有输出，为什么，因为直接消费就完成了
    }
}

fun <T> T.consumerp(block: (T) -> Unit) {
    block(this)
}

/**
 * 首先  任意的类型都能调用 mapp{} ,确认了 mapp是一个Any或者T泛型的 拓展 函数 Any.mapp || T.mapp
 * 其次  mapp{}调用形式，确认了mapp()方法中有 lambda表达式，
 * 接着  lambda表达式可以自由的使用 it，因此 确定：(Any)->   || (T)->
 * 接着  lambda表达式可以 返回任意 类型，确认了 (Any)-> Any  || (T)->Any || (Any)-> R  || (T)->R 这几种类型
 * 如何确认 使用Any 还是 T 呢？
 * 看下面返回值的使用  如果不需要关心lambda返回的类型则都行，需要关心lambda返回的类型 则 使用泛型 ,
 * 而 返回值类型和 参数 泛型T类型 ，并没有关系。因此 需要新的 泛型类型 R
 *
 *
 */
fun <T, R> T.mapp(block: (T) -> R): R {
    return block(this)
}

 // createp 没有输入，意味着，没有it 没有this,但是却有返回值，
 //  返回lambda 最后一行 的类型。 因此 使用泛型 T 或者 Any 都能满足
 //  但是 如果使用Any，则 mapp 的调用者 一直是Any ,而不是 String、Int、Char等类型
 // 所以使用 泛型T 表示
// fun createp(block: () -> Any): Any {
//     return block()
// }
fun <T> createp(block: () -> T): T {
    return block()
}