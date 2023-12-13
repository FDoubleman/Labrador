package com.fmm.jk_lib.generic.erase.demo6_ca;

import com.fmm.jk_lib.generic.deformation.changed.Animal;
import com.fmm.jk_lib.generic.deformation.changed.Person;
import com.fmm.jk_lib.generic.deformation.changed.Student;
import com.fmm.jk_lib.generic.deformation.changed.SubSubStudent;



import java.util.ArrayList;

// TODO 模拟 Java 1.5 之后，有泛型上限的时候的代码样子
public class GenericAfter15_3 {

    // Java JDK 1.0 就是没有泛型的
    public static void derry(Object[] objects) { }

    public static void derry(Animal[] objects) { }
    public static void derry(Person[] objects) { }
    public static void derry(Student[] objects) { }
    public static void derry(SubSubStudent[] objects) { }
    // ...

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<Student>();
        // Student result = list.get(0);

        // 泛型编译成功后 会擦除后的样子
        ArrayList list2 = new ArrayList();
        // Student result2 = (Student) list2.get(0);
        // 为什么他知道，要强转成String呢，不是说被擦除了么，因为

        // signature Ljava/util/ArrayList<Lgeneric/deformation/changed/Student;>;
        // 对于为了在1.5以上支持泛型的JDK版本中，  泛型擦除 擦了 等于没有擦
        // 对于为了在1.5以下不支持泛型的JDK版本中， 泛型擦除 擦了 等于擦了

        // if (obj instanceof List) {} OK
        // if (obj instanceof List<String>) {} 编译不通过

        // List<int> listList = new ArrayList<int>(); 编译不通过

        // new T 方法擦除

        // 数组泛型 缔造者 脑洞打开，做了一件愚蠢的事情  对数组泛型默认开启协变
        Person[] p = new Person[10];
        p[0] = new Person(); // 对数组泛型默认开启协变(Person与Person的子类才可以)
        p[1] = new Student();
        p[2] = new SubSubStudent();
        // p[3] = new Dog();

        // 大厂面试题，是否了解 数组泛型默认开启 协变带来的问题
        String[] str1 = new String[2];
        Object[] str2 = str1; // 对数组泛型默认开启协变  [如果你不默认开协变，就没有这个问题]
        str1[0] = "Derry";
        str2[1] = Integer.valueOf(767); // 欺骗了编译期 绕过去了而已

        // Integer的父类是不是String  1是   2不是
    }

}
