/*https://practice.geeksforgeeks.org/problems/odd-even-level-difference/1*/

class Solution
{
	int getLevelDiff(Node root)
	{
	    //code here
	    Node currNode;
	    Queue<Node> queue = new LinkedList<Node>();
	    queue.add(root);
	    boolean level = true;
	    int oddSum = 0, evenSum = 0, len, i;
	    while (!queue.isEmpty())
	    {
	        len = queue.size();
	        for (i = 0; i < len; ++i)
	        {
	            currNode = queue.poll();
	            if (level) oddSum += currNode.data;
	            else evenSum += currNode.data;
	            if (currNode.left != null) queue.add(currNode.left);
	            if (currNode.right != null) queue.add(currNode.right);
	        }
	        level = !level;
	    }
	    return oddSum-evenSum;
	}
}
