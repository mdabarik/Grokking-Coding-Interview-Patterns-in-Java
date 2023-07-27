/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        if(root.left != null) root.left.next = root.right;
        if(root.right != null && root.next != null) root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
        return root;
    }
}

// TC: O(n), SC: O(n)

/*
GFG Solution
*/
public void connect(TreeLinkNode root) {
    TreeLinkNode dummyHead = new TreeLinkNode(0);
    TreeLinkNode pre = dummyHead;
    while (root != null) {
	    if (root.left != null) {
		    pre.next = root.left;
		    pre = pre.next;
	    }
	    if (root.right != null) {
		    pre.next = root.right;
		    pre = pre.next;
	    }
	    root = root.next;
	    if (root == null) {
		    pre = dummyHead;
		    root = dummyHead.next;
		    dummyHead.next = null;
	    }
    }
}




// Easy solution

class Solution {
    public Node connect(Node root) {
        //check for null input 
        if(root == null)return root;
        //make a queue for bfs
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        //going through the nodes in the queue
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i< size; i++){
                Node curr = queue.poll();
                //if the node is not the last node in its level
                if(i<size-1) curr.next = queue.peek();
                //add the left and right child to the queue
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        return root;
    }
}