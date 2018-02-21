package com.company;
import java.text.DecimalFormat;
import java.io.*;

/**
 * Created by Student on 21.02.2018.
 */
public class CalulateFORSimple {



    public static void letSimpCalc(String pathIn, String pathOut)

    {


        try {
            File file = new File(pathIn);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            String lineRPN = line;
            try (FileWriter writer = new FileWriter(pathOut, false)) {
                writer.write("");

                writer.flush();
            }

            while (line != null) {
                RPN lineRpn = new RPN(line);
                double dResult = 0;
                String err = "", result = "";
                try {
                    lineRPN = lineRpn.rpn(); //Приводим строку к виду обратной нотации
                    Simplecalc simpCalc = new Simplecalc(lineRPN);
                    dResult = simpCalc.calculate(); //передаем строку методу из класса Simlecalculate
                    result = Double.toString(dResult);

                } catch (Exception e) {
                    err = e.getMessage();
                }
                try (FileWriter writer = new FileWriter(pathOut, true)) {
                    String text = line + "=" + result ;
                    if (err == "") writer.write(text + "\r\n");

                    writer.write(line + err);
                    writer.flush();
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void letCalc(String pathIn, String pathOut)

    {
        try {
            File file = new File(pathIn);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            String lineRPN = line;
            try (FileWriter writer = new FileWriter(pathOut, false)) {
                writer.write("");

                writer.flush();
            }

            while (line != null) {
                RPN lineRpn = new RPN(line);
                double dResult = 0;
                String err = "", result = "";
                try {
                    lineRPN = lineRpn.rpn(); //Приводим строку к виду обратной нотации
                    Calc simpCalc = new Calc(lineRPN);
                    dResult = simpCalc.calculate(); //передаем строку методу из класса Simlecalculate

                    result = String.format("%.5f", dResult);
                   result.replace(',','.');
                    /*boolean flag=true;
                    for (int i=result.length(); i>result.length()-6;i++){
                        if (result.charAt(i)!=0) flag = false;
                    }
                    if (flag) {
                        String  tmp="";
                        for (int i = 0; i < result.length() - 6; i++) {
                            tmp+=result.charAt(i);
                        }
                        result=tmp;
                    }*/

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                try (FileWriter writer = new FileWriter(pathOut, true)) {
                    String text = line + "=" + result;
                    if (err == "") writer.write(text + "\r\n");
                    writer.write(err);
                    writer.flush();
                    writer.close();

                } catch (Exception e) {
                    e.printStackTrace();
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


