package com.company;
import java.util.*;
class Simplecalc {
    String strInput;

    Simplecalc() {
        strInput = "";
    }

    Simplecalc(String stInput) {
        strInput = stInput;
    }


    public double calculate() throws Exception {
        double a = 0, b = 0;

        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(strInput);
        for (int i = 0; i < 3; i++) { //В этом классе используются только три лексемы (2 операнда и 1 оператор)
            justCalc(st, stack, a, b);
        }
        if (st.hasMoreTokens()) {
            throw new Exception(": Этот тип калькулятора обрабатывает только простые выражения");
        }

        return stack.pop();
    }

    public static void justCalc(StringTokenizer st, Deque<Double> stack, double a, double b) throws Exception {
        String lexemTmp;
        boolean err = false;
        try {
            lexemTmp = st.nextToken().trim();
            if (1 == lexemTmp.length() && RPN.operator(lexemTmp.charAt(0))) { //
                if (stack.size() < 2) {
                    throw new Exception("Количество данных неверно " + lexemTmp);
                }
                b = stack.pop();
                a = stack.pop();

                switch (lexemTmp.charAt(0)) {
                    case '+':
                        a += b;
                        break;
                    case '-':
                        a -= b;
                        break;
                    case '/':
                        a /= b;
                        if (b == 0) throw new Exception();
                        break;
                    case '*':
                        a *= b;
                        break;
                    case '%':
                        a = a * b / 100;

                        break;
                    case '^':
                        a = Math.pow(a, b);
                        break;


                }
                stack.push(a); // возврат в стек результата вычисления
            } else {
                a = Double.parseDouble(lexemTmp);
                stack.push(a);
            }
        } catch (Exception e) {
            throw new Exception("На ноль делить нельзя\r\n");
        }

    }

}
