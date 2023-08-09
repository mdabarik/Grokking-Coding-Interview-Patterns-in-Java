/*
You are given a sorted array of integers, nums, where all integers appear twice except for one. 
Your task is to find and return the single integer that appears only once.
The solution should have a time complexity of O(logn) or better and a space complexity of O(1)

Input:  nums = [1,1,2,3,3,4,4,8,8]
Output: 2

Input: nums = [3,3,7,7,10,11,11]
Output: 10

*/

class Solution {
    public int singleNonDuplicate(int[] nums) {
        int left = 0, right = nums.length-1;
        while(left < right){
            int mid = (left + right)/2;
            if( (mid % 2 == 0 && nums[mid] == nums[mid +1]) || (mid %2 == 1 && nums[mid] == nums[mid - 1]) )
                left = mid + 1;
            else
                right = mid;
        }
        return nums[right];
    }   
}

// TC: O(log n), SC: O(1)