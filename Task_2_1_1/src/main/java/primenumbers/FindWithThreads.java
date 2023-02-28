package primenumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for findings non-prime numbers in the list using multiple threads.
 */
public class FindWithThreads extends InterruptedException{
    /**
     * This function return true, if the list has non-prime number, and false otherwise.
     *
     * @param list - The list we are looking for
     * @param count - Count of threads
     */
    public boolean threadPrimeFinder(List<Integer> list, int count) throws InterruptedException {
        List<FindPrime> threads = new ArrayList<>();
        List<List<Integer>> lists = subLists(list, count);

        for (int i = 0; i < count; i++) {
            threads.add(new FindPrime(lists.get(i)));
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

    private List<List<Integer>> subLists (List<Integer> list, int count) {
        int step = list.size() / count;
        int remain = list.size() % count;
        int index = 0;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (remain > 0) {
                result.add(list.subList(index, index + step + 1));
                remain--;
                index += step + 1;
            } else {
                result.add(list.subList(index, index + step));
                index += step;
            }
        }
        return result;
    }
}
