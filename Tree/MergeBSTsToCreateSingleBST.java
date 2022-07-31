/*https://leetcode.com/problems/merge-bsts-to-create-single-bst/*/

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
    int size, expSize;
    public TreeNode canMerge(List<TreeNode> trees) {
        size = 0;
        int n = (int)5e4;

        //arrays of maximum size
        TreeNode[] roots = new TreeNode[n+1]; //stores root nodes
        TreeNode[] leaves = new TreeNode[n+1]; //stores leaf nodes
        int[] parents = new int[n+1]; //stores parent values
        HashSet<Integer> set = new HashSet<Integer>(); //for counting the final tree size
        int rootCount = 0;
        TreeNode root = null;
        for (TreeNode tree : trees) //for each given tree
        {
            roots[tree.val] = tree; //store the root in roots
            ++rootCount; //increment root count
            set.add(tree.val); //add value to set
            if (tree.left != null) //if left child is present
            {
                set.add(tree.left.val); //add value to set
                leaves[tree.left.val] = tree.left; //store the child in leaves
                parents[tree.left.val] = tree.val; //store the value of parent
            }
            if (tree.right != null) //if right child is present
            {
                set.add(tree.right.val); //add value to set
                leaves[tree.right.val] = tree.right; //store the child in leaves
                parents[tree.right.val] = tree.val; //store the value of parent
            }
        }
        if (rootCount == 1) //if there is only one root
        {
            root = trees.get(0); //get the root
            return isValidBST(root) ? root : null; //return if it is a BST
        }
        expSize = set.size(); //get the expected number of nodes of the final tree
        int index = 0;
        while (index <= n && roots[index] == null) ++index; //move till a valid root node
        boolean gotRoot = false;
        while (index <= n) //till we process all root nodes
        {
            if (leaves[index] == null && gotRoot) return null; //if leaf is not present and we have already found out the root of the final tree, return null
            else if (leaves[index] == null) //if leaf is null
            {
                gotRoot = true; //mark the current node as the tree of the root
                root = roots[index]; //store the root of the tree in root
                ++index; //increment index
                while (index <= n && roots[index] == null) ++index; //move till the next valid root node
                continue;
            }
            int parent = parents[index]; //get the parent of the current node value
            //merge the tree correctly
            if (roots[parent].left == leaves[index]) roots[parent].left = roots[index];
            else if (roots[parent].right == leaves[index]) roots[parent].right = roots[index];
            leaves[index] = null; //mark the leaf as null since it is no more a leaf node, no need to mark root as null since we are processing roots sequentially
            ++index; //increment index
            while (index <= n && roots[index] == null) ++index; //move till the next valid root node
        }
        return isValidBST(root) && size == expSize ? root : null; //return if the final tree is a valid BST of expected size
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    private boolean helper(TreeNode root, long min, long max){
        if(root == null) return true;
        ++size;
        boolean isLeftValid = helper(root.left, min, root.val);
        boolean isRightValid = helper(root.right, root.val, max);
        return root.val < max && root.val > min && isLeftValid && isRightValid;
    }
}