package com.fmm.jk_lib.lambda.customrxjava

fun main() {
    "".apply {

    }.apply {

    }

    "".myApplyp {

    }

    val pp = "".let {
        ""
        10
    }

    "".myLet {

    }

    val p2 = "".run {
        "asd"
    }.run {

    }

    "my".myRun {
        ""
        10
    }.myRun {

    }

    "".also {
        10
    }.also {

    }

    "".myAlso {

    }.myAlso {

    }

    /***
     * run 、let 、also、apply
     */

}

fun <T> T.myAlso(block: (T) -> Unit): T {
    block(this)
    return this
}

fun <T, R> T.myRun(block: T.() -> R): R {
    return block()
}

fun <T> T.myLet(block: (T) -> Unit) {

}


fun <T> T.myApplyp(block: T.() -> Unit): T {
    block()
    return this
}