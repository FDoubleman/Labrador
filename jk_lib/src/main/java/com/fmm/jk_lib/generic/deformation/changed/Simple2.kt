package generic.deformation.changed

class Type<T>

fun main() {
    /* TODO
        协变
        List<Person> list1; 此list1能够存放任意类型数据
        List<SubStudent> list2; 此list2能够存放SubStudent类型数据
        但是不能把 list2 赋值给 list1 因为他们是不支持的
     */
    // new时查看范围 ? extends Animal 【Animal 与 Animal 所有的子类都可以】 上限
    /*val list0: Type<out Animal> = Type<AnimalFu>()  // 编译不通过 上限已经超过了，所以报错
    val list2: Type<out Animal> = Type<Student>()
    val list3: Type<out Animal> = Type<SubStudent>()
    val list4: Type<out Animal> = Type<SubSubStudent>()
    val list5: Type<out Animal> = Type<Dog>()  // 编译不通过 其他的了，所以报错*/

    /* TODO
          逆变
          List<Person> list1; 此list1能够存放任意类型数据
          List<SubStudent> list2; 此list2能够存放SubStudent类型数据
          但是不能把 list1 赋值给 list2 因为他们是不支持的
       */
    // new时查看范围 ? super Animal 【Animal 与 Animal 所有的父类都可以】 下限
    /*val list6s : Type<in Animal> = Type<Any>()
    val list6 : Type<in Animal> = Type<AnimalFu>()
    val list8 : Type<in Animal> = Type<Person>() // 编译不通过 下限已经超过了，所以报错
    val list9 : Type<in Animal> = Type<Student>() // 编译不通过 下限已经超过了，所以报错
    val list10 : Type<in Animal> = Type<SubStudent>() // 编译不通过 下限已经超过了，所以报错
    val list11 : Type<in Animal> = Type<Dog>() // 编译不通过 下限已经超过了，所以报错*/

    // new时查看范围 ? super SubStudent 【SubStudent 与 SubStudent 所有的父类都可以】 下限
    /*val list6 : Type<in SubStudent> = Type<AnimalFu>()
    val list7 : Type<in SubStudent> = Type<Animal>()
    val list8 : Type<in SubStudent> = Type<Person>()
    val list9 : Type<in SubStudent> = Type<Student>()
    val list10 : Type<in SubStudent> = Type<SubStudent>()
    val list11 : Type<in SubStudent> = Type<SubSubStudent>() // 编译不通过 下限已经超过了，所以报错
    val list12 : Type<in SubStudent> = Type<Dog>() // 编译不通过 下限已经超过了，所以报错*/
}