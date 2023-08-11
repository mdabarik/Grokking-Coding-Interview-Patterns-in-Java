/*
https://leetcode.com/problems/median-of-two-sorted-arrays/
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a = nums1;
        int[] b = nums2;

        //A must be shorter then B
        if (a.length > b.length) {
            a = nums2;
            b = nums1;
        }

        int total = a.length + b.length;
        int half = total / 2;
        int l = 0, r = a.length-1;
        double mid = 0.0;

        while (true) {

            int i = Math.floorDiv(l+r, 2);
            int j = half - i - 2;

            int Aleft =  i >= 0 ? a[i] : Integer.MIN_VALUE;
            int Aright = i+1 < a.length ? a[i+1] : Integer.MAX_VALUE;
            int Bleft = j >= 0 ? b[j] : Integer.MIN_VALUE;
            int Bright = j+1 < b.length ? b[j+1] : Integer.MAX_VALUE;

            if (Bleft <= Aright && Aleft <= Bright ) {

                if (total % 2 == 0) {
                    mid = (Math.max(Aleft, Bleft) + Math.min(Aright, Bright) ) / 2.0;
                } else if (total % 2 != 0) {
                    mid = Math.min(Aright, Bright);
                }
                return mid;
            } else if (Aleft > Bright) {
                r = i - 1;
            } else {
                l = i + 1;
            }

        }

    }
}

// TC: O(log n), SC: O(1)