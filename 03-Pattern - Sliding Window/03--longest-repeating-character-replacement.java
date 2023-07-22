/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achive this answer too.
*/


class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int maxLength = 0, maxF = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            maxF = Math.max(maxF, ++frequency[s.charAt(right) - 'A']);
            if (right - left + 1 - maxF > k) {
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            // left -> right: valid
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
} // TC: O(n), SC: O(26) ~ O(1)