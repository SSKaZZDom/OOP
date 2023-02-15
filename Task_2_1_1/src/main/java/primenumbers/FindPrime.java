package primenumbers;

import java.util.List;

import static java.lang.Math.sqrt;

public class FindPrime extends Thread {
    List<Integer> nums;
    boolean res;
    public FindPrime(List<Integer> nums) {
        this.nums = nums;
    }

    public boolean doNotHavePrime() {
        for (Integer o : nums){
            if (isNotPrime(o)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isNotPrime(int num) {
        for (int i = 2; i <= sqrt(num); i++){
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
