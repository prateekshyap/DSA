/*https://leetcode.com/problems/find-mode-in-binary-search-tree/*/

class Solution {
    int maxCount;
    int currCount;
    int currElem;
    List<Integer> list;
    Solution()
    {
        list = new ArrayList<Integer>();
        maxCount = 0;
        currCount = -1;
        currElem = Integer.MIN_VALUE;
    }
    public int[] findMode(TreeNode root) {
        Solution sol = new Solution();
        traverseInOrder(sol,root);

        //update the result in a similar way
        if (sol.currCount > sol.maxCount)
        {
            sol.maxCount = sol.currCount;
            sol.list.clear();
            sol.list.add(sol.currElem);
        }
        else if (sol.currCount == sol.maxCount)
        {
            sol.list.add(sol.currElem);
        }

        //convert and return
        int[] res = new int[sol.list.size()];
        int i = 0;
        for (Integer elem : sol.list)
            res[i++] = elem;
        return res;
    }
    public void traverseInOrder(Solution sol, TreeNode root) {
    	//if root is not null
        if (root != null)
        {
        	//recursion call for left subtree
            traverseInOrder(sol,root.left);

            //if it is the very first element
            if (sol.currCount == -1)
            {
            	//store it as the current element
                sol.currElem = root.val;

                //increase count to 1
                sol.currCount = 1;
            }

            //if it is not the first element
            else
            {
            	//if current element is equal to current node value
                if (sol.currElem == root.val)
                {
                	//increase the count
                    ++sol.currCount;
                }

                /*
                if current node value is different i.e.
                we cannot get the current element value anywhere else
                as per the property of BST
                */
                else
                {
                	//if current count is greater than or equal to max count
                    if (sol.currCount >= sol.maxCount)
                    {
                    	//if it is strictly greater
                        if (sol.currCount > sol.maxCount)
                        {
                        	//update the max count
                            sol.maxCount = sol.currCount;

                            //delete all previous elements
                            sol.list.clear();
                        }

                        //add the element to list
                        sol.list.add(sol.currElem);
                    }

                    //set current count to 1 for the next element
                    sol.currCount = 1;

                    //set the current node value to current element
                    sol.currElem = root.val;
                }
            }

            //recursion call for right subtree
            traverseInOrder(sol,root.right);
        }
    }
}