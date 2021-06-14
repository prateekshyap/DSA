/*https://leetcode.com/problems/construct-string-from-binary-tree/*/

class Solution {
    StringBuilder sb;
    public String tree2str(TreeNode root) {
        sb = new StringBuilder("");
        preOrder(root);
        return new String(sb).substring(1,sb.length()-1);
    }
    public void preOrder(TreeNode root) {
    	//mandatory left bracket and value attachment
        sb.append("(");
        sb.append(root.val);
        
        //if both the children are null, ignore
        if (root.left == null && root.right == null)
        {}

        //if left child is null, one extra pair of brackets is needed to indicate that
        else if (root.left == null)
        {
            sb.append("()");

            /*recursion for right child*/
            preOrder(root.right);
        }

        //if right child is null, no need to indicate anything
        else if (root.right == null)
        {
            /*recursion for left child*/
            preOrder(root.left);
        }

        //if both the children
        else 
        {
            /*recursion*/
            preOrder(root.left);
            preOrder(root.right);
        }
        sb.append(")");
    }
}