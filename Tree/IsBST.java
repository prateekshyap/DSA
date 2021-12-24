/*https://leetcode.com/problems/validate-binary-search-tree/*/

/*the idea is to store only two consecutive inorder elements at a time*/

class Solution {
    int[] arr;
    int curr;
    boolean result;
    Solution() {
        arr = new int[2];
        curr = 0;
        result = true;
    }
    public boolean isValidBST(TreeNode root) {
        Solution sol = new Solution();
        traverseInOrder(sol,root);
        return sol.result;
    }
    public void traverseInOrder(Solution sol, TreeNode root) {
    	//if root is not null and the tree is still a BST
        if (root != null && sol.result == true)
        {
        	//recursion for left subtree
            traverseInOrder(sol,root.left);

            //move the 2nd element to 1st and store the next element in 2nd
            sol.arr[0] = sol.arr[1];
            sol.arr[1] = root.val;

            //if it is the first node in inorder traversal
            if (sol.curr == 0)
            {
            	//do nothing and indicate it in curr
                sol.curr = -1;
            }

            //if curr is not 0 i.e. the current node is not the first node
            //and the order is not increasing
            else if (sol.arr[1] <= sol.arr[0])
            {
            	//indicate that it is not a BST
                sol.result = false;

                //return
                return;
            }

            //recursion for right subtree
            traverseInOrder(sol,root.right);
        }

        //at any point if result is false, return
        if (sol.result == false) return;
    }
}