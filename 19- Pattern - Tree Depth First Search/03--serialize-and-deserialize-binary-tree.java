/*
https://practice.geeksforgeeks.org/batch/test-series-bundle/track/FTS-tree/problem/serialize-and-deserialize-a-binary-tree
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 */


 public class Codec {
    public String serialize(TreeNode root) { // TC: O(n), SC: O(n)
        if (root == null) {
            return "#";
        }
        String left = serialize(root.left);
        String right = serialize(root.right);
        return root.val + "," + left + "," + right;
    }
    
    public TreeNode deserialize(String data) {  // TC: O(n), SC: O(n)
        Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        return dfs(queue);
    }

    public TreeNode dfs(Queue<String> queue) { 
        String str = queue.poll();
        if (str.equals("#")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(queue);
        node.right = dfs(queue);
        return node;
    }
}
