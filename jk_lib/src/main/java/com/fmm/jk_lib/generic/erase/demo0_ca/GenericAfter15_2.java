package com.fmm.jk_lib.generic.erase.demo0_ca;

import com.fmm.jk_lib.generic.deformation.changed.Animal;

// TODO 模拟 Java 1.5 之后，有泛型上限的时候的代码样子
// 泛型有上限 就用上限Animal
public interface GenericAfter15_2<T extends Animal> {

    T getInfo();

    void setInfo(T info);
}
