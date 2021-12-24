/*https://leetcode.com/problems/unique-binary-search-trees-ii/*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
         return createPairs(1,n);
    }
    public List<TreeNode> createPairs(int start,int end)
    {
        List<TreeNode> result = new ArrayList<TreeNode>();
        
        for (int i = start; i <= end; ++i)
        {
            List<TreeNode> rightPairs = null;
            List<TreeNode> leftPairs = null;
            if (start == end)
            {
                TreeNode res = new TreeNode(i);
                result.add(res);
                return result;
            }
            if (i == start)
                rightPairs = createPairs(i+1,end);
            if (i == end)
                leftPairs = createPairs(start,i-1);
            if (i != start && i != end)
            {
                 rightPairs = createPairs(i+1,end);
                 leftPairs = createPairs(start,i-1);
            }
            
            if (rightPairs != null && leftPairs == null)
            {
                for (TreeNode r : rightPairs)
                {
                    TreeNode res = new TreeNode(i);
                    res.right = r;
                    result.add(res);
                }
                continue;
            }
            if (leftPairs != null && rightPairs == null)
            {    
                for (TreeNode l : leftPairs)
                {
                    TreeNode res= new TreeNode(i);
                    res.left=l;
                    result.add(res);
                }
                continue;
            }
            if (leftPairs != null && rightPairs != null)
            {
                for (TreeNode l : leftPairs)
                {
                    for (TreeNode r : rightPairs)
                    {
                        TreeNode res = new TreeNode(i);
                        res.left = l;
                        res.right = r;
                        result.add(res);
                    }
                }
                continue;
            } 
        }
        return result;
    }
}