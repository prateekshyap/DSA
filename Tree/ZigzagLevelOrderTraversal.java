/*https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/*/

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	//edge case
        if (root == null) return new ArrayList<List<Integer>>();
        
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        //add root to queue
        queue.add(root);

        //flag indicates the direction
        boolean flag = true;

        //till queue is not empty
        while (!queue.isEmpty())
        {
        	//find the current level size
            int len = queue.size();

            List<Integer> temp = new ArrayList<Integer>();
            
            //for every element in the current level
            for (int i = 0; i < len; ++i)
            {
            	//remove from queue
                TreeNode node = queue.remove();

                //add its children to queue
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);

                //add removed node to temporary list
                temp.add(node.val);
            }

            //if flag is true, alter it
            if (flag)
            {
                flag = false;
            }

            //otherwise reverse the elements in temporary list and alter the flag
            else
            {
                ArrayList<Integer> tempNew = new ArrayList<Integer>();
                for (int i = temp.size()-1; i >= 0; --i)
                    tempNew.add((Integer)temp.get(i));
                temp = tempNew;
                flag = true;
            }

            //add temporary list to result
            list.add(temp);
        }
        
        return list;
    }
}