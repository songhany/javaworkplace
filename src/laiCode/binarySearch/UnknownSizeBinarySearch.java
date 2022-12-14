package laiCode.binarySearch;

import java.util.Arrays;

public class UnknownSizeBinarySearch {
    public int search(Dictionary dictionary, int target) {
        if (dictionary == null) {
            return -1;
        }

        int left = 0;
        int right = 1;

        // find the right boundary for binary search
        // extends until we are sure the target is within the [left, right] range.
        while (dictionary.get(right) != null && dictionary.get(right) < target) {
            // 1. move left to right
            // 2. double right index
            left = right;
            right = 2 * right;
        }
        return binarySearch(dictionary, target, left, right);
    }

    private int binarySearch(Dictionary dict, int target, int left, int right) {
        // classical binary search
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            } else if (dict.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        UnknownSizeBinarySearch sol = new UnknownSizeBinarySearch();
//        // BigIntegerTest cases
//        Dictionary dict = new DictImpl(new int[0]);
//        int target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1 });
//        target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1 });
//        target = 1;
//        System.out.println("Expect: 0, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1 });
//        target = 2;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1, 3 });
//        target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1, 3 });
//        target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1, 3 });
//        target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1, 3 });
//        target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(new int[] { 1, 3, 4, 4, 6, 10, 11, 12, 15, 15 });
//        target = 0;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        target = 6;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        target = 8;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));
//
//        dict = new DictImpl(largeArray(100000));
//        target = 99999;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));  // 99999
//
//        target = 100001;
//        System.out.println("Expect: -1, Actual: " + sol.search(dict, target));  // -1
//    }

    public static int[] largeArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    interface Dictionary {
        public Integer get(int index);
    }

    static class DictImpl implements Dictionary {
        private int[] array;
        public DictImpl(int[] array) {
            this.array = array;
        }

        // If the index is out of bound, null will be returned
        @Override
        public Integer get(int index) {
            if (array == null || index >= array.length) {
                return null;
            }
            return array[index];
        }

        // For pretty printout
        @Override
        public String toString() {
            if (array == null) {
                return String.valueOf(null);
            }
            if (array.length <= 10) {
                return Arrays.toString(array);
            }

            // Truncate output if array is too large
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < 5; i++) {
                sb.append(array[i]).append(",");
            }
            sb.append("......, ");
            for (int i = array.length - 4; i < array.length; i++) {
                sb.append(array[i]);
                if (i != array.length - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}
