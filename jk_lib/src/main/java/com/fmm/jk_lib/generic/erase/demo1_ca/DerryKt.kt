package generic.erase.demo1_ca

class DerryKt<T> {
    init {
        // val t : T = T()  // 编译过后泛型擦除后的样子 val t: Object = new Object()
    }
}

fun main() {
    val derryJava1 = DerryKt<String>()
}