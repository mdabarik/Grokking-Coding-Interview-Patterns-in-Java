/*
https://practice.geeksforgeeks.org/batch/test-series-bundle/track/mts-binary-tree/problem/diameter-of-binary-tree
*/

/*
Given a binary tree, you need to compute the length of the tree’s diameter. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
*/


class Solution {
    int ans = 0;
    int diameter(Node root) {
        helper(root);
        return ans;
    }
    int helper(Node root) {
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        ans = Math.max(ans, 1 + left + right); // for num edges remove 1
        return 1 + Math.max(left, right);
    }
}

// TC: O(n), SC: O(n)