/*https://leetcode.com/problems/count-good-nodes-in-binary-tree/*/

class Solution {
    int count;
    Stack<Integer> stack;
    public int goodNodes(TreeNode root) {
        count = 1;
        stack = new Stack<Integer>();
        traverse(root);
        return count;
    }
    void traverse(TreeNode root)
    {
        if (root == null) return;
        if (stack.isEmpty())
        {
            stack.push(root.val);
            traverse(root.left);
            traverse(root.right);
            stack.pop();
        }
        else
        {
            if (root.val >= stack.peek())
                ++count;
            if (stack.peek() < root.val)
            {
                stack.push(root.val);
                traverse(root.left);
                traverse(root.right);
                stack.pop();
            }
            else
            {
                traverse(root.left);
                traverse(root.right);
            }
        }
    }
}