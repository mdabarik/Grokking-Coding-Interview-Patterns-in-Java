/*
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.

Example 1:
Input: n = 19
Output: true
Explanation:
1^2 + 9^2 = 82
8^2 + 2^2 = 68
6^2 + 8^2 = 100
1^2 + 0^2 + 0^2 = 1
 
*/

class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int square = 0;
            while (n > 0) {
                int lastDigit = n % 10;
                square += lastDigit * lastDigit;
                n /= 10;
            }

            if (square == 1) 
                return true;
            else 
                n = square;
        }
        return false;
    }
}



/* Two Pointer Approach */
class HappyNumber {
  public static int sumOfSquaredDigits(int number) {
      int totalSum = 0;
      while (number != 0) {
        int digit = number % 10;
        number = number / 10;
        totalSum += (Math.pow(digit, 2));
      }
      return totalSum;
  }
  public static boolean isHappyNumber(int n) {
      int slowPointer = n; 
      int fastPointer = sumOfSquaredDigits(n); 

      while (fastPointer != 1 && slowPointer != fastPointer) {
          slowPointer = sumOfSquaredDigits(slowPointer);
          fastPointer =  sumOfSquaredDigits(sumOfSquaredDigits(fastPointer));
      }
      return fastPointer == 1;
  }
}

// TC: O(n), SC: O(n)