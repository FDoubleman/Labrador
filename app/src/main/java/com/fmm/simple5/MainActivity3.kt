package com.fmm.simple5

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fmm.labrador.R
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty
import kotlin.reflect.jvm.javaField

/*var result : String = "Default"
private operator fun String.provideDelegate(thisRef: MainActivity3?, property: KProperty<*>) =
    object: ReadWriteProperty<MainActivity3?, String> {
        override fun getValue(thisRef: MainActivity3?, property: KProperty<*>): String {
            return this@provideDelegate
        }

        override fun setValue(thisRef: MainActivity3?, property: KProperty<*>, value: String) {
            println("setValue:${property.javaClass} thisRef:$thisRef  ${property}") // thisRef:null
            *//*
            setValue:class kotlin.reflect.jvm.internal.KMutableProperty1Impl
            thisRef:com.derry.asdelegate.simple5.MainActivity3@55b2bc
            var com.derry.asdelegate.simple5.MainActivity3.name2: kotlin.String*//*

            // 在方法里面的成员，永远拿不到 thisRef，所以无法反射

            // 通过Kotlin反射，修改 name2 的值 为 value
            property.javaField?.isAccessible = true
            property.javaField?.set(thisRef, value)
        }
    }*/

// TODO 新增点（同学们，这种方式是可以的）  如果你要用反射的话，推荐以下此方式
private operator fun String.setValue(thisRef: MainActivity3, property: KProperty<*>, value: String) {
    property.javaField?.isAccessible = true
    property.javaField?.set(thisRef, value)
}

private operator fun String.getValue(thisRef: MainActivity3?, property: KProperty<*>)= this
class MainActivity3 : AppCompatActivity() {

    var result : String = "Default"
    operator fun String.provideDelegate(act: MainActivity3?, property: KProperty<*>) =
        object: ReadWriteProperty<MainActivity3?, String> {
            override fun getValue(thisRef: MainActivity3?, property: KProperty<*>): String {
                return this@provideDelegate
            }

            override fun setValue(thisRef: MainActivity3?, property: KProperty<*>, value: String) {
                println("setValue:${property.javaClass} thisRef:$thisRef  ${property.toString()}") // thisRef:null

                // 在方法里面的成员，永远拿不到 thisRef，所以无法反射

                // 通过Kotlin反射，修改 name2 的值 为 value
                /*property.javaField?.isAccessible = true
                property.javaField?.set(thisRef, value)*/
            }
        }

    var name1: String = "is success"
    // var name2 : String by ::name1  // 官方的OK，因为你不在方法里面了，就可以拿到thisRef
    var name2 : String by name1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // 不能在方法里面 ::  , 也不能在方法里面 自定义get set ，因为根本拿不到thisRef
        // var name1: String = "is success"
        // var name2: String by name1   // 我们自定义的委托， thisRef:null
        // var name2 : String by ::name1 // 在方法里面，官方也不支持，因为官方的也拿不到  == thisRef:null

        name2 = "李元霸"

        Toast.makeText(this, "name2:$name2", Toast.LENGTH_SHORT).show()
    }
}