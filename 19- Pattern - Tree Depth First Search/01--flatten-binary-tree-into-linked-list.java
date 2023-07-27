/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
*/

class Solution {
    TreeNode prev = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}

// TC: O(n), SC: O(n)



class Solution {
    public static void flatten(Node root) {
        Node curr = root;
        while (curr != null) {
            if (curr.left != null) {
                Node last = curr.left;
                while (last.right != null) {
                    last = last.right;
                }
                last.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
            }
            curr = curr.right;
        }
    }
}

// TC: O(n), SC: O(1)