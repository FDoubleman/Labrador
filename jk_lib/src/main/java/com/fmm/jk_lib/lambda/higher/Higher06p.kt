package com.fmm.jk_lib.lambda.higher

fun main() {
    // 第1版
    showp("电风扇", block = {
        println("$it 真凉快！！")
    })
    // 第2版
    showp("电风扇", {
        println("$it 真凉快！！")
    })
    // 第 3 版
    showp("电风扇") {
        println("$it 真凉快！！")
    }
    // 第 4 版
    showp("电风扇") {
        println("$it 真凉快！！")
    }
    // 第 5 版
    showp {
        println("$it 真凉快！！")
    }

    show2p({
        println("block1  it : $it")
    },{
        println("block2  it : $it")
    })

}

fun showp(name: String = "fmm", block: (String) -> Unit) {
    block(name)
}

fun show2p(block: (String) -> Unit, block2: (Int) -> Unit) {
    block("fmm")
    block2(18)
}