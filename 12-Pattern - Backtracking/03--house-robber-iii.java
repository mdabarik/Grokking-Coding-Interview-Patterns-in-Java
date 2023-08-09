/*
https://leetcode.com/problems/house-robber-iii/description/
*/


class Solution {
    public int rob(TreeNode root) {
        int[] answer = helper(root);
        return Math.max(answer[0], answer[1]);
    }
    public int[] helper(TreeNode root) {
        if (root == null) {
            return new int[] {0, 0};
        }
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        
        int rob = root.val + left[1] + right[1];
        
        int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        return new int[] {rob, notRob};
    }
}

/* Dont think level order traversal
look at this--> [2,1,3,null,4] ans =7;
 */


 class Solution {
    public static int[] heist(TreeNode<Integer> root) {
        if (root == null) {
            return new int[]{0,0};
        }
        int[] leftSubtree = heist(root.left);
        int[] rightSubtree = heist(root.right);
        int includeRoot = root.data + leftSubtree[1] + rightSubtree[1];
        int excludeRoot = Math.max(leftSubtree[0], leftSubtree[1]) + Math.max(rightSubtree[0], rightSubtree[1]);

        return new int[] {includeRoot, excludeRoot};
    }

    public static int rob(TreeNode<Integer> root) {
        int[] result = heist(root);
        return Math.max(result[0], result[1]);
    }
 }