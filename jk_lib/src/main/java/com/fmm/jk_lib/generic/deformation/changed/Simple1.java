package com.fmm.jk_lib.generic.deformation.changed;

import java.util.ArrayList;
import java.util.List;

import generic.deformation.changed.Person;
import generic.deformation.changed.Student;
import generic.deformation.changed.SubStudent;

public class Simple1 {

    public static void main1(String[] args) {
        /* TODO
            协变
            List<Person> list1; 此list1能够存放Person的子类类型数据 【我们的认为】
            List<SubStudent> list2; 此list2能够存放SubStudent类型数据
        */

        List<Person> list1;

        List<SubStudent> list2 = new ArrayList<SubStudent>();

        // list1 = list2 // 编译不允许： list1的泛型定义处 与 list2的泛型具体处 不匹配， 因为（List<SubStudent> 并不是 List<Person>的子类）

        // list1 = list2; // 假设是可以的，会有什么问题？
        // list1.add(new Student()); // 我存入进去的是 Student类型
        // SubStudent result = list2.get(0); // 我取出来的是SubStudent类型（会出现类型转换异常，这个设计是不合理的） 乱套了 管理混乱

        // Java语言设计时，为了解决以上 转换异常，就出现了通配符  出现上限通配符
        List<? extends Person> lists1; // 这个是可以存放，List<Person>，List<Person的子类>
        List<SubStudent> lists2 = new ArrayList<SubStudent>();
        List<Student> lists3 = new ArrayList<Student>();
        lists1 = lists2;
        lists1 = lists3;

    }

    interface Collection1<E> { // 声明处泛型
        void addAll(Collection1<E> items);
    }

    void copyAll(Collection1<Object> to, Collection1<String> from) { // 使用处泛型
        // to = from; // 编译不允许，to的泛型定义出 与 from的泛型具体处 不匹配， 因为（Collection<String> 并不是 Collection<Object>的子类）
    }

    void copyAll0(Collection1<? extends Object> to, Collection1<String> from) { // 使用处泛型
        to = from; // 编译OK
    }

    // TODO 真实的源码要这样设计：
    interface MyCollection<E> { // 声明处泛型
        void addAll(MyCollection<? extends E> elements); // 接收E类型 例如:E类型是Object，可以接收Object与Object的所有子类
    }
    void copyAll1(MyCollection<? extends Object> to, MyCollection<String> from) { // 使用处泛型
        to = from; // 编译OK
    }
    void copyAll2(MyCollection<Object> to, MyCollection<String> from) { // 使用处泛型
        to.addAll(from); // 编译OK
    }

    // TODO >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public static void main(String[] args) {
        /* TODO
            逆变
            List<Person> list1; 此list1能够存放Person的子类类型数据
            List<SubStudent> list2; 此list2能够存放SubStudent类型数据
            但是不能把 list1 赋值给 list2 因为他们是不支持的
         */
        List<Person> list1 = new ArrayList<>();
        // List<Student> list2 = list1; // 编译不允许：list2的泛型定义处 与 list1的泛型具体处 不匹配
        List<? super SubStudent> list2 = new ArrayList<>();
        list2 = list1;
    }
}

// 总结：
// 如果我们只需要读取泛型数据（生成者），就可以把此泛型声明成协变 Java语言（? extends T）  Kotlin语言 out T
// 如果我们只需要写入泛型数据（消费者），就可以把此泛型声明成逆变 Java语言（? super T）      Kotlin语言  in T
