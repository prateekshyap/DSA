/*https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/*/

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
    int count;
    int[] hash;
    public int pseudoPalindromicPaths (TreeNode root) {
        count = 0;
        hash = new int[10];
        solve(root);
        return count;
    }
    private void solve(TreeNode root)
    {
        if (root == null) return;
        if (root.left == null && root.right == null)
        {
            ++hash[root.val];
            int oddCount = 0;
            for (int val : hash)
                if (val%2 == 1)
                    ++oddCount;
            if (oddCount <= 1) ++count;
            --hash[root.val];
            return;
        }
        ++hash[root.val];
        solve(root.left);
        solve(root.right);
        --hash[root.val];
    }
}

class Solution {
    int count = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        findPaths(root, 0);
        return count;
    }
    
    public void findPaths(TreeNode node, int oddeven)
    {
        if(node == null)
            return;
        
        oddeven = oddeven ^ (1 << node.val);
        // leaf nodes
        if(node.left == null && node.right == null)
        {
            // only one set bit/ odd count
            if((oddeven & (oddeven-1)) == 0)
                count++;
            return;
        }
    
        findPaths(node.left, oddeven);
        findPaths(node.right, oddeven);
    }
    
    // using oddeven int to store odd/even presence instead of another function since only 1-9 nums present and we dont need count but odd/even only
//     private boolean isPseudoPalindromic(List<TreeNode> nodes)
//     {
//         boolean foundOdd = false;
//         // values are from 0-9 given so noneed of hashmap
//         int[] freq = new int[10];
        
//         for(TreeNode node : nodes)
//             freq[node.val]++;
        
//         for(int i=0; i<freq.length; i++){
//             if(freq[i] % 2 == 1){
//                 if(foundOdd)
//                     return false;
//                 foundOdd = true;
//             }
//         }
//         return true;
//     }
}