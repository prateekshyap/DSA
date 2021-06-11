/*https://leetcode.com/problems/cousins-in-binary-tree/*/

//a level order traversal solution
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> queue = new LinkedList<>();

        //add root to queue
        queue.add(root);

        //till queue has elements
        while (!queue.isEmpty())
        {
        	//get the current level size
            int len = queue.size();

            boolean flag = false;

            //for every element in current level
            for (int i = 0; i < len; ++i)
            {
                //remove from queue
                TreeNode node = queue.remove();

                //add its children to queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                //if it has two children and x and y are its children, then return false as they are siblings
                if (node.left != null && node.right != null && ((node.left.val == x && node.right.val == y) || (node.left.val == y && node.right.val == x)))
                    return false;

                //if current node value is either x or y and flag is false, indicate that we found one node
                if ((node.val == x || node.val == y) && flag == false)
                    flag = true;

                //if flag is true then we found the other node also, hence return true
                else if ((node.val == x || node.val == y) && flag == true)
                    return true;
            }
        }

        return false;
    }
}