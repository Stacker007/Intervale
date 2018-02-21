package com.company;

/**
 * Класс приведения выражения к виду оратной польской нотации
 *
 * Created by Student on 19.02.2018.
 */


public class RPN {
    private String strInput;
    RPN (String strInput){
        this.strInput=strInput;
    }

    public String rpn() throws Exception{
        StringBuilder operatorStk = new StringBuilder(""); //
        StringBuilder operatorOut = new StringBuilder("");
        char charIn, cTmp;

        for (int i = 0; i < strInput.length(); i++) {
            charIn = strInput.charAt(i);
            if (operator(charIn)) {   //Если символ - оператор
                while (operatorStk.length() > 0) { //если стек не пуст

                    // tmp принимает значение последнего элемента стека операторов
                    cTmp = operatorStk.substring(operatorStk.length()-1).charAt(0);
                    if (operator(cTmp) && (operatorPriority(charIn) <= operatorPriority(cTmp))) {
                        operatorOut.append(" ").append(cTmp).append(" ");

                        operatorStk.setLength(operatorStk.length()-1);
                    } else {
                        operatorOut.append(" ");
                        break;
                    }
                }
                operatorOut.append(" ");
                operatorStk.append(charIn);

            } else if ('(' == charIn) {
                operatorStk.append(charIn);
            } else if (')' == charIn) {
                cTmp = operatorStk.substring(operatorStk.length()-1).charAt(0);
                while ('(' != cTmp) {
                    if (operatorStk.length() < 1) {
                        throw new Exception("Закрывающая скобка без открывающей!");
                    }
                    operatorOut.append(" ").append(cTmp);
                    operatorStk.setLength(operatorStk.length()-1);
                    cTmp = operatorStk.substring(operatorStk.length()-1).charAt(0);
                }
                operatorStk.setLength(operatorStk.length()-1);
            } else {
                // Если символ не оператор - добавляем в выходную последовательность
                operatorOut.append(charIn);
            }
        }

        // Если в стеке остались операторы, добавляем их в входную строку
        while (operatorStk.length() > 0) {
            operatorOut.append(" ").append(operatorStk.substring(operatorStk.length()-1));
            operatorStk.setLength(operatorStk.length()-1);
        }

        return  operatorOut.toString();
    }
    public static boolean operator (char op) {
        switch (op) {
            case '-':
            case '+':
            case '*':
            case '/':
            case '^':
            case '%':

                return true;
        }
        return false;
    }
    private static byte operatorPriority(char op) {
        switch (op) {
            case '^':
                return 3;
            case '*':
            case '/':
            case '%': //процент от числа одного приоритета с * и /

                return 2;
        }
        return 1;
    }

}
