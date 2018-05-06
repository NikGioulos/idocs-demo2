package com.idocs.demo.gioulos;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Singleton Enumeration
  */
public enum FileUtils {

    INSTANCE;

    public List<String> readFile(String filename) throws IOException {
        LogUtils.log("start readFile " + filename);

        List<String> lines = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(filename), StandardCharsets.UTF_8))) {
            String line;
            while((line = br.readLine()) !=null) {
                lines.add(line);
            }
        }
        return lines;
    }

    /**
     * Write to UTF-8 file line by line
     * @param filename
     * @param lines
     * @throws IOException
     */
    public void writeFile(String filename, List<String> lines) throws IOException {
        LogUtils.log("start writeFile " + filename);
        try (PrintWriter printWriter = new PrintWriter(
            new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))){

            //java8 lambda - print each line
            lines.forEach(printWriter::println);

            //always deallocate resources
            printWriter.close();
        }
    }
}

