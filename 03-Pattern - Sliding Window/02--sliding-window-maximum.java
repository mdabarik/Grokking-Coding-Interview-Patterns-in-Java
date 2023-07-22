/*
https://leetcode.com/problems/sliding-window-maximum/
*/

/*You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

Return the max sliding window.

Example 1:
Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
Output: [3,3,5,5,6,7]
Explanation: 
Window position                Max
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7

Example 2:
Input: nums = [1], k = 1
Output: [1] */


class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] slidingWinMax = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // if deque contains element out of current window: remove those element
            if (deque.size() > 0 && deque.peekFirst() < i - k + 1) { // leftBoundary: i - k + 1
                deque.pollFirst();
            }
            // keep only relevant element 
            // (Keep the properties: first element in deque always max, in curr win)
            while (deque.size() > 0 && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            if (i - k + 1 >= 0) {
                slidingWinMax[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return slidingWinMax;
    }
} // TC: O(n), SC: O(k) + O(n - k + 1)F