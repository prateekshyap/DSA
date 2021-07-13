/*https://leetcode.com/problems/kth-smallest-element-in-a-bst/*/

//kth smallest
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

/*https://practice.geeksforgeeks.org/problems/kth-largest-element-in-bst/1*/

//kth largest
class Solution
{
    int count = 0;
    int res = -1;
    public int kthLargest(Node root,int K)
    {
        traverseInOrder(root,K);
        return res;
    }
    public void traverseInOrder(Node root, int k) {
        //if root is not null and result is not yet found
        if (root != null && res == -1)
        {
            //recursion call for right subtree
            traverseInOrder(root.right,k);

            //increase the visit count
            ++count;

            //if count becomes equal to k and result is -1
            if (count == k && res == -1)
            {
                //store the result and return
                res = root.data;
                return;
            }

            //recursion call for left subtree
            traverseInOrder(root.left,k);
        }

        //if result is found, return
        if (res != -1)
            return;
    }
}