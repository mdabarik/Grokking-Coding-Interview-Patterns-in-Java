
/*
https://leetcode.com/problems/binary-tree-right-side-view/
*/
// Same logic can be used for Left Side View
// Use Level order traver or recursive reverse-preorder (preorder for left side view)

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root, 0, list);
        return list;
    }
    public void helper(TreeNode root, int level, List<Integer> list) {
        if (root == null) return;
        if (list.size() == level) {
            list.add(root.val);
        }
        helper(root.right, level + 1, list);
        helper(root.left, level + 1, list);
    }
}

// TC: O(n), SC: O(n)



