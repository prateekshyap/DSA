/*https://leetcode.com/problems/complete-binary-tree-inserter/*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    Queue<TreeNode> queue;
    TreeNode root;
    public CBTInserter(TreeNode root) {
        queue = new LinkedList<TreeNode>();
        this.root = root;
        Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
        tempQueue.add(root);
        while (!tempQueue.isEmpty()) //run a standard level order traversal on the tempQueue
        {
            TreeNode curr = tempQueue.poll();
            if (curr.left != null) tempQueue.add(curr.left);
            if (curr.right != null) tempQueue.add(curr.right);
            if (curr.left == null || curr.right == null) //add all the incomplete nodes to the queue
                queue.add(curr);
        }
    }
    
    public int insert(int val) {
        TreeNode newNode = new TreeNode(val); //create a new node
        TreeNode parent = queue.peek(); //get the next incomplete parent from the queue
        if (parent.left == null) parent.left = newNode; //if left child is null, add to left child
        else parent.right = newNode; //otherwise add to right child
        if (parent.right != null) queue.poll(); //if right child is not null, remove from queue
        queue.add(newNode); //add the new node to the queue
        return parent.val; //return the value of the parent
    }
    
    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    TreeNode root;
    Queue<TreeNode> queue;
    public CBTInserter(TreeNode root) {
        this.root = root;
      
        queue = new LinkedList();
        queue.offer(root);

        // BFS to populate deque
        while (!queue.isEmpty()) {
           
            TreeNode node =  queue.peek();
            if (node.left == null || node.right == null) {
                if(node.left !=null) {
                    queue.offer(node.left);
                }
                break; 
            }
            queue.poll();  
            if (node.left != null)
                queue.offer(node.left);
            if (node.right != null)
                queue.offer(node.right);
        }
    }

    public int insert(int v) {
        TreeNode node = queue.peek();
        TreeNode newNode = new TreeNode(v);
        queue.add(newNode);
        if (node.left == null)
            node.left = newNode;
        else {
            queue.poll();
            node.right= newNode;
            
        }

        return node.val;
    }

    public TreeNode get_root() {
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */