package primenumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for findings non-prime numbers in the list using multiple threads.
 */
public class FindWithTreads {
    /**
     * This function return true, if the list has non-prime number, and false otherwise.
     * @param list - The list we are looking for
     * @param count - Count of threads
     */
    public boolean threadsFinder(List<Integer> list, int count) {
        int step = list.size() / count;
        int remain = list.size() % count;
        int index = 0;
        List<FindPrime> threads = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (remain > 0) {
                threads.add(new FindPrime(list.subList(index, index + step + 1)));
                remain--;
                index += step + 1;
            } else {
                threads.add(new FindPrime(list.subList(index, index + step)));
                index += step;
            }
            threads.get(i).start();
        }
        for (int i = 0; i < count; i++) {
            try {
                threads.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (threads.get(i).getResult()) {
                return true;
            }
        }
        return false;
    }
}
