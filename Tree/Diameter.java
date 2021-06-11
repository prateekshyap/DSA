/*https://practice.geeksforgeeks.org/problems/diameter-of-binary-tree/1*/

class Solution {
    int maxDepth = 0;
    int diameter(Node root) {
        maxDepth = 0;
        checkDepth(root);
        return maxDepth-1; //return maxDepth for gfg submission
    }
    int checkDepth(Node root)
    {
    	//base case
        if (root == null)
            return 0;

        //find the depth of left and right subtrees
        int leftSubtreeDepth = checkDepth(root.left);
        int rightSubtreeDepth = checkDepth(root.right);

        //if the path length is greater than maximum length, update it
        if (leftSubtreeDepth+rightSubtreeDepth+1 > maxDepth)
            maxDepth = leftSubtreeDepth+rightSubtreeDepth+1;

        //return the maximum of two depths
        return leftSubtreeDepth > rightSubtreeDepth ? leftSubtreeDepth+1 : rightSubtreeDepth+1;
    }
}