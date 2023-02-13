package primenumbers;

import java.util.ArrayList;
import java.util.List;

public class FindWithTreads {
    public boolean threadsFinder(List<Integer> list, int count) {
        List<List<Integer>> lists = new ArrayList<>();
        int step = list.size() / count;
        int remain = list.size() % count;
        int index = 0;
        List<Integer> part;
        for (int i = 0; i < count; i++) {
            part = list.subList(index, index + step);
            lists.add(part);
            index += step;
        }
        lists.get(count - 1).addAll(list.subList(index, index + remain));
        List<FindPrime> threads = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            threads.set(i, new FindPrime(lists.get(i)));
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
