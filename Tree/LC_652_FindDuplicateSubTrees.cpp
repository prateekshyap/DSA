/*
https://leetcode.com/problems/find-duplicate-subtrees/
652. Find Duplicate Subtrees

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
    vector<TreeNode*> ans;
    unordered_map<string, int> um;
    vector<TreeNode*> findDuplicateSubtrees(TreeNode* root) {
        // /*
        getall(root);
        // for(auto x: um)
        // {
        //     cout<<x.first<<" "<<x.second<<endl;
        // }
        return ans;
        // */
        // serialize(root);
        // for(auto x: um)
        // {
        //     cout<<x.first<<" "<<x.second<<endl;
        // }
        return ans;
    }
    
    string serialize(TreeNode* node)
    {
        if(!node)
            return "";
        string s = "("+ serialize(node->left) + to_string(node->val) + serialize(node->right) +")";
        um[s]++;
        if(um[s]==2)
            ans.push_back(node);
        return s;
    }
    
    // /*
    string getall(TreeNode* root)
    {
        if(!root)
            return "";
        
        string ls = getall(root->left);
        string rs = getall(root->right);
        string s = ls+"L"+rs+"R"+to_string(root->val);
        
        if(um[s] == 1)
            ans.push_back(root);
        
        um[s]++;
        
        return s;
    }
    // */
};