/*
https://leetcode.com/problems/maximum-depth-of-binary-tree/
104. Maximum Depth of Binary Tree
https://practice.geeksforgeeks.org/problems/height-of-binary-tree/1/#
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    int maxDepth(TreeNode* root) {
        
        if(!root) return 0;
        
        if(!root->left && !root->right) 
            return 1;  // As We have to Count number of nodes along the path
        
        else{ 
            int l = maxDepth(root->left);  // Left Subtree Height
            int r = maxDepth(root->right);  // Right Subtree Height
            
            return max(l+1, r+1);
        }
        
    }//end
};