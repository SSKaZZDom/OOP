package count.substring;

import static count.substring.SearchSubstring.allEntries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
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
 *        5       |      пирог     |  пир-пирог  |
 *        6       |  Княжна Марья  |war and peace|
 */
public class SubstringTests {
    @Test
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

    @Test
    public void testEasyRussian() throws IOException {
        List<Long> expect = new ArrayList<>();
        expect.add(4L);
        StringBuilder sub = new StringBuilder();
        int sym = 0;
        String n = "russianSub.txt"; //need only for reviewdog
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(n);
             Reader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             Reader reader = new BufferedReader(streamReader)) {
            sym = reader.read();
            while (sym != -1) {
                sub.append((char) sym);
                sym = reader.read();
            }
        }
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("russian.txt")) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub.toString()));
            Assertions.assertEquals(expect, result);
        }
    }

    @Test
    public void testWarAndPeace() throws IOException {
        List<Long> expect = new ArrayList<>();
        expect.add(211729L);
        int sym;
        StringBuilder sub = new StringBuilder();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("warSub.txt");
             Reader streamReader = new InputStreamReader(stream, StandardCharsets.UTF_8);
             Reader reader = new BufferedReader(streamReader)) {
            sym = reader.read();
            while (sym != -1) {
                sub.append((char) sym);
                sym = reader.read();
            }
        }
        String n = "war_and_peace.txt";
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream(n)) {
            List<Long> result = new ArrayList<>(allEntries(stream, sub.toString()));
            Assertions.assertEquals(expect, result);
        }
    }
}
