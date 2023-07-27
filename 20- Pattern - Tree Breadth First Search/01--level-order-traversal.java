/*
https://leetcode.com/problems/binary-tree-level-order-traversal/
*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); 
            List<Integer> currLevel = new ArrayList<>();
            while (size != 0) {
                TreeNode tmp = queue.poll();
                currLevel.add(tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                size--;
            }
            traversal.add(currLevel);
        }
        return traversal;
    }
} // TC: O(n), SC: O(n)