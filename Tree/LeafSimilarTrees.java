/*https://leetcode.com/problems/leaf-similar-trees/*/

class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> l=new ArrayList<Integer>();
        ArrayList<Integer> l1=new ArrayList<Integer>();

        traverse(root1,l);
        traverse(root2,l1);

        //l1==l2 similar 
        if(l.equals(l1))
            return true;

        return false;
    }
    //post order traversal
    public static void traverse(TreeNode root,ArrayList<Integer> l){
        if(root==null)
            return;

        traverse(root.left,l);
        traverse(root.right,l);

        if(root.left == null && root.right == null)
            l.add(root.val);
    }
}