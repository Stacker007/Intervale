package com.company;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Calc extends Simplecalc {


    Calc(String st) {
        strInput = st;
    }

    public double calculate() throws Exception {
        double a = 0, b = 0;

        Deque<Double> stack = new ArrayDeque<Double>();
        StringTokenizer st = new StringTokenizer(strInput);
        while (st.hasMoreTokens()) {
            justCalc(st, stack, a, b);
        }
        return stack.pop();
    }

}
