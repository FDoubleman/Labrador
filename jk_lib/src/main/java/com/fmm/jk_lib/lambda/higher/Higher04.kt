package com.fmm.jk_lib.lambda.higher

// TODO 高阶函数第二版 常用的登录
fun main() {
    // 站在用户角度上
    loginEngine("Derry 23", "123456") {
        if (it) println("最终登录的结果是：登录成功") else println("最终登录的结果是：登录失败!!")
    }

    "DerryAAAAA".showIntLen()

    // 123.toast()
}

private fun loginEngine(userName: String, userPwd: String, responseResult: (Boolean) -> Unit) {
    if (userName == "Derry" && userPwd == "123456") {
        responseResult(true)
    } else {
        responseResult(false)
    }
}