package foo.bar;

import java.util.*;

import static java.util.Arrays.asList;

public class TripleCleaner {


    public static void main(String[] args) {
        List<Integer> numbers = asList(-1, -1, -1, 2, 7, 7, 7, 7, 4, 9, 2, 4, 6, 6, 7, 2, 2, 2, 1, 1);

        // in seg >>
        System.out.println("check: " + removeInSeq(numbers, 3).equals(asList(2, 4, 9, 2, 4, 6, 6, 7, 1, 1)));
        System.out.println("check: " + removeInSeq(Collections.<Integer>emptyList(), 3).isEmpty());
        System.out.println("check: " + removeInSeq(asList(1, 1, 1, 1, 1, 1), 3).isEmpty());

        // all >>
        System.out.println("check: " + removeAll(numbers, 3).equals(asList(4, 9, 4, 6, 6, 1, 1)));
        System.out.println("check: " + removeAll(Collections.<Integer>emptyList(), 3).isEmpty());
        System.out.println("check: " + removeAll(asList(1, 1, 1, 1, 1, 1), 3).isEmpty());
    }

    /**
     * O(n), in-place
     */
    static List<Integer> removeInSeq(List<Integer> list, final int repeat) {
        if (repeat < 1 || list == null) throw new IllegalArgumentException();

        List<Integer> result = new ArrayList<>();
        Integer last = null;
        int sameCount = 0;

        for (Integer n : list) {
            if (sameCount == 0) {
                last = n;
            }

            if (Objects.equals(last, n)) {
                sameCount++;
            } else {
                if (sameCount < repeat) {
                    while (sameCount-- > 1) result.add(last);
                    result.add(last);
                }
                sameCount = 1;
                last = n;
            }
        }

        if (sameCount > 0 && sameCount < repeat) {
            while (sameCount-- > 1) result.add(last);
            result.add(last);
        }
        return result;
    }

    /**
     * O(n), +additional space
     */
    static List<Integer> removeAll(List<Integer> list, final int repeat) {
        if (repeat < 1 || list == null) throw new IllegalArgumentException();

        final Map<Integer, Integer> index = new HashMap<>();
        for (Integer n : list) {
            Integer count = index.get(n);
            if (count == null) {
                index.put(n, 1);
            } else {
                count++;
                index.put(n, count);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (Integer n : list) {
            if (index.get(n) < repeat) result.add(n);
        }

        return result;
    }
}
