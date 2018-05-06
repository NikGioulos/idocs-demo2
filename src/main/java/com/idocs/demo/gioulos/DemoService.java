package com.idocs.demo.gioulos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DemoService {

    public void doService(String inputFile1, String inputFile2, String outputFile) throws Exception {

        //load input file 1
        List<String> inputLines1 = FileUtils.INSTANCE.readFile(inputFile1);

        //load input file 2
        List<String> inputLines2 = FileUtils.INSTANCE.readFile(inputFile2);

        //populate the output file content
        List<String> outputLines = process(inputLines1,inputLines2);

        //write content to output file
        FileUtils.INSTANCE.writeFile(outputFile,outputLines);
    }

    /**
     * this method accepts two lists with String and creates a new list (avoiding duplicates)
     * containing the intersection of two list, lexicographily sorted avoiding duplicates
     * @param inputLines1
     * @param inputLines2
     * @return
     */
    private static List<String> process(List<String> inputLines1, List<String> inputLines2) {
        LogUtils.log("start process");
        //find the list with the less elements
        List<String> shorterList;
        List<String> largerList;
        if(inputLines1.size()>inputLines2.size()){
            shorterList = inputLines2;
            largerList = inputLines1;
        }else{
            shorterList = inputLines1;
            largerList = inputLines2;
        }

        //sort shorter list for better performance
        Collections.sort(shorterList, new LexicComparator());

        //create the list for the output file
        List<String> outputLines = new ArrayList<>();

        //keep the last processed line in order to avoid the scanning of duplicates
        String savedLine = "";

        //loop in shorter list for performance
        for(String line:shorterList){

            //if this line found for first time
            if(!savedLine.equalsIgnoreCase(line)){

                //save this new line
                savedLine = line;

                //if this line found in both input lists
                if(largerList.contains(line)){

                    //add the line to the output file lines
                    outputLines.add(line);

                }
            }
        }

        return outputLines;
    }
}
