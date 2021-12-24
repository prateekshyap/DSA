/*https://leetcode.com/problems/path-sum-ii/*/

class Solution
{
    List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)
    {
        result = new ArrayList<List<Integer>>();
        List<Integer> currList = new ArrayList<Integer>();
        traversePreOrder(root,0,targetSum,currList);
        return result;
    }
    
    void traversePreOrder(TreeNode root, int sum, int targetSum, List<Integer> currList)
    {
        if (root != null)
        {
            if (root.left == null && root.right == null)
            {
                if (sum+root.val == targetSum)
                {
                    List<Integer> temp = new ArrayList<Integer>();
                    for (Integer elem : currList)
                        temp.add(elem);
                    temp.add(root.val);
                    result.add(temp);
                }
                return;
            }
            currList.add(root.val);
            traversePreOrder(root.left,sum+root.val,targetSum,currList);
            traversePreOrder(root.right,sum+root.val,targetSum,currList);
            currList.remove(currList.size()-1);
        }
    }
}