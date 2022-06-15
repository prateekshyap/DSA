/*https://binarysearch.com/problems/Longest-Tree-Sum-Path-From-Root-to-Leaf*/

import java.util.*;

// two dfs
// class Solution {
//     int result, maxLevel;
//     public int solve(Tree root) {
//         result = Integer.MIN_VALUE;
//         maxLevel = height(root);
//         findSum(root,1,0);
//         return result;
//     }
//     public void findSum(Tree root, int level, int sum)
//     {
//         if (root == null) return;
//         findSum(root.left, level+1, sum+root.val);
//         findSum(root.right, level+1, sum+root.val);
//         if (level == maxLevel)
//         {
//             result = Math.max(sum+root.val, result);
//         }
//     }
//     public int height(Tree root)
//     {
//         if (root == null) return 0;
//         int left = height(root.left);
//         int right = height(root.right);
//         return Math.max(left,right)+1;
//     }
// }

//single dfs
class Solution {
    int result, maxLevel;
    public int solve(Tree root) {
        result = Integer.MIN_VALUE;
        maxLevel = findSum(root,1,0);
        return result;
    }
    public int findSum(Tree root, int level, int sum)
    {
        if (root == null) return 0;
        int left = findSum(root.left, level+1, sum+root.val);
        int right = findSum(root.right, level+1, sum+root.val);
        if (level > maxLevel)
        {
            maxLevel = level;
            result = sum+root.val;
        }
        else if (level == maxLevel)
            result = Math.max(sum+root.val, result);
        return Math.max(left, right)+1;
    }
}