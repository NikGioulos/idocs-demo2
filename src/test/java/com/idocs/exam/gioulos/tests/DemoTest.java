package com.idocs.exam.gioulos.tests;

import com.idocs.demo.gioulos.DemoMain;
import com.idocs.demo.gioulos.DemoService;
import com.idocs.demo.gioulos.FileUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class DemoTest {

    private static final String i1 = "C:\\playground\\testIn1_UTF8.txt";
    private static final String i2 = "C:\\playground\\testIn2_UTF8.txt";
    private static final String o = "C:\\playground\\testOu_UTF8.txt";

    @Test
    public void demoMain_Test() throws Exception{
        String[] args = new String[]{i1,i2,o};
        DemoMain.main(args);
    }

    /**
     * this method tests the writeFile and readFile methods
     * @throws Exception
     */
    @Test
    public void readWriteFiles1_Test() throws Exception {

        List<String> expectedLines1 = dummyInput1();

        FileUtils.INSTANCE.writeFile(i1, expectedLines1);

        List<String> actualLines1 = FileUtils.INSTANCE.readFile(i1);

        assertEquals(expectedLines1.size(),actualLines1.size());

        for(int i=0; i<expectedLines1.size();i++){
            assertEquals(expectedLines1.get(i),actualLines1.get(i));
        }
    }

    @Test
    public void readWriteFiles2_Test() throws Exception {

        List<String> expectedLines2 = dummyInput2();

        FileUtils.INSTANCE.writeFile(i2, expectedLines2);

        List<String> actualLines2 = FileUtils.INSTANCE.readFile(i2);

        assertEquals(expectedLines2.size(),actualLines2.size());

        for(int i=0; i<expectedLines2.size();i++){
            assertEquals(expectedLines2.get(i),actualLines2.get(i));
        }
    }

    private List<String> dummyInput1(){
        List<String> expectedLines1 = new ArrayList<>();
        expectedLines1.add("nikos");
        expectedLines1.add("takis");
        expectedLines1.add("kostas");
        expectedLines1.add("savvas");
        expectedLines1.add("mitsos");
        expectedLines1.add("maria");
        expectedLines1.add("mar");
        return expectedLines1;
    }

    private List<String> dummyInput2(){
        List<String> expectedLines2 = new ArrayList<>();
        expectedLines2.add("maria");
        expectedLines2.add("nikos");
        expectedLines2.add("mitsos");
        expectedLines2.add("thanasis");
        expectedLines2.add("alekos");
        expectedLines2.add("anna");
        expectedLines2.add("nikos");
        return expectedLines2;
    }

    /**
     * this methods returns the expected lines in the output
     * the result is based on the lists defined in dummyInput1 & dummyInput2 methods
     * @return
     */
    private List<String> dummyOutput(){
        List<String> expectedLines = new ArrayList<>();
        expectedLines.add("maria");
        expectedLines.add("mitsos");
        expectedLines.add("nikos");
        return expectedLines;
    }

    /**
     * this methods checks if the output file contains the expected lines
     * @throws Exception
     */
    @Test
    public void outputLines_Test() throws Exception {

        List<String> expectedOutput = dummyOutput();

        DemoService service = new DemoService();
        service.doService(i1, i2, o);

        List<String> actualOutput = FileUtils.INSTANCE.readFile(o);

        assertEquals(expectedOutput.size(), actualOutput.size());

        for (int i = 0; i < expectedOutput.size(); i++) {
            assertEquals(expectedOutput.get(i), actualOutput.get(i));
        }
    }

}
