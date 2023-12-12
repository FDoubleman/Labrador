package com.fmm.jk_lib.generic.erase.demo3_ca;

import java.util.ArrayList;
import java.util.List;

public class DerryJava {

    public static void main(String[] args) {
        List<Integer> p1 = new ArrayList<Integer>();
        List<Double> p2 = new ArrayList<Double>();
        System.out.println(p1.getClass() == p2.getClass()); // ==
        // ArrayList<Integer> class or ArrayList<Double> class 等 都等于 ArrayList class 所以是true
        // ArrayList<T> 最终还是等于 ArrayList class


        /* 泛型擦除后的样子 永远只有 ArrayList.class == ArrayList.class
             List p1 = new ArrayList();
             List p2 = new ArrayList();
         */


    }
}
