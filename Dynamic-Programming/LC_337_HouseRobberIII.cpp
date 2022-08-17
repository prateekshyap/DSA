/*
https://leetcode.com/problems/house-robber-iii/
337. House Robber III

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
    int rob(TreeNode* root) {
        if(!root)
            return 0;
        if(!root->left && !root->right)
            return root->val;
        
        // auto [curr, last]  = solve(root);
        // return curr;
        return solve(root).first;
    }
    
    pair<int,int> solve(TreeNode* root)
    {
        if(root == nullptr)
            return {0, 0};
        if(!root->left && !root->right) // if leaf node then {max of last node, max of second last node}
            return {root->val, 0};
        
        auto [last_left, seclast_left] = solve(root->left);
        auto [last_right, seclast_right] = solve(root->right);
        
        int curr = root->val + seclast_left + seclast_right;
        int last = last_left + last_right;
        return {max(curr, last), last};
    }
};