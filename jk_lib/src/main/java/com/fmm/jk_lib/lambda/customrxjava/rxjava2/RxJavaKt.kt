package com.fmm.jk_lib.lambda.customrxjava.rxjava2

// TODO KT精华 难度极高

fun main() {
    /*setText {
        button {
            setColor {

            }
        }
    }

    html {
        head {

        }
        body {

        }
    }*/

    // 第二期 RxJava 源码分析 Java筑基里面   Derry目前最好的课

    create { // 没有输入，意味着，没有it 没有this
        "Derry"
        64654
        6546.65
        'A'
        6466.5f // 最后一行作为输出  输出给下一个环节 map
    }.map {
        123
    }.map {
        true
    }.map {
        65466.6
    }.consumer {
        println("消费:$this") // 没有输出，为什么，因为直接消费就完成了
    }

    create {
        "Derry"
    }.map {
        length
    }.map {
        "内容的长度是:$this"
    }.map {
        "【$this】"
    }.consumer {
        println("消费:$this")
    }

    create {
        "DDD"
    }.map {  // 隐式的this，可以省略，   但是 it不可以做到
        length
    }
}

// 中转站目的：  保存最新的item    给map输入用   给map输出保存到item

// 中转站 保存你要流向下去的数据
class Helper<T>(private var item: T) // var item: T 这个item是一直在更新的
{
    // item == 6466.5f
    // item == 123

    // map可以链式调用
    fun<R> map(action: T.() -> R) : Helper<R>
    {
        val newItem: R = action(item)
        // newItem == 123
        return Helper<R>(newItem)
    }

    // 思路：消费 只需要 上一个操作符的返回类型就可以了，我不需要返回，所以不会设计R
    fun consumer(action: T.() -> Unit) = action(item)
}

// 思路：输入你不需要考虑，因为是最后一行作为流向输出的数据
// 思路：中转站就是为了转化（保存）我们的create 和 map 等等的数据
fun <R> create(action: () -> R) : Helper<R>
{
    val r: R = action() // r == 6466.5f
    return Helper<R>(r)
}

// 中转站：
// 1.链式调用 create{}.map{}.map
// 2就是维护这个效果， 上一个操作符返回值  是 下一个操作符的参数
