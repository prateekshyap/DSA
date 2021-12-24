/*https://practice.geeksforgeeks.org/problems/right-view-of-binary-tree/1*/

//level order traversal approach
class Solution
{
    ArrayList<Integer> rightView(Node root) 
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

            //discard all nodes in current level except the last one, but add their children to queue
            for (int i = 0; i < len-1; ++i)
            {
                Node discard = queue.remove();
                if (discard.left != null) queue.add(discard.left);
                if (discard.right != null) queue.add(discard.right);
            }

            //remove the rightmost node of current level
            Node rightMost = queue.remove();

            //decrease number of nodes by 1
            --len;

            //if the right most node is not null
            if (rightMost != null) 
            { 
            	//add it to the list
                list.add(rightMost.data);

                //add its children to the queue
                if (rightMost.left != null) queue.add(rightMost.left);
                if (rightMost.right != null) queue.add(rightMost.right);   
            }
        }

        return list;
    }
}