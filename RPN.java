package com.company;

/**
 * Класс приведения выражения к виду оратной польской нотации
 *
 * Created by Student on 19.02.2018.
 */


public class RPN {

    private static String opn(String strInput) throws Exception{
        StringBuilder rpnSt = new StringBuilder(""); //
        StringBuilder sbOut = new StringBuilder("");
        char symbol, cTmp;

        for (int i = 0; i < strInput.length(); i++) {
            symbol = strInput.charAt(i);
            if (isOp(symbol)) {
                while (rpnSt.length() > 0) {
                    cTmp = rpnSt.substring(rpnSt.length()-1).charAt(0);
                    if (isOp(cTmp) && (opPrior(cIn) <= opPrior(cTmp))) {
                        sbOut.append(" ").append(cTmp).append(" ");
                        rpnSt.setLength(rpnSt.length()-1);
                    } else {
                        sbOut.append(" ");
                        break;
                    }
                }
                sbOut.append(" ");
                rpnSt.append(cIn);
            } else if ('(' == cIn) {
                rpnSt.append(cIn);
            } else if (')' == cIn) {
                cTmp = rpnSt.substring(rpnSt.length()-1).charAt(0);
                while ('(' != cTmp) {
                    if (rpnSt.length() < 1) {
                        throw new Exception("Ошибка разбора скобок. Проверьте правильность выражения.");
                    }
                    sbOut.append(" ").append(cTmp);
                    rpnSt.setLength(rpnSt.length()-1);
                    cTmp = rpnSt.substring(rpnSt.length()-1).charAt(0);
                }
                rpnSt.setLength(rpnSt.length()-1);
            } else {
                // Если символ не оператор - добавляем в выходную последовательность
                sbOut.append(cIn);
            }
        }

        // Если в стеке остались операторы, добавляем их в входную строку
        while (rpnSt.length() > 0) {
            sbOut.append(" ").append(rpnSt.substring(rpnSt.length()-1));
            rpnSt.setLength(rpnSt.length()-1);
        }

        return  sbOut.toString();
    }


}
