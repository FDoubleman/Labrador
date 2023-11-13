package com.fmm.jk_lib.jutlis

object LogUtils {

    @JvmStatic
    fun d(msg: String) {
        println("Labrador : $msg" )
    }
    @JvmStatic
    fun d(msg: String, tag: String = "Labrador") {
        println("$tag : $msg" )
    }


}