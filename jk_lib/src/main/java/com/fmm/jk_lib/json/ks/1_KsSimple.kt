package com.fmm.jk_lib.json.ks

//import kotlinx.serialization.ImplicitReflectionSerializer
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.parse
//import kotlinx.serialization.stringify

// TODO Kotlinx.serialization 简称KS

//@Serializable
//data class ResponseResultBean(val code: Int, val msg: String)


//@ImplicitReflectionSerializer
//fun main(){
//    println(Json.stringify(ResponseResultBean(200, "恭喜，验证成功")))
//    println(Json.parse<ResponseResultBean>("""{"code":404,"msg":"请求发生异常，请检查网络环境"}"""))
//}

// 输出的成果：
/*
    {"code":200,"msg":"恭喜，验证成功"}
    ResponseResultBean(code=404, msg=请求发生异常，请检查网络环境)
*/