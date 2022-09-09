/*https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/*/

class Solution {
    public Node connect(Node root) {
        //return usingBFSWithQueue(root);
        return usingBFSWithoutQueue(root);//Optimized space
    }

    private Node usingBFSWithQueue(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Node prev = null;
            for (int i=0; i<size; i++) {
                Node cur = queue.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
                prev = cur;
            }
        }
        return root;
    }

    private Node usingBFSWithoutQueue(Node root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Node levelFirstNode = root;
        while (levelFirstNode != null) {
            Node dummy = new Node();
            Node firstNodeNextLevel = dummy;
            Node cur = levelFirstNode;
            while (cur != null) {
                if (cur.left != null) {
                    dummy.next = cur.left;
                    dummy = dummy.next;
                }
                if (cur.right != null) {
                    dummy.next = cur.right;
                    dummy = dummy.next;
                }
                cur = cur.next;
            }
            levelFirstNode = firstNodeNextLevel.next;
        }
        return root;
    }
}

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Node prevLevel = root;
        while (prevLevel != null)
        {
            Node move = new Node();
            Node bufferNode = move;
            while (prevLevel != null)
            {
                if (prevLevel.left != null)
                {
                    move.next = prevLevel.left;
                    move = move.next;
                }
                if (prevLevel.right != null)
                {
                    move.next = prevLevel.right;
                    move = move.next;
                }
                prevLevel = prevLevel.next;
            }
            prevLevel = bufferNode.next;
        }
        return root;
    }
}