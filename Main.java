package com.company;

import java.io.*;

public class Main{


    private static final String PATHIN = "D:/Petr/Calc/Tmp/input_1.txt";
  // private static final String PATHOUT = "D:/Petr/Calc/Tmp/output_1.txt";
    //private static InOutOfFile outputRow;*/
    public static void main(String[] args) throws IOException{

        try {
            File file = new File(PATHIN);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            System.out.println(line);

           /* while (line != null) {
                System.out.println(line);
                // считываем остальные строки в цикле


                line = reader.readLine();
            }*/
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* inputRow = new InOutOfFile(PATHIN);
        outputRow = new InOutOfFile(PATHOUT);
        inputRow.read();
        outputRow.write("ghbdtn");

        //System.out.println(inputRow);

*/

    }


 }
