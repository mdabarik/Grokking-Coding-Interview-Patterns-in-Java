/*
https://leetcode.com/problems/complement-of-base-10-integer/
*/

class Solution {
    public int bitwiseComplement(int n) {
        if (n == 0) return 1;
        int mask = 0;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }
        return ~n & mask;
    }
}