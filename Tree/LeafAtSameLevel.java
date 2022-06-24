/*https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1*/
/*https://binarysearch.com/problems/Leaves-in-Same-Level*/

class Solution
{
    boolean result;
    int prevLevel;
    boolean check(Node root)
    {
	    // Your code here
	    result = true;
	    prevLevel = -1;
	    recur(root, 0);
	    return result;
    }
    void recur(Node root, int levelCounter)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            if (prevLevel != -1 && prevLevel != levelCounter) result = false;
            prevLevel = levelCounter;
        }
        recur(root.left,levelCounter+1);
        recur(root.right,levelCounter+1);
    }
}