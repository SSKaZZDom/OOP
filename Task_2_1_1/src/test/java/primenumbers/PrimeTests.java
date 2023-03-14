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
            Assertions.assertTrue(fp.doNotHavePrime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testNotConcurrencyTrue() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 1));
            System.out.println(System.nanoTime() - start + " 1");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 1));
            System.out.println(System.nanoTime() - start + " 1");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 1));
            System.out.println(System.nanoTime() - start + " 1");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTwoThreads() {

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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 2));
            System.out.println(System.nanoTime() - start + " 2");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 2));
            System.out.println(System.nanoTime() - start + " 2");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 2));
            System.out.println(System.nanoTime() - start + " 2");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testThreeThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 3));
            System.out.println(System.nanoTime() - start + " 3");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 3));
            System.out.println(System.nanoTime() - start + " 3");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 3));
            System.out.println(System.nanoTime() - start + " 3");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFourThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 4));
            System.out.println(System.nanoTime() - start + " 4");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 4));
            System.out.println(System.nanoTime() - start + " 4");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 4));
            System.out.println(System.nanoTime() - start + " 4");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFiveThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 5));
            System.out.println(System.nanoTime() - start + " 5");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 5));
            System.out.println(System.nanoTime() - start + " 5");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 5));
            System.out.println(System.nanoTime() - start + " 5");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSixThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 6));
            System.out.println(System.nanoTime() - start + " 6");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 6));
            System.out.println(System.nanoTime() - start + " 6");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 6));
            System.out.println(System.nanoTime() - start + " 6");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSevenThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 7));
            System.out.println(System.nanoTime() - start + " 7");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 7));
            System.out.println(System.nanoTime() - start + " 7");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 7));
            System.out.println(System.nanoTime() - start + " 7");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testEightThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 8));
            System.out.println(System.nanoTime() - start + " 8");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 8));
            System.out.println(System.nanoTime() - start + " 8");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 8));
            System.out.println(System.nanoTime() - start + " 8");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTenThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 10));
            System.out.println(System.nanoTime() - start + " 10");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 10));
            System.out.println(System.nanoTime() - start + " 10");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 10));
            System.out.println(System.nanoTime() - start + " 10");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTwelveThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 12));
            System.out.println(System.nanoTime() - start + " 12");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 12));
            System.out.println(System.nanoTime() - start + " 12");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 12));
            System.out.println(System.nanoTime() - start + " 12");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFourteenThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 14));
            System.out.println(System.nanoTime() - start + " 14");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 14));
            System.out.println(System.nanoTime() - start + " 14");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 14));
            System.out.println(System.nanoTime() - start + " 14");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testSixteenThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 16));
            System.out.println(System.nanoTime() - start + " 16");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 16));
            System.out.println(System.nanoTime() - start + " 16");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 16));
            System.out.println(System.nanoTime() - start + " 16");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTwentyFourThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 24));
            System.out.println(System.nanoTime() - start + " 24");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 24));
            System.out.println(System.nanoTime() - start + " 24");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 24));
            System.out.println(System.nanoTime() - start + " 24");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testThirtyTwoThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 32));
            System.out.println(System.nanoTime() - start + " 32");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 32));
            System.out.println(System.nanoTime() - start + " 32");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 32));
            System.out.println(System.nanoTime() - start + " 32");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTwentyThreads() {
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
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 20));
            System.out.println(System.nanoTime() - start + " 20");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 20));
            System.out.println(System.nanoTime() - start + " 20");
        } catch (IOException | InterruptedException e) {
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
            FindWithThreads fwt = new FindWithThreads();
            long start = System.nanoTime();
            Assertions.assertFalse(fwt.threadPrimeFinder(test, 20));
            System.out.println(System.nanoTime() - start + " 20");
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
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
}
