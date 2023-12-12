package com.fmm.jk_lib.generic.deformation.changed;

import java.util.ArrayList;
import java.util.List;

public class Simple3 {

    public static void main(String[] args) {
        // new时查看范围 ? extends Animal 【Animal 与 Animal 所有的子类都可以】 上限
        /*List<? extends Animal> list0 = new ArrayList<AnimalFu>(); // 编译不通过 上限已经超过了，所以报错
        List<? extends Animal> list1 = new ArrayList<Animal>();
        List<? extends Animal> list2 = new ArrayList<Person>();
        List<? extends Animal> list3 = new ArrayList<Student>();
        List<? extends Animal> list4 = new ArrayList<SubStudent>();
        List<? extends Animal> list5 = new ArrayList<Dog>(); // 编译不通过 其他的了，所以报错*/

        // new时查看范围 ? extends Animal 【Animal 与 Animal 所有的父类都可以】 下限
        /*List<? super Animal> list0 = new ArrayList<AnimalFu>();
        List<? super Animal> list1 = new ArrayList<Animal>();
        List<? super Animal> list2 = new ArrayList<Person>(); // 编译不通过 下限已经超过了，所以报错
        List<? super Animal> list3 = new ArrayList<Student>(); // 编译不通过 下限已经超过了，所以报错
        List<? super Animal> list4 = new ArrayList<SubStudent>(); // 编译不通过 下限已经超过了，所以报错
        List<? super Animal> list5 = new ArrayList<Dog>(); // 编译不通过 下限已经超过了，所以报错*/

        // new时查看范围 ? super SubStudent 【SubStudent 与 SubStudent 所有的父类都可以】 下限
        /*List<? super SubStudent> list0 = new ArrayList<AnimalFu>();
        List<? super SubStudent> list1 = new ArrayList<Animal>();
        List<? super SubStudent> list2 = new ArrayList<Person>();
        List<? super SubStudent> list3 = new ArrayList<Student>();
        List<? super SubStudent> list4 = new ArrayList<SubStudent>();
        List<? super SubStudent> list5 = new ArrayList<SubSubStudent>(); // 编译不通过 下限已经超过了，所以报错
        List<? super SubStudent> list6 = new ArrayList<Dog>(); // 编译不通过 下限已经超过了，所以报错*/
    }

}
