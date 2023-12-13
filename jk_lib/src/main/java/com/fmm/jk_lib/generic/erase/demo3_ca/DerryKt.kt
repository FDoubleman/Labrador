package com.fmm.jk_lib.generic.erase.demo3_ca

fun main() {
    val p1 : List<Int> = ArrayList<Int>()
    val p2 : List<Double> = ArrayList<Double>()
    println(p1.javaClass == p2.javaClass) // == 代表对比两者是不是同一个类
    // ArrayList<Integer> or ArrayList<Double> 等 都等于 ArrayList class 所以是true
    // ArrayList<T> 最终还是等于 ArrayList class
}