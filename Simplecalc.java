package com.company;
import java.util.*;
public class Simplecalc {
    private String strInput;
    Simplecalc (String strInput){
        this.strInput=strInput;    }


    public double calculate() throws Exception {
        double a = 0, b = 0;
        String lexemTmp;
        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(strInput);
        while (st.hasMoreTokens()){ //В этом классе используются только три лексемы (2 операнда и 1 оператор)
            try {
                lexemTmp = st.nextToken().trim();
                if (1 == lexemTmp.length() && operator(lexemTmp.charAt(0))) { //
                    if (stack.size() != 2 ) {
                        throw new Exception("Количество данных неверно " + lexemTmp);
                    }
                    b = stack.pop();
                    a = stack.pop();
                    switch (lexemTmp.charAt(0)) {
                        case '+': a += b; break;
                        case '-': a -= b; break;
                        case '/': a /= b; break;
                        case '*': a *= b; break;
                        case '%': a = a*b/100; break;
                        case '^': a = Math.pow(a, b); break;
                        default:
                            throw new Exception("Операция не обрабатывается этим типом калькулятора " + lexemTmp);
                    }
                    stack.push(a); // возврат в стек результата вычисления
                } else {
                    a = Double.parseDouble(lexemTmp);
                    stack.push(a);
                }
            } catch (Exception e) {
                throw new Exception("Недопустимый символ в выражении");
            }
        }

        if (stack.size() > 1) {
            throw new Exception("Количество операторов не соответствует количеству операндов");
        }

        return stack.pop();
    }
    private static boolean operator (char op) {
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
}
