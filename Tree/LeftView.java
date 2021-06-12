/*https://practice.geeksforgeeks.org/problems/left-view-of-binary-tree/1*/

//level order traversal approach
class Tree
{
    ArrayList<Integer> leftView(Node root)
    {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();

        //add root to queue
        queue.add(root);

        //till queue has more nodes
        while (!queue.isEmpty())
        {
        	//find the number of nodes in current level
            int len = queue.size();

            //remove the leftmost node of current level
            Node leftMost = queue.remove();

            //decrease number of nodes by 1
            --len;

            //if the left most node is not null
            if (leftMost != null) 
            { 
            	//add it to the list
                list.add(leftMost.data);

                //add its children to the queue
                if (leftMost.left != null) queue.add(leftMost.left);
                if (leftMost.right != null) queue.add(leftMost.right);
            }

            //discard all nodes in current level, but add their children to queue
            for (int i = 0; i < len; ++i)
            {
                Node discard = queue.remove();
                if (discard.left != null) queue.add(discard.left);
                if (discard.right != null) queue.add(discard.right);
            }
        }
        
        return list;
    }
}