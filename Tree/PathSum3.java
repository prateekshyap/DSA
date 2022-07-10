/*https://leetcode.com/problems/path-sum-iii/*/

class Solution {
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null)
            return 0;
        return get(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    public int get(TreeNode root, int target)
    {
        if (root == null)
            return 0;
        int result = 0;
        if (root.val == target)
            ++result;
        return result+get(root.left,target-root.val)+get(root.right,target-root.val);
    }
}

/*https://practice.geeksforgeeks.org/problems/k-sum-paths/1/*/

class Solution
{
    static int count = 0;
    public void dfs(Node root,int k,Map<Integer,Integer> mp,int sum){
        if (root == null) return;
        sum += root.data;
        if (map.containsKey(sum-k))
        {
            int n = map.get(sum-k);
            count+=n;
        }
        map.put(sum,map.getOrDefault(sum,0)+1);
        dfs(root.left,k,map,sum);
        dfs(root.right,k,map,sum);
        map.put(sum,map.get(sum)-1);  
    }
    public int sumK(Node root, int k)
    {
        count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        dfs(root,k,map,0);
        return count;
    }
}