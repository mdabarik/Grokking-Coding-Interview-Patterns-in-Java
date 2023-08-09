/*
Missing and repeated number
We are given an unsorted array, nums, with n elements and each element is in the range [1,n]
inclusive. The array originally contained all the elements from 1 to n but due to a data error, one of the numbers is duplicated, which causes another number missing. Find and return the corrupt pair (missing, duplicated).
*/

/*
https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
*/

import java.util.*;

class FindCorruptPair {
    public static int[] findCorruptPair(int[] nums) {
        int duplicated = 0;
        int missing = 0;
        int[] pair = {0, 0};

        int i = 0;
        while (i < nums.length) {
            int correct = nums[i] - 1;
            if (nums[i] != nums[correct]) {
                swap(nums, i, correct);
            } else {
                i = i + 1;
            }
        }

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                duplicated = nums[j];
                missing = j + 1;
            }
        }

        pair[0] = missing;
        pair[1] = duplicated;

        return pair;
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
    // Driver code
    public static void main(String[] args) {

        int[][] array = {{3, 1, 2, 5, 2},
                        {3, 1, 2, 3, 6, 4},
                        {4, 1, 2, 1, 6, 3},
                        {4, 3, 4, 5, 1},
                        {5, 3, 5, 6, 2, 1}};
        
        for (int i = 0; i < array.length; i++) {
            System.out.print(i + 1);
            System.out.print(".\tGiven array: " + Arrays.toString(array[i]));
            System.out.print("\n\tCorrupt pair: ");
            System.out.print(findCorruptPair(array[i])[0]);
            System.out.print(", ");
            System.out.println(findCorruptPair(array[i])[1]);
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }

    }

}