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
    "fmm".run5p(16) {
        println("String 的 拓展函数中 调用参数block 方法体实现")
        println("run5p   this :$this")
        println("run5p   it :$it")
    }

    "fmm".run6p(18) {
        // 要想：lambda中使用this, 就需要lambda需要扩展 T
        //      lambda中使用it ,就需要lambda 需要一个入参
        println("Any 的 拓展函数中 调用参数block 方法体实现")
        // println("run6p   this :$this")
        println("run6p   it :$it")
    }

    19.run6p(20) {
        println("Any 的 拓展函数中 调用参数block 方法体实现")
        // println("run6p   this :$this")
        println("run6p   it :$it")
    }
    'c'.run6p(12) {
        println("Any 的 拓展函数中 调用参数block 方法体实现")
        // println("run6p   this :$this")
        println("run6p   it :$it")
    }

    "fmm".run7p(18) {
        // 这里的
        println("Any 的 拓展函数中 调用参数block 方法体实现")
        println("run7p   this :$this")
        println("run7p   it :$it")
    }
    //
    "fmm".run7ps(18) {
        // 这里的
        println("Any 的 拓展函数中 调用参数block 方法体实现")
        println("run7p   this :$this")
        println("run7p   it :$it")
    }

    "fmm".run7pss(18) {
        // 这里的
        println("Any 的 拓展函数中 调用参数block 方法体实现")
        println("run7p   this :$this")
        println("run7p   it :$it")
    }

    "fmm".run8p(10086){
        println("泛型T 的 拓展函数中 调用参数block 方法体实现")
        // 因为 lambda 不是拓展函数，因此没有 this
        //println("run8p   this :$this")
        // 但是 有参数 it
        println("run8p   it :$it")
    }

    "fmm".run8ps(10010){
        println("泛型T 的 拓展函数中 调用参数block 方法体实现")
        // 因为 lambda 不是拓展函数，因此没有 this
        println("run8ps   this :$this")
        // 但是 有参数 it
        println("run8ps   it :$it")
    }
    11.run8pss(20){
        // 这里 方法 run8pss 中的this和 lambda中的this 是不一致的
        // run8pss 中的this 是Int 类型 11
        // lambda中的this 是 String 类型  老铁
        println("泛型T 的 拓展函数中 调用参数block 方法体实现")
        // 因为 lambda 不是拓展函数，因此没有 this
        println("run8pss   this :$this")
        // 但是 有参数 it
        println("run8pss   it :$it")
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

fun Any.run6p(age: Int, block: (Int) -> Unit) {
    // 方法体中没有it
    println("扩展函数中 run6p 有：$this  传入并调用的参数是 block")
    block(age)
}

/**
 * 小结：拓展方法 中的 this:就是调用拓展方法的对象！
 *      lambda方法 中的 this: 为block传入的第一个参数，
 *       -- 如果可以不传递，则 默认是 调用拓展方法的对象
 */
fun Any.run7p(age: Int, block: Any.(Int) -> Unit) {
    // 方法体中没有it
    println("扩展函数中 run7p 有：$this  传入并调用的参数是 block")
    block("c",age)
    block(11,age)
    block('中',age)
}

// run7ps 是Any的拓展方法，而 lambda 是String拓展方法
fun Any.run7ps(age: Int, block: String.(Int) -> Unit) {
    // 方法体中没有it
    println("扩展函数中 run7ps 有：$this  传入并调用的参数是 block")
    block("固定参数 string 类型",age)
}
fun String.run7pss(age: Int, block: Any.(Int) -> Unit) {
    // 方法体中没有it
    println("扩展函数中 run7pss 有 this：$this  传入并调用的参数是 block")
    block(age)
    block('a', age)
    block(this,age)
    block(123,age)
}

fun <T> T.run8p(age: Int, block: (Int) -> Unit){
    println("扩展函数中 run8p 有 this：$this  传入并调用的参数是 block")
    block(age)
}

fun <T> T.run8ps(age: Int, block: T.(Int) -> Unit){
    // 方法体中没有it
    println("扩展函数中 run8ps 有 this：$this  传入并调用的参数是 block")
    block(this,age)
    // 使用 泛型T 规范了 this 方法和lambda中的this 的统一
//    block(1,age)
//    block("fmm",age)
}

fun <T> T.run8pss(age:Int,block: String.(Int) -> Unit){
    // 方法体中没有it
    println("扩展函数中 run8ps 有 this：$this  传入并调用的参数是 block")
    block("老铁",age)
    // 使用 泛型T 规范了 this 方法和lambda中的this 的统一
//    block(1,age)
//    block("fmm",age)
}


