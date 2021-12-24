/*https://leetcode.com/problems/binary-tree-level-order-traversal/*/

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //edge case
        if (root == null) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //add root to queue
        queue.add(root);

        //till queue is not empty
        while (!queue.isEmpty())
        {
            //find the current level size
            int len = queue.size();

            List<Integer> temp = new ArrayList<Integer>();
            
            //for each element in current level
            for (int i = 0; i < len; ++i)
            {
                //remove from queue
                TreeNode node = queue.remove();

                //add its children to the queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                //add removed node to the temporary list
                temp.add(node.val);
            }

            //add the temporary list to result
            list.add(temp);
        }
        
        return list;
    }
}