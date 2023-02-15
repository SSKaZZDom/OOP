package primenumbers;

import static java.lang.Math.sqrt;

import java.util.List;

/**
 * This class used for finding not prime numbers.
 * Class extends Thread
 */
public class FindPrime extends Thread {
    List<Integer> nums;
    boolean res;

    public FindPrime(List<Integer> nums) {
        this.nums = nums;
    }

    /**
     * This function checks if there is a non-prime number in the list.
     */
    public boolean doNotHavePrime() {
        for (Integer o : nums) {
            if (isNotPrime(o)) {
                return true;
            }
        }
        return false;
    }

    /**
     * This function checks "num" is non-prime number.
     * @param num - the number that is being checked.
     */
    public static boolean isNotPrime(int num) {
        for (int i = 2; i <= sqrt(num); i++) {
            if (num % i == 0) {
                return true;
            }
        }
        return false;
    }

    public boolean getResult() {
        return res;
    }

    @Override
    public void run() {
        res = doNotHavePrime();
    }
}
