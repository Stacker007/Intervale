package com.company;
/*1. Простой калькулятор с арифметическими операциями +​(сложение),
-​(вычитание), /​(деление), *​(умножение), ^​(возведение в степень), %
(проценты от числа). Пример: 25%10 означает 25 процентов от числа 10.
*/
public class SimpleCalc {

    float add(float a, float b){
        return a+b;
    }
    float sub(float a, float b){
        return a-b;
    }
    float mul(float a, float b){
        return a*b;
    }
    float div(float a, float b){
        return a/b;
    }
    float pow(float a, int b){
        for (int i=0; i<b; i++) a*=a;
        return a;
    }
    float percent(float a, float b){
        return a*b/100;
    }

}
