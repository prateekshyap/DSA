/*
https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
1161. Maximum Level Sum of a Binary Tree

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
    
    int maxLevelSum(TreeNode* root) {
        int l=0, mxsum = INT_MIN, level=0;
        queue<TreeNode*> q; q.push(root);
        while(!q.empty())
        {
            int sz = q.size();
            l++; // current level
            int sum=0;
            while(sz--)
            {
                TreeNode *t = q.front(); q.pop();
                sum += t->val;
                if(t->left) q.push(t->left);
                if(t->right) q.push(t->right);
            }
            if(sum>mxsum)
            {
                mxsum = sum;
                level = l;
            }
        }
        return level;
    }
};