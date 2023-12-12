package com.fmm.jk_lib.generic.deformation.changed;

import java.util.ArrayList;
import java.util.List;

import generic.deformation.changed.Animal;
import generic.deformation.changed.AnimalFu;
import generic.deformation.changed.Person;
import generic.deformation.changed.Student;
import generic.deformation.changed.SubStudent;
import generic.deformation.changed.SubSubStudent;

public class Simple5 {

    // TODO 只读模式 & 生产者  & 协变
    public void readModel(List<? extends Animal> list) {
        // TODO readModel方法目标 ： 把list集合插入数据库

        // 不能修改
        /*list.add(new Person()); // 编译不通过（有内鬼默默的修改这个值，都不准）
        list.set(0, new Student()); // 编译不通过（有内鬼默默的修改这个值，都不准）
        list.add(new SubStudent()); // 编译不通过（有内鬼默默的修改这个值，都不准）
        list.add(new SubSubStudent()); // 编译不通过（有内鬼默默的修改这个值，都不准）*/

        // 只能读取
        // 只能安心把用户的原始数据 存入数据啦
        for (Animal animal : list) {
            // ...
        }
    }

    // TODO 修改模式 & 消费者 & 逆变
    public void updateModel(List<? super Animal> list) {
        // 能修改（list.add 这里面而已，Animal 与 Animal的子类才可以存入） 细节点
        // 特殊情况了，不需要知道 list.add(new AnimalFu());
        // list.add(new AnimalFu()); 报错，因为 Animal 与 Animal的子类才可以存入
        list.add(new Animal());
        list.add(new Person());
        list.add(new Student());
        list.add(new SubStudent());
        list.add(new SubSubStudent());

        // 不能读取
        // 不只能安心把用户的原始数据 存入数据啦
        /*for (Animal animal : list) {
            // ...
        }*/
    }


    // 用户
    public static void main(String[] args) {
        Simple5 simple5 = new Simple5();

        /*// TODO 只读模式 & 生产者
        // simple5.readModel(new ArrayList<AnimalFu>()); // 编译不通过
        simple5.readModel(new ArrayList<Animal>());
        simple5.readModel(new ArrayList<Person>());
        simple5.readModel(new ArrayList<Student>());
        simple5.readModel(new ArrayList<SubStudent>());
        simple5.readModel(new ArrayList<SubSubStudent>());
        // simple5.readModel(new ArrayList<Dog>()); // 编译不通过
        // ArrayList源码 178行 因为存入元素原始即可 谁都不能修改 用户的数据*/

        // TODO 修改模式 & 消费者 & 逆变
        simple5.updateModel(new ArrayList<Object>());
        simple5.updateModel(new ArrayList<AnimalFu>());
        simple5.updateModel(new ArrayList<Animal>());
        /*simple5.updateModel(new ArrayList<Person>()); // 编译不通过
        simple5.updateModel(new ArrayList<Student>()); // 编译不通过
        simple5.updateModel(new ArrayList<SubStudent>()); // 编译不通过
        simple5.updateModel(new ArrayList<SubSubStudent>()); // 编译不通过*/
        // simple5.readModel(new ArrayList<Dog>()); // 编译不通过
        // ArrayList源码 1534行 forEach 因为修改元素后 处理元素 检查元素...   再再for打印
    }

}
