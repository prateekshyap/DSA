/*https://practice.geeksforgeeks.org/problems/reverse-level-order-traversal/1*/

class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        // code here
        ArrayList<ArrayList<Integer>> levelOrder = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> result = new ArrayList<Integer>(), currList = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        int len = -1, i = -1;
        Node currNode = null;
        queue.add(node);
        while (!queue.isEmpty())
        {
            len = queue.size();
            currList = new ArrayList<Integer>();
            for (i = 0; i < len; ++i)
            {
                currNode = queue.poll();
                currList.add(currNode.data);
                if (currNode.left != null) queue.add(currNode.left);
                if (currNode.right != null) queue.add(currNode.right);
            }
            levelOrder.add(currList);
        }
        for (i = levelOrder.size()-1; i >= 0; --i)
        {
            currList = (ArrayList)levelOrder.get(i);
            for (Integer elem : currList) result.add(elem);
        }
        return result;
    }
}