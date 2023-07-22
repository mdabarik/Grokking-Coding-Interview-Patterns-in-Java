/*
https://practice.geeksforgeeks.org/problems/palindrome-string0817/1
*/

/*
Write a function that takes a string, s, as an input and determines whether or not it is a palindrome.
Note: A palindrome is a word, phrase, or sequence of characters that reads the same backward as forward.

Example 1:
Input: str = "abcba"
Output: True

Example 2: 
Input: str = "abcca"
Output: True

*/

import java.util.*;

public class Main {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char ch1 = s.charAt(left);
            char ch2 = s.charAt(right);
            if (ch1 != ch2) return false;
            left++;
            right--;
        }
        return true;
    }
} 

// TC: O(n), SC: O(1)