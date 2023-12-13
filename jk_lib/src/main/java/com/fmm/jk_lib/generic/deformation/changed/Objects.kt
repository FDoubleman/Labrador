package com.fmm.jk_lib.generic.deformation.changed

open class AnimalFu // 顶层父类

open class Animal : AnimalFu() // 父类
open class Person : Animal() // 子类
open class Student : Person() // 子类的子类
open class SubStudent : Student() // 子类的子类的子类

class SubSubStudent : SubStudent() // 子类的子类的子类的子类

open class Dog // 不参与继承关系的其他类