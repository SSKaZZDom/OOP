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
 *        5       |  Княжна Марья  |war and peace|
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
        List<Long> expect = new ArrayList<>();
        expect.add(2500L);
        expect.add(5000L);
        expect.add(2576000L);
        String sub = "haha";
        InputStream stream = getClass().getClassLoader().getResourceAsStream("giant.txt");
        List<Long> result = null;
        try {
            result = new ArrayList<>(allEntries(stream, sub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(expect, result);
    }

    @Test
    public void testWarAndPeace() {
        List<Long> expect = new ArrayList<>();
        expect.add(370790L);
        expect.add(412230L);
        expect.add(413628L);
        expect.add(414588L);
        expect.add(420216L);
        expect.add(426714L);
        expect.add(427271L);
        expect.add(446609L);
        expect.add(453508L);
        expect.add(455670L);
        expect.add(468634L);
        expect.add(937899L);
        expect.add(941243L);
        expect.add(949083L);
        expect.add(953382L);
        expect.add(972644L);
        expect.add(978073L);
        expect.add(987682L);
        expect.add(994130L);
        expect.add(995022L);
        expect.add(1395382L);
        expect.add(1395563L);
        expect.add(1395756L);
        expect.add(1400396L);
        expect.add(1400812L);
        expect.add(1402924L);
        expect.add(1403774L);
        expect.add(1408331L);
        expect.add(1410136L);
        expect.add(1413885L);
        expect.add(1415282L);
        expect.add(1416029L);
        expect.add(1610271L);
        expect.add(1619710L);
        expect.add(1622291L);
        expect.add(1649255L);
        expect.add(1711301L);
        expect.add(1714716L);
        expect.add(1723220L);
        expect.add(1857495L);
        expect.add(2141257L);
        expect.add(2378071L);
        expect.add(2383275L);
        expect.add(2383567L);
        expect.add(2385388L);
        expect.add(2388479L);
        expect.add(2394740L);
        expect.add(2402455L);
        expect.add(2406267L);
        expect.add(2406893L);
        expect.add(2412675L);
        expect.add(2414517L);
        expect.add(2415003L);
        expect.add(2415339L);
        expect.add(2446993L);
        expect.add(2447810L);
        expect.add(2450830L);
        expect.add(2453832L);
        expect.add(2538025L);
        expect.add(2538924L);
        expect.add(2626560L);
        expect.add(2627549L);
        expect.add(2635902L);
        String sub = "Княжна Марья";
        InputStream stream = getClass().getClassLoader().getResourceAsStream("war_and_peace.txt");
        List<Long> result = null;
        try {
            result = new ArrayList<>(allEntries(stream, sub));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertEquals(expect, result);
    }
}
