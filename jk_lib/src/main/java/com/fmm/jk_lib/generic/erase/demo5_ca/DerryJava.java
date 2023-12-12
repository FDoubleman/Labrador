package com.fmm.jk_lib.generic.erase.demo5_ca;

import java.util.ArrayList;
import java.util.List;

public class DerryJava {

    // Java ?通配符 ==  KT * 星投影

    public static void main(String[] args) {
        List<?> list1 = new ArrayList<Object>();
        List<?> list2 = new ArrayList<String>();
        List<?> list3 = new ArrayList<Double>();

        List<? extends Object> list1e = new ArrayList<Object>();
        List<? extends Object> list2e = new ArrayList<String>();
        List<? extends Object> list3e = new ArrayList<Double>();
    }

}
