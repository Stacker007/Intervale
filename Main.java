package com.company;
/*1. Простой калькулятор с арифметическими операциями +​(сложение),
-​(вычитание), /​(деление), *​(умножение), ^​(возведение в степень), %
(проценты от числа). Пример: 25%10 означает 25 процентов от числа 10.

*/

import com.company.SimpleCalc;
public class Main {

    public static void main(String[] args) {

        float a, b, c;
        SimpleCalc d = new SimpleCalc();
        a=1;
        b=2;
        int e;
        e=1;
        c=d.add(a,b);
        System.out.printf("e"+c);
        

    }
}
