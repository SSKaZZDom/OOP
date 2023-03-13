package primenumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for findings non-prime numbers in the list using multiple threads.
 */
public class FindWithThreads extends InterruptedException {
    /**
     * This function return true, if the list has non-prime number, and false otherwise.
     *
     * @param list  - The list we are looking for
     * @param count - Count of threads
     */
    public boolean threadPrimeFinder(List<Integer> list, int count) throws InterruptedException {
        List<FindPrime> threads = new ArrayList<>();
        int step = list.size() / count;
        int remain = list.size() % count;
        int index = 0;
        for (int i = 0; i < count; i++) {
            if (remain > 0) {
                threads.add(new FindPrime(list.subList(index, index + step + 1)));
                index += step + 1;
                remain--;
            } else {
                threads.add(new FindPrime(list.subList(index, index + step)));
                index += step;
            }
            threads.get(i).start();
        }

        for (int i = 0; i < count; i++) {
            threads.get(i).join();
            if (threads.get(i).getResult()) {
                return true;
            }
        }
        return false;
    }
}