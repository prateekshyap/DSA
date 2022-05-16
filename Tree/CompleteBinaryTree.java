/*https://practice.geeksforgeeks.org/problems/complete-binary-tree/1*/

class GfG
{
	boolean isCompleteBT(Node root)
    {
        //add code here.
        int exp = 1, len, i;
        Queue<Node> queue = new LinkedList<Node>();
        Node node;        

        queue.add(root);
        boolean broke = false;
        boolean lastLevel = false;
        while (!queue.isEmpty())
        {
            broke = false;
            len = queue.size();
            for (i = 0; i < len; ++i)
            {
                node = queue.poll();
                if (node.left != null && (broke || lastLevel)) return false;
                else if (node.left != null) queue.add(node.left);
                else if (node.left == null) broke = true;
                if (node.right != null && (broke || lastLevel)) return false;
                else if (node.right != null) queue.add(node.right);
                else if (node.right == null) broke = true;
            }
            if (broke && queue.size() == 0) return true;
            else if (broke) lastLevel = true;
            exp <<= 1;
        }
        
        return true;
	} 
}