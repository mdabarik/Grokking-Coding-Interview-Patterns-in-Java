import java.util.*;

class RotatedSearch {
    public static int binarySearchRotated(List<Integer> nums, int target) {
        int start = 0;
        int end = nums.size() - 1;
        if (start > end)
            return -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums.get(mid) == target)
                return mid;
            if (nums.get(start) <= nums.get(mid)) {
                if (nums.get(start) <= target && target < nums.get(mid)) {
                    end = mid - 1;
                } else
                    start = mid + 1;
            } else {
                if (nums.get(mid) < target && target <= nums.get(end))
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        List<Integer> targetList = Arrays.asList(3, 60, 15, 11);
        List<List<Integer>> numList = Arrays.asList(
            Arrays.asList(1, 2, 3, 4, 5, 6, 7),
            Arrays.asList(10, 20, 30, 40, 50, 60),
            Arrays.asList(11, 15, 200, 432, 765, 1000),
            Arrays.asList(3, 5, 7, 9, 11, 13)
        );
        for (int i = 0; i < targetList.size(); i++) {
            System.out.println((i + 1) + ".\tSorted array: " + numList.get(i) +
                "\n\ttarget " + targetList.get(i) +
                " found at index " + binarySearchRotated(numList.get(i), targetList.get(i)));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}