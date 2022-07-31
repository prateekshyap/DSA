/*
https://leetcode.com/problems/path-sum-ii/
113. Path Sum II

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
    vector<vector<int>> ans;
    vector<vector<int>> pathSum(TreeNode* root, int targetSum) {
        
        solve(root, targetSum, {});
        return ans;    
    }
    
    void solve(TreeNode* root, int targetSum, vector<int> path)
    {
        if(!root) return;
        
        path.push_back(root->val);
        targetSum -= root->val;
        
        if(!root->left and !root->right )
        {   
            if(targetSum==0)
                ans.push_back(path);
            path.pop_back();
            return;
        }
        
        solve(root->left, targetSum, path);
        solve(root->right, targetSum, path);
        
        path.pop_back();
    }
};