/*
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
*/

class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            if (nums[left] == nums[mid]) {
                left++;
            } else if (nums[left] < nums[mid]) { // left...mid => increasing
                if (nums[left] <= target && nums[mid] > target) { // if target located in between left..mid-1
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                
            } else { // mid...right increasing
                if (nums[mid] < target && nums[right] >= target) { // if target located in between mid+1..right
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return false;
    }
}

// TC: O(log n), SC: O(1)