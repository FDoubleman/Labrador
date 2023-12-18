package com.fmm.jk_lib.lambda.higher

// TODO 高阶函数第一版
fun main() {
    loginEngine("Derry", "123456")
}

// 登录功能 高阶函数完成
private fun loginEngine(userName: String, userPwd: String) {
    // 使用高阶函数
    loginCheck(userName, userPwd) { name, pwd ->
        // 例如：服务器发起 request
        if (name == "Derry" && pwd == "123456") {
            println("恭喜${name}登录成功")
        } else {
            println("不恭喜${name}登录失败")
        }
    }
}

// 高阶函数 规则
private fun loginCheck(userName: String, userPwd: String, checkResult: (String, String) -> Unit) {
    if (userName.isEmpty() || userPwd.isEmpty()) {
        return
    }

    if (userName == null || userPwd == null) {
        return
    }

    // 做 name pwd 校验工作的
    // ...
    // 省略了 几万行代码

    // 检查通过了，用户名 与 密码 OK
    checkResult(userName, userPwd)
}