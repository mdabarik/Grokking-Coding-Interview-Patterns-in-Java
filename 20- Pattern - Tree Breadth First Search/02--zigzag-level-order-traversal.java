/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> traversal = new ArrayList<>();
        if (root == null) return traversal;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            while (size != 0) {
                TreeNode tmp = queue.poll();
                if (level % 2 == 0) currLevel.add(tmp.val);
                else if (level % 2 == 1) currLevel.add(0, tmp.val);
                if (tmp.left != null) queue.add(tmp.left);
                if (tmp.right != null) queue.add(tmp.right);
                size--;
            }
            level++;
            traversal.add(currLevel);
        }
        return traversal;
    }
} // TC: O(n), SC: O(n)