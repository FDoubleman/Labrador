package com.fmm.jk_lib.json.gson

import com.google.gson.Gson

// TODO Gson 案例实例

data class ResponseResultBean(val code: Int, val msg: String)

fun main(){
    val gson = Gson()
    println(gson.toJson(ResponseResultBean(200, "恭喜，验证成功")))
    println(gson.fromJson("""{"code":404,"msg":"请求发生异常，请检查网络环境"}""", ResponseResultBean::class.java))
}

// 输出的成果：
/*
    {"code":200,"msg":"恭喜，验证成功"}
    ResponseResultBean(code=404, msg=请求发生异常，请检查网络环境)
*/