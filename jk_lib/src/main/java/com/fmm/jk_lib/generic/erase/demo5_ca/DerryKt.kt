package com.fmm.jk_lib.generic.erase.demo5_ca

fun main() {
    val list1: List<*> = ArrayList<Any>()
    val list2: List<*> = ArrayList<String>()
    val list3: List<*> = ArrayList<Double>()

    val list1e: List<out Any> = ArrayList<Any>()
    val list2e: List<out Any> = ArrayList<String>()
    val list3e: List<out Any> = ArrayList<Double>()
}