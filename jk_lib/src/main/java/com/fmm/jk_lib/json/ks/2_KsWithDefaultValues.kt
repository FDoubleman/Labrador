package com.fmm.jk_lib.json.ks

//import kotlinx.serialization.ImplicitReflectionSerializer
//import kotlinx.serialization.Serializable
//import kotlinx.serialization.json.Json
//import kotlinx.serialization.parse
//import kotlinx.serialization.stringify

// TODO Kotlinx.serialization 简称KS 有默认值的情况

//@Serializable
//data class StudentDefaults(val name: String, val age: Int = 36)
//
//@ImplicitReflectionSerializer
//fun main(){
//    println(Json.stringify(StudentDefaults("Derry")))
//    println(Json.parse<StudentDefaults>("""{"name":"Derry"}"""))
//}

// 输出的成果：
/*
    {"name":"Derry","age":36}
    StudentDefaults(name=Derry, age=36)
*/

// TODO 直接生成字节码的
//    1.纯Kotlin工程，可以用 KS