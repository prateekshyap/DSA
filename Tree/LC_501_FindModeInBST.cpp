/*
https://leetcode.com/problems/find-mode-in-binary-search-tree/
501. Find Mode in Binary Search Tree

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
    int mx=-2;
    unordered_map<int,int> mp;
    void solve(TreeNode* root)
    {
        if(!root)
            return;
        
        mp[root->val]++;
        solve(root->left);
        solve(root->right);
        if(mp[root->val]>=mx)
            mx = mp[root->val];
    }
    
    vector<int> findMode_1(TreeNode* root) {
        if(!root)
            return {};

        vector<int> ans;
        
        solve(root);
        
        
        for(auto x: mp)
        {
            // cout<<x.first<<" "<<x.second<<endl;
            if(x.second == mx)
                ans.push_back(x.first);
        }
        return ans;
        
    }
    
    int mxcnt =-1;
    int cnt = 0;
    int prev = INT_MAX;
    vector<int> res;
    
    void inorder(TreeNode* root)
    {
        if(!root)
            return;
        inorder(root->left);
        
        if(root->val == prev)
            cnt++;
        else
            cnt=1;
        
        prev = root->val;
        
        if(cnt > mxcnt)
        {
            res.clear();
            res.push_back(root->val);
            mxcnt = cnt;
        }
        else if(cnt == mxcnt)
            res.push_back(root->val);
        
        inorder(root->right);
    }
    vector<int> findMode(TreeNode* root) {
        if(!root)
            return {};

        inorder(root);
        
        return res;
        
    }
    
};