/*
https://practice.geeksforgeeks.org/problems/minimum-window-subsequence/1
*/

/*Given strings str1 and str2, find the minimum (contiguous) substring W of str1, so that str2 is a subsequence of W.
If there is no such window in str1 that covers all characters in str2, return the empty string "". If there are multiple such minimum-length windows, return the one with the left-most starting index.

Example 1:
Input: str1: geeksforgeeks str2: eksrg
Output: eksforg
Explanation: 
Eksforg satisfies all required conditions. str2 is its subsequence and it is longest and leftmost among all possible valid substrings of str1.

Example 2:
Input: str1: abcdebdde str2: bde
Output: bcde
Explanation: 
"bcde" is the answer and "deb" is not a smaller window because the elements of T in the window must occur in order.
*/


// Simpler way to write it
class Solution {
    public String minWindow(String s, String t) {
       
        int sIndex = 0, tIndex = 0, start = -1;
        int m = s.length(), n = t.length(), minLength = m;
        char[] ss = s.toCharArray(), tt = t.toCharArray();
    
        while (sIndex < m) {
            if(ss[sIndex] == tt[tIndex]) { // char match
                if(++tIndex == n) { // end
                    int end = sIndex + 1;
                        
                    while(--tIndex >= 0) {
                        while(ss[sIndex--] != tt[tIndex]);
                    }
                    sIndex++;
                    tIndex++;
                    
                    // record
                    if (end - sIndex < minLength) {
                        minLength = end - sIndex;
                        start = sIndex;
                    }
                }
            }
            ++sIndex;
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
}

// Another way to write: use for loop to backtrack and direct reset tIndex = 0;
class Solution {
    public String minWindow(String s, String t) {
       
        int sIndex = 0, tIndex = 0, start = -1;
        int m = s.length(), n = t.length(), minLength = m;
        char[] ss = s.toCharArray(), tt = t.toCharArray();
        
        while (sIndex < m) {
            if(ss[sIndex] == tt[tIndex]) { // char match
                if(tIndex++ == n - 1) { // tIndex exhausted, process it
                    int end = sIndex + 1; // mark end of candidate
                    // reset tIndex to 0 and backtrack sIndex to 1st match position
                    tIndex = 0;
                    sIndex = backtrack(ss, tt, sIndex);

                    // record the candidate
                    if (end - sIndex < minLength) {
                        minLength = end - sIndex;
                        start = sIndex;
                    }
                }
            }
            sIndex++;
        }
        return start == -1 ? "" : s.substring(start, start + minLength);
    }
    
    private int backtrack(char[] ss, char[] tt, int sIndex) {
        for (int i = tt.length - 1; i >= 0; i--) {
            while(ss[sIndex--] != tt[i]);
        }
        return ++sIndex; // sIndex = 1st char match index - 1; ++ to reset
    }
}