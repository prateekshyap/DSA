/*
https://leetcode.com/problems/path-sum-iii/
437. Path Sum III
https://practice.geeksforgeeks.org/problems/k-sum-paths/1
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
    typedef long ll;
    unordered_map<ll, ll> um;
    ll ans=0;
    int ts=0;
    void count(TreeNode* root, ll csum)
    {
        if(!root)
            return;
        csum += root->val;
        
        ll rem = csum - ts;
        if(um.find(rem) != um.end())
            ans+= um[rem];
        
        um[csum]++;
        count(root->left, csum);
        count(root->right, csum);
        um[csum]--;
    }
    
    int pathSum(TreeNode* root, int targetSum) {
        if(!root)
            return 0;
        // return solve(root, targetSum) + pathSum(root->left, targetSum) + pathSum(root->right, targetSum);  
        
        ts = targetSum;
        um[0] = 1;
        count(root, 0);
        return ans;
    }
    
    long solve(TreeNode* root, long ts)
    {
        if(!root) return 0;
        
        long cnt=0;
        if(ts == root->val)
            cnt++;
        ts-=root->val;
       return cnt+solve(root->left, ts) + solve(root->right, ts);
    }
    
};