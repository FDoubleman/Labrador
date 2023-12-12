package com.fmm.jk_lib.generic.erase.demo0_ca;

// TODO 模拟 Java 1.5 之后，有泛型的时候的代码样子
// 泛型没有任何上限 就是 默认 Object
public interface GenericAfter15<T> {

    T getInfo();

    void setInfo(T info);
}
