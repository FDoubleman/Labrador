package com.fmm.jk_lib.json.moshi

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

// TODO Moshi

@JsonClass(generateAdapter = true)
data class PersonWithDefaults(val name: String, val age: Int = 36)

fun main(){
    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val jsonAdapter = moshi.adapter(PersonWithDefaults::class.java)

    println(jsonAdapter.toJson(PersonWithDefaults("Benny Huo")))
    println(jsonAdapter.fromJson("""{"name":"Benny Huo"}"""))
}

// 输出的成果：
/*
    {"name":"Benny Huo","age":36}
    PersonWithDefaults(name=Benny Huo, age=36)
*/

// TODO kapt kapt注解处理器 + 反射 = 实现了这个效果
//    1.Java与Kotlin混合的项目工程，用Moshi
//    2.Kotlin的项目工程用Moshi