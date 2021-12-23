/*https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1*/

class Solution
{
    public void connect(Node root)
    {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int len = queue.size();
            if (len == 1)
            {
                Node node = queue.poll();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                continue;
            }
            for (int i = 0; i < len; ++i)
            {
                Node node = queue.poll();
                Node nextNode = queue.peek();
                if (i != len-1) node.nextRight = nextNode;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
    }
}