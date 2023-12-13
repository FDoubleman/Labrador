package com.fmm.jk_lib.json.moshi

import com.squareup.moshi.Moshi

// TODO Moshi

data class ResponseResultBean(val code: Int, val msg: String)

fun main(){
    val moshi = Moshi.Builder().build()
    // 自定义适配器，用户指定效果 Jason
    val jsonAdapter = moshi.adapter(ResponseResultBean::class.java)
    println(jsonAdapter.toJson(ResponseResultBean(200, "恭喜，验证成功")))
    println(jsonAdapter.fromJson("""{"code":404,"msg":"请求发生异常，请检查网络环境"}"""))
}

// 输出的成果：
/*
    {"code":200,"msg":"恭喜，验证成功"}
    ResponseResultBean(code=404, msg=请求发生异常，请检查网络环境)
*/