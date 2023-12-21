package com.fmm.jk_lib.lambda.higher

fun main() {

    loginEngine("fmm","123456"){
        if(it){
            println("登录成功")
        }else{
            println("登录失败")
        }
    }
}

private fun loginEngine(userName: String, userPwd: String,
                        block: (Boolean) -> Unit) {
    if (userName == "Derry" && userPwd == "123456") {
        block(true)
    } else {
        block(false)
    }

}