/*
https://leetcode.com/problems/diameter-of-binary-tree/
543. Diameter of Binary Tree

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
    
    
    int diameterOfBinaryTree(TreeNode* root) {
        int mxdepth=0;
        checkDepth(root, mxdepth);
        return mxdepth;
    }
    
    int checkDepth(TreeNode* root, int& mxdepth)
    {
        if(!root)
            return 0;
        
        int ld = checkDepth(root->left, mxdepth);
        int rd = checkDepth(root->right, mxdepth);
        
        if(ld+rd > mxdepth)
            mxdepth = ld+rd;
        
        return 1+max(ld,rd);
    }
    
};