/*https://leetcode.com/problems/kth-smallest-element-in-a-bst/*/

class Solution {
    int count;
    int res;
    Solution()
    {
        count = 0;
        res = -1;
    }
    public int kthSmallest(TreeNode root, int k) {
        Solution sol = new Solution();
        traverseInOrder(sol,root,k);
        return sol.res;
    }
    public void traverseInOrder(Solution sol,TreeNode root, int k) {
    	//if root is not null and result is not yet found
        if (root != null && sol.res == -1)
        {
        	//recursion call for left subtree
            traverseInOrder(sol,root.left,k);

            //increase the visit count
            ++sol.count;

            //if count becomes equal to k and result is -1
            if (sol.count == k && sol.res == -1)
            {
            	//store the result and return
                sol.res = root.val;
                return;
            }

            //recursion call for right subtree
            traverseInOrder(sol,root.right,k);
        }

        //if result is found, return
        if (sol.res != -1)
            return;
    }
}