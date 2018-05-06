package com.idocs.demo.gioulos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoMain {

    public static void main(String... args) throws Exception{

        if(args.length<3){
            throw new Exception(
                    "Please provide 3 input parameters. 2 Input files and 1 output file");
        }

        String inputFile1 = args[0];
        String inputFile2 = args[1];
        String outputFile = args[2];

        DemoService service = new DemoService();
        service.doService(inputFile1, inputFile2, outputFile);
    }
}
