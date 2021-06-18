/*https://practice.geeksforgeeks.org/problems/largest-bst/1*/

class Solution{
    static int largestBst(Node root)
    {
        int[] res = largestBSTUtil(root);
        return res[0];
    }
    static int[] largestBSTUtil(Node root)
    {
    	/*
			the array which are being returned, contain
			at 0 index - subtree size
			at 1 index - minimum value of the subtree
			at 2 index - maximum value of the subtree
    	*/
    	int[] retArr = new int[3];
        retArr[1] = retArr[2] = -1;
        
        //if root is null, subtree size is 0
        if (root == null)
            return retArr;

        //if root is leaf, subtree size is 1 and min and max will be root itself
        if (root.left == null && root.right == null)
        {
            retArr[0] = 1;
            retArr[1] = root.data;
            retArr[2] = root.data;
            return retArr;
        }

        /*recursion*/
        int[] left = largestBSTUtil(root.left);
        int[] right = largestBSTUtil(root.right);
        
        //subtree size will be the sum
        retArr[0] = left[0]+right[0]+1;

        //if BST property is retained
        if (((left[0] != 0 && left[1] != -1 && left[2] != -1 && left[2] < root.data) || (left[0] == 0 && left[1] == -1 && left[2] == -1)) && ((right[0] != 0 && right[1] != -1 && right[2] != -1 && right[1] > root.data) || (right[0] == 0 && right[1] == -1 && right[2] == -1)))
        {
        	//store the new min and max and return
            retArr[1] = left[0] == 0 ? root.data : left[1];
            retArr[2] = right[0] == 0 ? root.data : right[2];
            return retArr;
        }

        //if BST property is not retained, then subtree size will be max of both BST size
        retArr[0] = Math.max(left[0],right[0]);
        return retArr;
    }
}