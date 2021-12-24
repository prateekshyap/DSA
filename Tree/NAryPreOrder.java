/*https://leetcode.com/problems/n-ary-tree-preorder-traversal/*/

class Solution {
    List<Integer> list;

    Solution() {
        list = new ArrayList<Integer>();
    }
    
    public List<Integer> preorder(Node root) {
        Solution sol = new Solution();
        sol.traversePreOrder(root);
        return sol.list;
    }
    
    public void traversePreOrder(Node root) {
    	//if root is not null
        if (root != null)
        {
        	//add the current value
            list.add(root.val);

            //traverse all children
            for (int i = 0; i < root.children.size(); ++i)
                traversePreOrder(root.children.get(i));
        }
    }
}