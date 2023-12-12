package com.fmm.jk_lib.generic.erase.demo1_ca;

// C# 等其他语言是真正的泛型， Java的泛型是伪泛型，因为Java1.5后 才增加泛型，但是又要考虑兼容之前的版本，所以就做了泛型擦除，来兼容之前的版本


class Derry {
    public Derry(String name) {}
}

public class DerryJava<T> {

    DerryJava() {
        // T t = new T(); // 编译过后泛型擦除后的样子 Object t = new Object();  Object()我怎么知道你有么有参数
    }

    public static void main(String[] args) {
        DerryJava<String> derryJava1 = new DerryJava<String>();

        DerryJava<Derry> derryJava2 = new DerryJava<Derry>();

        // 编译过后泛型擦除后的样子
        DerryJava derryJava3 = new DerryJava();
    }
}
