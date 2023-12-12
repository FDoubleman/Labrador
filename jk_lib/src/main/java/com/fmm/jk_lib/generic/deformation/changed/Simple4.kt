package generic.deformation.changed

// 如果我们只需要读取泛型数据（生成者），就可以把此泛型声明成协变（? extends T）    Kotlin语言  out T
// 协变（只读模式）
class MyStudentGet<out T>(_item : T) // Kotlin语言才支持 声明处泛型限定   Java语言不支持声明处泛型限定
{
    // 编译器 OK
    private val item = _item
    fun get() : T = item

    // 编译器 不通过报错
    /*fun setXXX1(item : T) {}
    fun setXXX2(item : T) {}
    fun setXXX3(item : T) {}
    fun setXXX4(item : T) {}
    fun setXXX5(item : T) {}*/
    // ...
}

// 如果我们只需要写入泛型数据（消费者），就可以把此泛型声明成逆变（? super T）      Kotlin语言  in  T
// 逆变（修改模式）
class MyStudentSet<in T>() {

    // 编译器 不通过报错
    // fun get() : T             {}

    // 编译器 OK
    fun setXXX1(item : T) {}
    fun setXXX2(item : T) {}
    fun setXXX3(item : T) {}
    fun setXXX4(item : T) {}
    fun setXXX5(item : T) {}
    // ...
}

// 逆变 + 协变
class StudentSetGet<in INPUT, out OUTPUT> {
    private var item : INPUT ? = null

    // 消费者
    fun set(value: INPUT) {
        println("你传递进来的内容是:$value")
        item = value
    }

    // 生产者
    fun get() : OUTPUT ? = item as? OUTPUT // 强转
}

// 不变(不变不就是普通的泛型)
class StudentSetGets<INPUT_OUTPUT> {
    private var item : INPUT_OUTPUT ? = null

    // 消费者
    fun set(value: INPUT_OUTPUT) {
        println("你传递进来的内容是:$value")
        item = value
    }

    // 生产者
    fun get() : INPUT_OUTPUT ? = item
}

fun main() {
    // 生产者 协变 Java ? extends T   或者   KT out T
    val stu : MyStudentGet<String> = MyStudentGet("Derry 这么厉害的人，世界上还有几人")
    println(stu.get())

    // 消费者 逆变  Java ? super T  或者  KT in T
    val stu2 = MyStudentSet<Double>()
    stu2.setXXX1(87876888.6)

    // 消费者 逆变 ? super T 或者 in T           +          生产者 协变  ? extends T  或者 out T
    val stu3 = StudentSetGet<String, String>()
    stu3.set("九阳神功") // 消费者
    println(stu3.get()) // 生产者
}