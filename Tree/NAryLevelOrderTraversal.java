/*https://leetcode.com/problems/n-ary-tree-level-order-traversal/*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        //edge case
        if (root == null) return new ArrayList<List<Integer>>();

        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Queue<Node> queue = new LinkedList<>();
        
        //add root to queue
        queue.add(root);

        //till queue is not empty
        while (!queue.isEmpty())
        {
            //find the current level size
            int len = queue.size();

            List<Integer> temp = new ArrayList<Integer>();
            
            //for every element
            for (int i = 0; i < len; ++i)
            {
                //remove from queue
                Node node = queue.remove();

                //add all its children to queue
                for (int j = 0; j < node.children.size(); ++j)
                    queue.add(node.children.get(j));

                //add removed node to temporary list
                temp.add(node.val);
            }

            //add temporary list to result
            list.add(temp);
        }
        
        return list;
    }
}