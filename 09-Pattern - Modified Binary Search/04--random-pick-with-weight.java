/*
https://leetcode.com/problems/random-pick-with-weight/description/
*/


class Solution {
    int[] cSum;
    int sum;
    public Solution(int[] w) {
        sum = 0;
        cSum = new int[w.length];
        for (int i = 0; i < w.length; i++) {
            sum += w[i];
            cSum[i] = sum;
        }
    }

    public int pickIndex() {
        int idx = (int) (Math.random() * sum);
        return binarySearch(idx + 1);
    }

    public int binarySearch(int val) {
        int left = 0, right = cSum.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (cSum[mid] < val) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
