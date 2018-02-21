package com.company;

import java.io.*;

public class Main{


    private static final String PATHIN = "D:/Petr/Calc/Tmp/input_1.txt";
    // private static final String PATHOUT = "D:/Petr/Calc/Tmp/output_1.txt";

    public static void main(String[] args) throws IOException{

        try {
            File file = new File(PATHIN);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            String lineRPN = line;
            while (line != null){
            RPN lineRpn = new RPN(line);
            double dResult=0;

            try {
                lineRPN = lineRpn.rpn(); //Приводим строку к виду обратной нотации
                System.out.print(lineRPN);
                System.out.print("::"+line);
                Simplecalc simpCalc = new Simplecalc(lineRPN);
                dResult = simpCalc.calculate(); //передаем строку методу из класса Simlecalculate

                System.out.println("="+dResult);


            } catch (Exception e){
                System.out.println(e.getMessage());
            }
                try {

                    System.out.print(lineRPN);
                    System.out.print("::"+line);
                    Calc newCalc = new Calc(lineRPN);
                    dResult = newCalc.calculate(); //передаем строку методу из класса Simlecalculate

                    System.out.println("="+dResult);


                } catch (Exception e){
                    System.out.println(e.getMessage());
                }





                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }


}
