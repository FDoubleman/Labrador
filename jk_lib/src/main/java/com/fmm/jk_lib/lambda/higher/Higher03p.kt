package com.fmm.jk_lib.lambda.higher

fun main() {

}

private fun loginEngine(userName: String, password: String) {

    loginCheck(userName, password) {name , pwd ->
        // 例如：服务器发起 request
        if (name == "Derry" && pwd == "123456") {
            println("恭喜${name}登录成功")
        } else {
            println("不恭喜${name}登录失败")
        }
    }
}


private fun loginCheck(
    userName: String, password: String,
    block: (String, String) -> Unit
) {
    if (userName.isEmpty() || password.isEmpty()) {
        return
    }
    block(userName, password)
}