package foo.bar;

import java.util.*;

import static java.util.Arrays.asList;

public class TripleCleaner {


    public static void main(String[] args) {
        List<Integer> numbers = asList(-1, -1, -1, 2, 7, 7, 7, 7, 4, 9, 2, 4, 6, 6, 7, 2, 2, 2, 1, 1);

        // in seq >>
        System.out.println("check1: " + removeInSeq(numbers, 3).equals(asList(2, 4, 9, 2, 4, 6, 6, 7, 1, 1)));
        System.out.println("check2: " + removeInSeq(Collections.<Integer>emptyList(), 3).isEmpty());
        System.out.println("check3: " + removeInSeq(asList(1, 1, 1, 1, 1, 1), 3).isEmpty());

        // all >>
        System.out.println("check4: " + removeAll(numbers, 3).equals(asList(4, 9, 4, 6, 6, 1, 1)));
        System.out.println("check5: " + removeAll(Collections.<Integer>emptyList(), 3).isEmpty());
        System.out.println("check6: " + removeAll(asList(1, 1, 1, 1, 1, 1), 3).isEmpty());
    }

    /**
     * O(n), in-place
     */
    static List<Integer> removeInSeq(List<Integer> list, final int repeat) {
        if (repeat < 1 || list == null) throw new IllegalArgumentException();

        List<Integer> result = new ArrayList<>();

        List<Integer> buff = new ArrayList<>();
        for (Integer n : list) {
            if (buff.isEmpty() || Objects.equals(buff.get(0), n)) {
                buff.add(n);
            } else {
                if (buff.size() < repeat) {
                    result.addAll(buff);
                }
                buff.clear();
                buff.add(n);
            }
        }

        if (!buff.isEmpty() && buff.size() < repeat) {
            result.addAll(buff);
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
