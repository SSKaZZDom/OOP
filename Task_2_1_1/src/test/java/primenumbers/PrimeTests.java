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
            Assertions.assertFalse(fp.doNotHavePrime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testNotConcurrencyTrue() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindPrime fp = new FindPrime(test);
            Assertions.assertTrue(fp.doNotHavePrime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testTwoThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 2));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testThreeThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 3));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testFourThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 4));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testFiveThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 5));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testSixThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 6));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testSevenThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 7));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testEightThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 8));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testNineThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 9));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testTenThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 10));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testElevenThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 11));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testTwelveThreads() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            FindWithThreads fwt = new FindWithThreads();
            Assertions.assertTrue(fwt.threadPrimeFinder(test, 12));
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }

    @Test
    public void testParallelStream() {
        long start = System.nanoTime();
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums1.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++) {
                test.add(sc.nextInt());
            }
            Assertions.assertTrue(test.parallelStream().anyMatch(FindPrime::isNotPrime));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(System.nanoTime() - start);
    }
}
