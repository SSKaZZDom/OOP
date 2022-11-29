package count.substring;

import static count.substring.SearchSubstring.allEntries;

import java.io.IOException;
import java.io.InputStream;
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
 */
public class SubstringTests {
    @Test
    public void testUnitSearch() {
        String sub = "pie";
        List<Long> expect = new ArrayList<>();
        expect.add(4L);
        List<Long> result = new ArrayList<>();
        InputStream stream = getClass().getClassLoader().getResourceAsStream("input1.txt");
        try {
            result.addAll(allEntries(stream, sub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(result, expect);
    }

    @Test
    public void testSetOfIndexes() {
        String sub = "pie";
        List<Long> expect = new ArrayList<>();
        expect.add(0L);
        expect.add(4L);
        expect.add(7L);
        InputStream stream = getClass().getClassLoader().getResourceAsStream("input2.txt");
        List<Long> result = null;
        try {
            result = new ArrayList<>(allEntries(stream, sub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void testCorruptMyAlg() {
        String sub = "pppie";
        List<Long> expect = new ArrayList<>();
        expect.add(2L);
        InputStream stream = getClass().getClassLoader().getResourceAsStream("input1.txt");
        List<Long> result = null;
        try {
            result = new ArrayList<>(allEntries(stream, sub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void testHugeFile() {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("giant.txt");
        List<Long> expect = new ArrayList<>();
        expect.add(2500L);
        expect.add(5000L);
        expect.add(2576000L);
        String sub = "haha";
        List<Long> result = null;
        try {
            result = new ArrayList<>(allEntries(stream, sub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(expect, result);
    }
}
