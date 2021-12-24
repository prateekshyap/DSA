/*https://leetcode.com/problems/n-ary-tree-postorder-traversal/*/

class Solution {
    List<Integer> list;

    Solution() {
        list = new ArrayList<Integer>();
    }

    public List<Integer> postorder(Node root) {
        Solution sol = new Solution();
        sol.traversePostOrder(root);
        return sol.list;
    }

    public void traversePostOrder(Node root)
    {
    	//if root is not null
        if (root != null)
        {
        	//traverse all children
            for (int i = 0; i < root.children.size(); ++i)
                traversePostOrder(root.children.get(i));
            
            //add the current value
            list.add(root.val);
        }
    }
}