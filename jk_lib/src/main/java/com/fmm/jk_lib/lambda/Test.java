package com.fmm.jk_lib.lambda;

public class Test {

    // val method1 : () -> Unit
    public void method1()                {}

    // val method2 : (Int, Int) -> Unit
    public void method2(int n1, int n2)                {}

    // val method3: (String, Double) -> Any
    public Object method3(String n1, double n2)                {return null;}

    // val method4 : (Int, Double, Long, String) -> Boolean
    public boolean method4(int n1, double n2, long n3, String n4)                {return true;}

    // var method5 : (Int, Int) -> Int
    public int method5(int n1, int n2)                {return 1;}

    // TODO  >>>>>>>>>>>>>>>>>>>>>>>>>>>>> 下面是声明+实现

    // val method01 = { println("我是method01函数") }
    public void method01() {
        System.out.println("我是method01函数");
    }

    // val method02 = { "我是method02函数" }
    public String method02() {
        return "我是method01函数";
    }

    // val method03 = {str: String -> println("你传递进来的值是:$str")}
    public void method03(String str) {
        System.out.println("你传递进来的值是:" + str);
    }

    // val method04 = {number1: Int, number2:Int -> number1.toString() + number2.toString()}
    public String method04(int number1, int number2) {
        return String.valueOf(number1) + String.valueOf(number2);
    }

    // val method05 = {number1: Int, number2:Int -> number1 + number2}
    public int method05(int number1, int number2) {
        return number1 + number2;
    }
}
