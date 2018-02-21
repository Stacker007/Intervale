package com.company;

import java.io.*;

/**
 * Created by Student on 21.02.2018.
 */
public class CalulateFORSimple  {

    public static void letCalc (String pathIn, String pathOut)

    {
        try {
            File file = new File(pathIn);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);

            String line = reader.readLine();
            String lineRPN = line;
            try(FileWriter writer = new FileWriter(pathOut, false))
            {
                writer.write("");

                writer.flush();
            }

            while (line != null) {
                RPN lineRpn = new RPN(line);
                double dResult = 0;
                String err="", result = "";



                try {
                    lineRPN = lineRpn.rpn(); //Приводим строку к виду обратной нотации
                    Simplecalc simpCalc = new Simplecalc(lineRPN);
                    dResult = simpCalc.calculate(); //передаем строку методу из класса Simlecalculate
                    result = Double.toString(dResult);

                } catch (Exception e) {
                    err = e.getMessage();
                }
                if (err == "") {
                    System.out.println(line + "=" + lineRPN);
                }

                try(FileWriter writer = new FileWriter(pathOut, true))
                {

                    String text = line + "=" + result+"\n";
                    writer.write(text+"\n");



                    writer.flush();
                }
                catch(IOException ex){

                    System.out.println(ex.getMessage());
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

