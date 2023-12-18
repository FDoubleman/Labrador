package com.fmm.jk_lib.delegate.simple4

import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaField

private operator fun String.setValue(item: Item, property: KProperty<*>, value : String) {
    // this = value

    println(property) // var com.fmm.jk_lib.delegate.simple4.Item.version222: kotlin.String【能够动态得到，所以可以反射】

    // Kotlin的反射才能做到了【反射：修改 version222变量的值 为 value】
    property.javaField?.isAccessible = true
    property.javaField?.set(item, value)

    // 只能修改 version222变量的值，   不能修改 version111变量的值
}

// getValue最容易的
private operator fun String.getValue(item: Item, property: KProperty<*>)
        = this + "自定义getValue" // == String本身 == "Version1 data"

class Item {
    var version111 : String = "Version1 data"
    var version222 : String by version111
}

fun main() {
    val item = Item()
    println(item.version222)

    println("item.version222:${item.version222}  item.version111:${item.version111}")
    item.version222 = "TTTTTT"
    println("item.version222:${item.version222}  item.version111:${item.version111}")
}