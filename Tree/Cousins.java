/*https://practice.geeksforgeeks.org/problems/cousins-of-a-given-node/1*/

class Solution
{
    public static ArrayList<Integer> printCousins(Node root, Node node_to_find)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if (root == node_to_find) //if root is the node to be found
        {
            list.add(-1); //root has no cousins
            return list;
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root); //push root to queue
        boolean queueFilled = false;
        while (!queue.isEmpty()) //till queue is not empty
        {
            int len = queue.size(); //get the current level size
            for (int i = 0; i < len; ++i) //for each node in the current level
            {
                Node node = queue.poll(); //extract the node
                if (node.left != node_to_find && node.right != node_to_find) //if the required node is not found
                {
                	//add left and right child to the queue
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);
                }
                else //otherwise
                {
                    queueFilled = true; //indicate that the queue is filled with the correct nodes
                }
            }
            if (queueFilled) break; //if queue is filled with the correct nodes then break
        }
        //add everything from queue to list
        while (!queue.isEmpty())
            list.add(queue.poll().data);
        if (list.size() == 0) list.add(-1); //if list is empty then add -1
        return list;
    }
}