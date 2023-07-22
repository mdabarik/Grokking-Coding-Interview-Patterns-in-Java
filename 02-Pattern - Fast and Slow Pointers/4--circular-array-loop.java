/*
https://leetcode.com/problems/circular-array-loop/
*/


/* You are playing a game involving a circular array of non-zero integers nums. Each nums[i] denotes the number of indices forward/backward you must move if you are located at index i:

If nums[i] is positive, move nums[i] steps forward, and
If nums[i] is negative, move nums[i] steps backward.
Since the array is circular, you may assume that moving forward from the last element puts you on the first element, and moving backwards from the first element puts you on the last element.

A cycle in the array consists of a sequence of indices seq of length k where:

Following the movement rules above results in the repeating index sequence seq[0] -> seq[1] -> ... -> seq[k - 1] -> seq[0] -> ...
Every nums[seq[j]] is either all positive or all negative.
k > 1
Return true if there is a cycle in nums, or false otherwise.

Example 1:
Input: nums = [2,-1,1,2,2]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 2 --> 3 --> 0 --> ..., and all of its nodes are white (jumping in the same direction).

Example 2:
Input: nums = [-1,-2,-3,-4,-5,6]
Output: false
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
The only cycle is of size 1, so we return false.

Example 3:
Input: nums = [1,-1,5,1,4]
Output: true
Explanation: The graph shows how the indices are connected. White nodes are jumping forward, while red is jumping backward.
We can see the cycle 0 --> 1 --> 0 --> ..., and while it is of size > 1, it has a node jumping forward and a node jumping backward, so it is not a cycle.
We can see the cycle 3 --> 4 --> 3 --> ..., and all of its nodes are white (jumping in the same direction).
 

Constraints:
1 <= nums.length <= 5000
-1000 <= nums[i] <= 1000
nums[i] != 0
 
Follow up: Could you solve it in O(n) time complexity and O(1) extra space complexity? */


// Without Comments
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        int slow = 0, fast = 0;
        for (int i = 1; i <= n; i++) {
            int prev = slow;
            slow = nextStep(slow, nums[slow], n);
            if (isNotCycle(nums, prev, slow)) {
                slow = i;
                fast = i;
                continue;
            }
            boolean nextIteration = false;
            for (int j = 1; j <= 2; j++) {
                prev = fast;
                fast = nextStep(fast, nums[fast], n);
                if (isNotCycle(nums, prev, fast)) {
                    slow = i;
                    fast = i;
                    nextIteration = true;
                    break;
                }
            }
            if (nextIteration == true) continue;
            if (slow == fast) return true;
        }
        return false;
    }

    int nextStep(int pointer, int val, int n) {
        int result = (pointer + val) % n;
        if (result < 0) result += n;
        return result;
    }

    boolean isNotCycle(int[] nums, int prev, int pointer) {
        if (nums[prev] >= 0 && nums[pointer] < 0) return true;
        if (Math.abs(nums[pointer] % nums.length) == 0) return true;
        else return false;
    }
}

// TC: O(n), SC: O(1)


// With Comments
class Solution {
    public boolean circularArrayLoop(int[] nums) {
        return call(nums);
    }
    
    boolean call(int[] nums) {
        // Set slow and fast pointer at first element.
        int slow = 0, fast = 0;

        int size = nums.length;

        for (int i = 1; i <= size; i++) {
        // Save slow pointer's value before moving.
        int prev = slow;
        // Move slow pointer to one step.
        slow = nextStep(slow, nums[slow], size);
        // Check if cycle is impossible, then set both pointers to next value
        // and move to the next iteration.
        if (isNotCycle(nums, prev, slow)) {
            fast = i;
            slow = i;
            continue;
        }
        // This flag indicates whether we need to move to the next iteration.
        boolean nextIter = false;
        // Number of moves of fast pointer.
        int moves = 2;
        for (int j = 0; j < moves; j++) {
            // Save fast pointer's value before moving.
            prev = fast;
            // Move fast pointer check cycle after every move.
            fast = nextStep(fast, nums[fast], size);
            // If cycle is not possible, set slow and fast to next element
            // set 'next_iter' to true and break this loop.
            if (isNotCycle(nums, prev, fast)) {
            fast = i;
            slow = i;
            nextIter = true;
            break;
            }
        }
        // Move to the next iteration
        if (nextIter) {
            continue;
        }
        // If both pointers are at same position after moving both, a cycle is detected.
        if (slow == fast) {
            return true;
        }
        }
        return false;
    }

    // A function to calculate the next step.
    int nextStep(int pointer, int value, int size) {
        int result = (pointer + value) % size;
        if (result < 0) {
        result += size;
        }
        return result;
    }

    // A function to detect a cycle doesn't exist
    boolean isNotCycle(int[] nums, int prev, int pointer) {
        // If signs of both pointers are different or moving a pointer takes back to the same value,
        // then the cycle is not possible, we return True, otherwise return False.
        if ((nums[prev] >= 0 && nums[pointer] < 0) || (Math.abs(nums[pointer] % nums.length) == 0)) {
        return true;
        } else {
        return false;
        }
    }
}