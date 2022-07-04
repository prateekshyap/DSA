/*https://practice.geeksforgeeks.org/problems/largest-subtree-sum-in-a-tree/1/*/

class Solution {
    static int max;
    public static int findLargestSubtreeSum(Node root) {
        // code here
        max = Integer.MIN_VALUE;
        int curr = findSubtreeSum(root);
        if (curr > max) max = curr;
        return max;
    }
    public static int findSubtreeSum(Node root)
    {
        if (root == null) return 0;
        
        int left = findSubtreeSum(root.left);
        int right = findSubtreeSum(root.right);
        
        if (left+right+root.data > max) max = left+right+root.data;
        return left+right+root.data;
    }
}