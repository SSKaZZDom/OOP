package count.substring;

import static count.substring.SearchSubstring.allEntries;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;



/**
 * Some tests for the correctness of my realisation of KMP algorithm.
 * Number of test |    Substring   |   String    |
 * ---------------|----------------|-------------|
 *        1       |       pie      |   pppppie   |
 *        2       |       pie      | pie piepie  |
 *        3       |      pppie     |   pppppie   |
 *        4       |      haha      | *Huge Test* |
 *        5       |  Княжна Марья  |war and peace|
 */
public class SubstringTests {
/*    @Test
    public void testUnitSearch() throws IOException {
        String sub = "pie";
        List<Long> expect = new ArrayList<>();
        expect.add(4L);
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("input1.txt")) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub));
            Assertions.assertEquals(result, expect);
        }
    }

    @Test
    public void testSetOfIndexes() throws IOException {
        String sub = "pie";
        List<Long> expect = new ArrayList<>();
        expect.add(0L);
        expect.add(4L);
        expect.add(7L);
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("input2.txt")) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub));
            Assertions.assertEquals(expect, result);
        }
    }

    @Test
    public void testCorruptMyAlg() throws IOException {
        String sub = "pppie";
        List<Long> expect = new ArrayList<>();
        expect.add(2L);
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("input1.txt")) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub));
            Assertions.assertEquals(expect, result);
        }
    }

    @Test
    public void testHugeFile() throws IOException {
        List<Long> expect = new ArrayList<>();
        expect.add(2500L);
        expect.add(5000L);
        expect.add(2576000L);
        String sub = "haha";
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("giant.txt")) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub));
            Assertions.assertEquals(expect, result);
        }
    }
*/
    @Test
    public void testEasyRussian() throws IOException {
        List<Long> expect = new ArrayList<>();
        expect.add(4L);
        expect.add(10L);
        String sub = "";
        int sym = 0;
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("russianSub.txt")) {
            try (Reader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                try (Reader reader = new BufferedReader(streamReader)) {
                    sym = reader.read();
                    while (sym != -1) {
                        sub += (char) sym;
                        sym = reader.read();
                    }
                }
            }
        }
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("russian.txt")) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub));
            Assertions.assertEquals(expect, result);
        }
    }

    @Test
    public void testWarAndPeace() throws IOException {
        List<Long> expect = new ArrayList<>();
        expect.add(211729L);
        expect.add(240167L);
        expect.add(240951L);
        expect.add(241532L);
        expect.add(244655L);
        expect.add(248284L);
        expect.add(248605L);
        expect.add(259642L);
        expect.add(263578L);
        expect.add(264793L);
        expect.add(272242L);
        expect.add(535375L);
        expect.add(537354L);
        expect.add(542011L);
        expect.add(544423L);
        expect.add(555249L);
        expect.add(558358L);
        expect.add(563895L);
        expect.add(567545L);
        expect.add(568056L);
        expect.add(791479L);
        expect.add(791578L);
        expect.add(791686L);
        expect.add(794297L);
        expect.add(794528L);
        expect.add(795699L);
        expect.add(796175L);
        expect.add(798817L);
        expect.add(799813L);
        expect.add(801893L);
        expect.add(802664L);
        expect.add(803080L);
        expect.add(912071L);
        expect.add(917309L);
        expect.add(918741L);
        expect.add(936631L);
        expect.add(971195L);
        expect.add(973262L);
        expect.add(978032L);
        expect.add(1052802L);
        expect.add(1210934L);
        expect.add(1342648L);
        expect.add(1345561L);
        expect.add(1345728L);
        expect.add(1346750L);
        expect.add(1348505L);
        expect.add(1352040L);
        expect.add(1356372L);
        expect.add(1358491L);
        expect.add(1358840L);
        expect.add(1362153L);
        expect.add(1363179L);
        expect.add(1363449L);
        expect.add(1363638L);
        expect.add(1381586L);
        expect.add(1382039L);
        expect.add(1383715L);
        expect.add(1385386L);
        expect.add(1432740L);
        expect.add(1433239L);
        expect.add(1482265L);
        expect.add(1482817L);
        expect.add(1487467L);
        int sym;
        String sub = "";
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("warSub.txt")) {
            try (Reader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8)) {
                try (Reader reader = new BufferedReader(streamReader)) {
                    sym = reader.read();
                    while (sym != -1) {
                        sub += (char) sym;
                        sym = reader.read();
                    }
                }
            }
        }
        String n = "war_and_peace.txt"; // need only for reviewdog
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(n)) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub));
            //Assertions.assertEquals(expect, result);
            for (int i = 0; i < result.size(); i++){
                System.out.println(result.get(i));
            }
        }
    }
}
