package com.fmm.simple2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.fmm.labrador.R
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

// 自定义委托，提供者委托，可以更加直接的写法
operator fun TextView.provideDelegate(value : Any?, property: KProperty<*>) =
    object: ReadWriteProperty<Any?, String?> {
        override fun getValue(thisRef: Any?, property: KProperty<*>): String? = text as String?

        override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
           text = value
        }
    }

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 对控件自定义委托（DataBinding）

        var textView : TextView = findViewById(R.id.tv)

        var message : String? by textView

        textView.text = "Derry修改了布局"

        println("message:$message") // 布局 --> 数据message 一向

        message = "数据发送改变"

        println("textView:${textView.text}") // 数据 --> 布局 一向    = 双向绑定


        // by语法不支持  多个 TextView
        /*var textView2 : TextView = findViewById(R.id.tv)
        var message2 : String? by textView2,textView*/

        println()

        val mainViewModel : MainViewModel by viewModels()
        println(mainViewModel.value)
        mainViewModel.value = "AA"
        println(mainViewModel.value)

        // 官方提供了 viewModels，依赖什么包，用官方的  和用我们自己写的
    }
}

private fun MainActivity.viewModels() : ReadOnlyProperty<MainActivity?, MainViewModel> =
    object : ReadOnlyProperty<MainActivity?, MainViewModel> {
        override fun getValue(thisRef: MainActivity?, property: KProperty<*>): MainViewModel {
            return ViewModelProvider(this@viewModels).get(MainViewModel::class.java)
        }
    }