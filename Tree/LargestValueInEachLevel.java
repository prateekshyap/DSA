/*https://practice.geeksforgeeks.org/problems/largest-value-in-each-level/1*/

class Solution
{
    public ArrayList<Integer> largestValues(Node root)
    {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        int max = Integer.MIN_VALUE, len = -1, i = -1;
        Node curr = null;
        
        while (!queue.isEmpty())
        {
            len = queue.size();
            max = Integer.MIN_VALUE;
            for (i = 0; i < len; ++i)
            {
                curr = queue.poll();
                max = Math.max(max,curr.data);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            }
            result.add(max);
        }
        
        return result;
    }
}