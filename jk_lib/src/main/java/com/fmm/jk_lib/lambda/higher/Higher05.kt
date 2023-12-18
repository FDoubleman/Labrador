package com.fmm.jk_lib.lambda.higher


// TODO 高阶函数第三版

const val nameS : String = "Derry"
const val ageS : Int = 99
fun commonOK() = /*println("我是通用函数")*/ 88
// 省略一万个类型
// ...

// TODO 高阶函数第三版  高阶函数+扩展函数=比较强大的功能
fun main() {
    nameS.myRunOK {  true }
    ageS.myRunOK { false }
    commonOK().myRunOK { true }

    val r : Unit = commonOK().myRunOK {
        println(this)
        println(it)
        true
    }
    println(r)

    "Derry".myRunOK {
        // this == T本身 == 调用者本身 ==  "Derry"
        println("我是:$this")
        false
    }

    123.myRunOK2 {
        // this == T本身 == 调用者本身 ==  123
        println("myRunOk2 我是 :$this")
    }

    777.abc()
    commonOK().abc()
    436.564f.abc()
    "sfdasf".abc()

    "AAAA".derry {

    }

    "AAAA".derry2 {
        // it == Double == 547546.56
    }

    "AAAA".derry3 {
        // 匿名函数扩展  { 持有this == String == "李元霸" }
        /*this == "李元霸"
        it == 547546.56*/
    }

    123.derry4 {
        // this == 123本身
        println("derry4 我是 :$this")
    }

    456.derry5 {
        // it == 456本身
        println("derry5 我是 :$it")
    }

    // 手写HTMl解析语言，相当于手写一门语言
    // 这个才算的是是Kotlin的核心
    /*html {
        head {
            title("")
        }
        body {
            p {

            }

            a {

            }
        }
    }*/

    "DerryOK".run1 {
        this.length
        length
    }

    "DerryOK".run2 {
        it.length
        it.length
    }

    'A'.run3 { t1 : Char ,t2 : Char ,t3: Char ,t4: Char ,t5: Char  ->
        // this == 'A' == 调用者本身  Char
        println(this)
        println(t1)
        println(t2)
        println(t3)
        println(t4)
        println(t5)
    }

    'A'.let {  }

    "AAAAAAAAAAAAAA".showIntLen()

//    123.toast()
//    commonOK().toast()
//    "Derry".toast()
//    'A'.toast()
    // 省略一万个类型
}

// public static
// 给泛型增加 具名abc扩展函数 【我对T扩展，T本身就等于==this】
fun <T> T.abc() {
    // this == T本身 == 调用者本身 ==  "Derry"
    println("abc我是:$this")
}

/*fun JDK.show() {
    // this == JDK本身
}*/

// 给泛型增加 匿名扩展函数  【我对T扩展，T本身就等于==this】
// 我对T扩展，T本身就等于==this
fun <T> T.myRunOK(mm: T.(Float) -> Boolean) {
    // this == T本身 == 调用者本身 ==  "Derry"

    mm(346.56f) // 调用Lambda
}

fun <T> T.myRunOK2(mm: T.() -> Unit) {
    mm()
}

// 循序渐进
fun <T> T.derry(mm: () -> Unit) {
    mm()
}

fun <T> T.derry2(mm: (Double) -> Unit) {
    mm(547546.56)
}

// 匿名函数扩展  { 持有this == String == "李元霸" }
fun <T> T.derry3(mm: String.(Double) -> Unit) {
    "李元霸".mm(547546.56)
}

fun <T> T.derry4(mm: T.(Double) -> Unit) {
    // this == T本身 == this 123/A

    // this.mm(547546.56) // 这个才是他的真身

    mm(547546.56)
}

fun <T> T.derry5(mm: (T) -> Unit) {
    // this == T本身 == this 调用者
    mm(this)
}

// T.()的this,  和  (T)的 it有什么区别?
// T.() { 持有this == T本身 }
// (T) { 持有it == T本身 }
// (Double) { 持有it == Double本身 }

// 公式：我对xxx扩展， lambda实现{ 持有 xxx本身 }

fun <T> T.run1(mm : T.() -> Unit) = this.mm()
fun <T> T.run2(mm : (T) -> Unit) = mm(this)

// T.()    this == T本身 ----> lambda { 持有this }
// (T)     it == T本身 ----> lambda { 持有it }

// T.(Float)括号里的float怎么理解呢  ----> lambda { 持有this == T    持有it == Float}
// T.(T) 怎么理解呢  ----> lambda { 持有this == T    持有it == T}

fun <T> T.run3(mm : T.(T, T ,T ,T ,T) -> Unit) = this.mm(this, this, this, this, this)
// T.run3 函数本身 会持有this == T

// public static void showIntLen(Kotlin编译期生成 this$String) { ... }
fun String.showIntLen() {
    // this == String == 调用者本身
    println("你的内容是:$this 你的长度是:${this.length}")
}

//fun<T> T.toast() = Toast.makeText(null, this.toString(), Toast.LENGTH_LONG).show()

// run1和mm的区别是什么？   mm就是lambda   run1是泛型的函数扩展而已

// T.() 会给我们的 mm的lambda   就会产生  lambda实现体里面持有this == T本身 == 123.T 所以this等于123
// (T)                                 lambda实现体里面持有it == T本身 == 123.T 所以this等于123