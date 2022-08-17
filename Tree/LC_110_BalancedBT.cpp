/*
https://leetcode.com/problems/balanced-binary-tree/
110. Balanced Binary Tree

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
    bool isBalanced(TreeNode* root) {
        if(!root)
            return true;
        if(!root->left and !root->right)
            return true;
        
        return (height(root) != -1);
    }
    
    int height(TreeNode* root)
    {
        if(!root)
            return 0;
        if(!root->left and !root->right)
            return 1;
        int lht = height(root->left);
            if(lht == -1)return -1;
        int rht = height(root->right);
            if(rht == -1) return -1;
        
        if(abs(lht-rht) > 1)
            return -1;
            
        return max(lht, rht)+1;
    }
    
    
};