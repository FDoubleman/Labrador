package com.fmm.simple3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.fmm.labrador.R

import kotlin.concurrent.thread
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

operator fun TextView.provideDelegate(value: Any?, property:KProperty<*>) =
    object: ReadWriteProperty<Any?, String?> {
    override fun getValue(thisRef: Any?, property: KProperty<*>): String? = text as String?

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: String?) {
       text = value
    }
}

class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val tv1_state = findViewById<TextView>(R.id.tv1_state)
        val tv10_state = findViewById<TextView>(R.id.tv10_state)
        val tv21_state = findViewById<TextView>(R.id.tv21_state)


        val bt1_do = findViewById<TextView>(R.id.bt1_do)
        val bt10_do = findViewById<TextView>(R.id.bt10_do)
        val bt21_do = findViewById<TextView>(R.id.bt21_do)



        var stateFlag1 : String? by tv1_state
        var stateFlag10: String ? by tv10_state
        var stateFlag21 : String ? by tv21_state

        // 按钮1 的点击事件
        bt1_do.setOnClickListener {
            thread {
                runOnUiThread {
                    stateFlag1 = "正在赶往1楼的过程中..."
                    stateFlag10 = stateFlag1
                    stateFlag21 = stateFlag10
                }

                Thread.sleep(10000L)

                runOnUiThread {
                    stateFlag1 = "恭喜你，1楼到了"
                    stateFlag10 = stateFlag1
                    stateFlag21 = stateFlag10
                }
            }
        }

        // 按钮10 的点击事件
        bt10_do.setOnClickListener {
            thread {
                runOnUiThread {
                    stateFlag10 = "正在赶往10楼的过程中..."
                    stateFlag1 = stateFlag10
                    stateFlag21 = stateFlag1
                }

                Thread.sleep(10000L)

                runOnUiThread {
                    stateFlag10 = "恭喜你，10楼到了"
                    stateFlag1 = stateFlag10
                    stateFlag21 = stateFlag1
                }
            }
        }

        // 按钮21 的点击事件
        bt21_do.setOnClickListener {
            thread {
                runOnUiThread {
                    stateFlag21 = "正在赶往21楼的过程中..."
                    stateFlag1 = stateFlag21
                    stateFlag10 = stateFlag1
                }

                Thread.sleep(10000L)

                runOnUiThread {
                    stateFlag21 = "恭喜你，21楼到了"
                    stateFlag1 = stateFlag21
                    stateFlag10 = stateFlag1
                }
            }
        }
    }

}