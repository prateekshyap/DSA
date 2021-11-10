/*https://leetcode.com/problems/binary-search-tree-iterator/*/

class BSTIterator {
    TreeNode pointer, tree;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        pointer = null;
        tree = root;
        stack = new Stack<TreeNode>();
        while (tree != null)
        {
            stack.push(tree);
            tree = tree.left;
        }
    }
    
    public int next() {
        tree = stack.pop();
        int returnVal = tree.val;
        tree = tree.right;
        while (tree != null)
        {
            stack.push(tree);
            tree = tree.left;
        }
        return returnVal;
    }
    
    public boolean hasNext() {
        if (stack.isEmpty()) return false;
        return true;
    }
}