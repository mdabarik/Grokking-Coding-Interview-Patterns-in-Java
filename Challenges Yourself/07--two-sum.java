/*
https://leetcode.com/problems/two-sum/
*/

// Blind 75

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i]; // [nums[i], diff]
            if (!map.containsKey(diff)) {
                map.put(nums[i], i);
            } else {
                ans[0] = i;
                ans[1] = map.get(diff);
                break;
            }
        }
        return ans;
    }
} // TC: O(n), SC: O(n)