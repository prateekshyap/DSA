/*https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1*/

//using queue
class Tree
{
    public ArrayList<Integer> diagonal(Node root)
    {
        if (root == null) return new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        Node temp = root;

        //traverse till the first node having left child, keep adding the data
        while (temp != null && temp.left == null)
        {
            list.add(temp.data);
            temp = temp.right;
        }

        //traverse till the end, keep adding the nodes having left child to the queue
        while (temp != null)
        {
            list.add(temp.data);
            if (temp.left != null)
                queue.add(temp);
            temp = temp.right;
        }

        //till the queue has more elements
        while (!queue.isEmpty())
        {
        	//pick one node from queue and move to its left
            temp = queue.remove();
            temp = temp.left;

            //do the same as other nodes
            while (temp != null)
            {
                list.add(temp.data);
                if (temp.left != null)
                    queue.add(temp);
                temp = temp.right;
            }
        }
        return list;
    }
}
