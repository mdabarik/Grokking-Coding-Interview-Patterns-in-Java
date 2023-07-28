/*
https://leetcode.com/problems/house-robber/
*/





class Solution {
    public int dfs(int[] nums, int index, int[] dp) {
        if (index < 0) {
            return 0;
        }
        if (dp[index] != -1) return dp[index];
        int notRob = dfs(nums, index - 1, dp);
        int rob = nums[index] + dfs(nums, index - 2, dp);
        return dp[index] = Math.max (notRob, rob);
    }
    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return dfs(nums, nums.length - 1, dp);
    }
} // TC: O(2^n) -- O(n), SC: O(n) -- O(n) + O(n)




class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int rob = nums[i] + dp[i - 2];
            int notRob = dp[i - 1];
            dp[i] = Math.max(rob, notRob);
        }
        return dp[nums.length - 1];
    }
} // TC: O(n), SC: O(n)



class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int prev1 = nums[0];
        int prev2 = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            int curr = Math.max(nums[i] + prev1, prev2);
            prev1 = prev2;
            prev2 = curr;
        }
        return prev2;
    }
} // TC: O(n), SC: O(1)