/*
Write a function that takes a string as input and checks whether it can be a valid palindrome by removing at most one character from it.

Note: The string only consists of English letters

Example 1:
Input: str = "ABCEBA"
Output: True

Example 2:
Input: str = "RACEACAT"
Output: False

Example 3:
Input: str = "DEEAD"
Output: True

*/


import java.util.*;

public class Main {
    public static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (s.charAt(left) != s.charAt(right)) return false;
        return isPalindrome(s, left + 1, right - 1);
    }
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrome(s, left, right - 1) || isPalindrome(s, left + 1, right);
            }
            left++;
            right--;
        }
        return true;
    }
}

// TC: O(n), SC: O(n)