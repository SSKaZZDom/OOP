package primenumbers;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Tests for my methods.
 * 2 tests without concurrency
 * 7 tests with different count of threads
 * 1 test with parallelStream
 * Each test has a print of operating time
 */
public class PrimeTests {
    @Test
    public void testNotConcurrencyFalse() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindPrime fp = new FindPrime(test);
            Assertions.assertTrue(fp.hasNonPrime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testNotConcurrencyTrue() {
        test(1);
        test(1);
        test(1);
    }

    @Test
    public void testTwoThreads() {
        test(2);
        test(2);
        test(2);
    }

    @Test
    public void testThreeThreads() {
        test(3);
        test(3);
        test(3);
    }

    @Test
    public void testFourThreads() {
        test(4);
        test(4);
        test(4);
    }

    @Test
    public void testFiveThreads() {
        test(5);
        test(5);
        test(5);
    }

    @Test
    public void testSixThreads() {
        test(6);
        test(6);
        test(6);
    }

    @Test
    public void testSevenThreads() {
        test(7);
        test(7);
        test(7);
    }

    @Test
    public void testEightThreads() {
        test(8);
        test(8);
        test(8);
    }

    @Test
    public void testTenThreads() {
        test(10);
        test(10);
        test(10);
    }

    @Test
    public void testTwelveThreads() {
        test(12);
        test(12);
        test(12);
    }

    @Test
    public void testFourteenThreads() {
        test(14);
        test(14);
        test(14);
    }

    @Test
    public void testSixteenThreads() {
        test(16);
        test(16);
        test(16);
    }

    @Test
    public void testTwentyThreads() {
        test(20);
        test(20);
        test(20);
    }

    @Test
    public void testTwentyFourThreads() {
        test(24);
        test(24);
        test(24);
    }

    @Test
    public void testThirtyTwoThreads() {
        test(32);
        test(32);
        test(32);
    }

    @Test
    public void testParallelStream() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            long start = System.nanoTime();
            Assertions.assertFalse(test.parallelStream().anyMatch(FindPrime::isNotPrime));
            System.out.println(System.nanoTime() - start + " p");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            long start = System.nanoTime();
            Assertions.assertFalse(test.parallelStream().anyMatch(FindPrime::isNotPrime));
            System.out.println(System.nanoTime() - start + " p");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            long start = System.nanoTime();
            Assertions.assertFalse(test.parallelStream().anyMatch(FindPrime::isNotPrime));
            System.out.println(System.nanoTime() - start + " p");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void test(int n) {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, n));
            System.out.printf(System.nanoTime() - start + " %d\n", n);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
