/*https://leetcode.com/problems/populating-next-right-pointers-in-each-node/*/

class QueueNode
{
    Node node;
    QueueNode next;
    QueueNode(Node node)
    {
        this.node = node;
    }
}

class Queue
{
    public QueueNode front, rear;
    int size;
    Queue()
    {
        size = 0;
    }
    public void enqueue(Node node)
    {
        if (rear == null)
        {
            rear = new QueueNode(node);
            front = rear;
            size = 1;
        }
        else
        {
            rear.next = new QueueNode(node);
            rear = rear.next;
            ++size;
        }
    }
    public QueueNode dequeue()
    {
        QueueNode returnNode = null;
        if (front == rear)
        {
            returnNode = front;
            front = rear = null;
            size = 0;
        }
        else
        {
            returnNode = front;
            front = front.next;
            returnNode.next = null;
            --size;
        }
        return returnNode;
    }
    public QueueNode checkFront()
    {
        return this.front;
    }
    public boolean isEmpty()
    {
        return size == 0 ? true : false;
    }
    public int getSize()
    {
        return this.size;
    }
}

class Solution {
    public Node connect(Node root) {

    	//base case
        if (root == null) return null;
        Queue queue = new Queue();

        //add root to queue
        queue.enqueue(root);
        QueueNode currQueueNode = null, nextQueueNode = null; //two pointers for queue node
        Node currNode = null, nextNode = null; //two pointers for tree node

        //till queue has more elements
        while (!queue.isEmpty())
        {
        	//get the number of nodes in the current level
            int currLevelSize = queue.getSize();

            //for each node
            for (int i = 0; i < currLevelSize; ++i)
            {
            	//dequeue the node
                currQueueNode = queue.dequeue();
                currNode = currQueueNode.node;

                //add its children
                if (currNode.left != null) queue.enqueue(currNode.left);
                if (currNode.right != null) queue.enqueue(currNode.right);
                
                //store the next node on this level in another pointer
                nextQueueNode = queue.checkFront();

                //if its not the last node of the current level and the next node is not null, populate the pointer
                if (i < currLevelSize-1 && nextQueueNode != null)
                {
                    nextNode = nextQueueNode.node;
                    currNode.next = nextNode;
                }
            }
        }

        //return the root
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
        solve(root);
        return root;
    }
    private void solve(Node root)
    {
        if (root == null) return;
        
        if (root.left != null)
            root.left.next = root.right;
        
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;
        
        solve(root.left);
        solve(root.right);
    }
}