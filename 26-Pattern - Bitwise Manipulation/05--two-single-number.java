/*
https://leetcode.com/problems/single-number-iii/
*/

class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;
        for (int num : nums) {
            xor ^= num;
        }
        int bit = 1;
        for (int i = 0; i < 32; i++) {
            int set_bit = 1 << i;
            if ((xor & set_bit) != 0) {
                bit = set_bit;
                break;
            }
        }
        int bucket1 = 0;
        int bucket2 = 0;
        for (int num : nums) {
            if ((num & bit) != 0) {
                bucket1 ^= num;
            } else {
                bucket2 ^= num;
            }
        }
        int[] arr = new int[] {bucket1, bucket2};
        return arr;
    }
}
// TC: O(n), SC: O(n)