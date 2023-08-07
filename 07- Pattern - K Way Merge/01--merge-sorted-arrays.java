/*
https://practice.geeksforgeeks.org/problems/merge-two-sorted-arrays-1587115620/1
https://leetcode.com/problems/merge-sorted-array/submissions/707775044/
*/


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            int valAtP1 = p1 >= 0 ? nums1[p1] : Integer.MIN_VALUE;
            int valAtP2 = p2 >= 0 ? nums2[p2] : Integer.MIN_VALUE;
            if (valAtP1 > valAtP2) {
                nums1[i] = valAtP1;
                p1--;
            } else {
                nums1[i] = valAtP2;
                p2--;
            }
        }
    }
} // TC: O(m + n), SC: O(1)