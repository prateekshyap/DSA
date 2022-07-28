/*https://practice.geeksforgeeks.org/problems/construct-tree-1/1/*/
/*https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/*/

/*
* is = start index of inorder sequence
* ie = end index of inorder sequence
* ps = start index of preorder sequence
* pe = end index of preorder sequence
*/

class Solution
{
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        Node root = build(inorder,preorder,0,n-1,0,n-1);
        return root;
    }
    public static Node build(int[] in, int[] pre, int is, int ie, int ps, int pe)
    {
    	//base case
        if (is > ie) return null;

        //build the node with the first value present at the current preorder sequence
        //since it is the root value
        Node node = new Node(pre[ps]);

        //if there is just one node in the sequence, return the node
        if (is == ie) return node;

        //otherwise
        int currIn = 0;

        //find the index of the current node in the inorder sequence
        for (int i = is; i <= ie; ++i)
            if (in[i] == pre[ps])
            {
                currIn = i;
                break;
            }

        /*recursion*/

        //build the left and right subtrees by adjusting the start and end indices properly
        node.left = build(in,pre,is,currIn-1,ps+1,ps-is+currIn);
        node.right = build(in,pre,currIn+1,ie,pe-ie+currIn+1,pe);

        //return the subtree
        return node;
    }
}

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
     // leetcode 1008, https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
    static int index = 0;
    private TreeNode constructBST_Pre(int[] pre, int leftRange, int rightRange)
    {
        if (index >= pre.length || pre[index] < leftRange || pre[index] > rightRange) return null;

        int val = pre[index++];
        TreeNode root = new TreeNode(val);
        root.left = constructBST_Pre(pre, leftRange, val);
        root.right = constructBST_Pre(pre, val, rightRange);
        return root;
    }

    public TreeNode bstFromPreorder(int[] pre) {
        index = 0;
        return constructBST_Pre(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
   
}