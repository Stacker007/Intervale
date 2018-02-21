package com.company;

import java.io.*;

public class Main {

    private static final String PATHINSIMP = "d:/b/input_1.txt";
    private static final String PATHOUTSIMP = "d:\\b\\output_1.txt";
    private static final String PATHIN = "d:/b/input_2.txt";
    private static final String PATHOUT = "d:\\b\\output_2.txt";

    public static void main(String[] args) throws IOException {

        CalulateFORSimple.letSimpCalc(PATHINSIMP, PATHOUTSIMP);
        CalulateFORSimple.letCalc(PATHIN, PATHOUT);

    }


}
