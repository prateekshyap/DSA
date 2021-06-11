/*https://leetcode.com/problems/insert-into-a-binary-search-tree/*/

class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
    	//if root is null
        if (root == null)
        {
        	//insert at root and return
            root = new TreeNode(val);
            return root;
        }

        //recursion call
        TreeNode treeRoot = insertNode(root, val);
        return treeRoot;
    }
    
    public TreeNode insertNode(TreeNode root, int val)
    {
    	//if value is less than root value and left subtree is null
        if (val < root.val && root.left == null)
        {
        	//insert at left and return
            root.left = new TreeNode(val);
            return root;
        }

        //if value is greater than root value and right subtree is null
        if (val > root.val && root.right == null)
        {
        	//insert at right and return
            root.right = new TreeNode(val);
            return root;
        }

        //if value is less than root value
        if (val < root.val)
        {
        	/*recursion*/
        	//insert in the left subtree and return
            insertNode(root.left,val);
            return root;
        }

        //insert in the right subtree and return
        insertNode(root.right,val);
        return root;
    }
}