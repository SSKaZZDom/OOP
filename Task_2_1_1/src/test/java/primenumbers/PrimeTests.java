package primenumbers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeTests {
    @Test
    public void testNotConcurrency() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++){
                test.add(sc.nextInt());
            }
            FindPrime fp = new FindPrime(test);
            Assertions.assertTrue(fp.doNotHavePrime());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testTwoThreads() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++){
                test.add(sc.nextInt());
            }
            FindWithTreads fwt = new FindWithTreads();
            Assertions.assertTrue(fwt.threadsFinder(test, 2));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testThreeThreads() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++){
                test.add(sc.nextInt());
            }
            FindWithTreads fwt = new FindWithTreads();
            Assertions.assertTrue(fwt.threadsFinder(test, 3));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFourThreads() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++){
                test.add(sc.nextInt());
            }
            FindWithTreads fwt = new FindWithTreads();
            Assertions.assertTrue(fwt.threadsFinder(test, 4));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testParallelStream() {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("Nums.txt")) {
            assert stream != null;
            Scanner sc = new Scanner(stream);
            int cnt = sc.nextInt();
            List<Integer> test = new ArrayList<>();
            for (int i = 0; i < cnt; i++){
                test.add(sc.nextInt());
            }
            Assertions.assertTrue(test.parallelStream().anyMatch(FindPrime::isNotPrime));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
