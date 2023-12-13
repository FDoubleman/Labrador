package com.fmm.jk_lib.json.gson

import com.google.gson.Gson

// TODO Gson 案例实例 有默认值的情况

data class StudentDefaults(val name: String, val age: Int = 36)

fun main(){
    val gson = Gson()
    println(gson.toJson(StudentDefaults("Derry")))
    println(gson.fromJson("""{"name":"Derry"}""", StudentDefaults::class.java))
}

// 输出的成果：
/*
    {"name":"Derry","age":36}  序列化没有问题
    StudentDefaults(name=Derry, age=0)  反序列化，无法得知Kotlin的默认参数
*/

// TODO Gson根本就无法知道，Kotlin默认值的概念，所以是0
//  纯Java工程，用Gson