/*
https://leetcode.com/problems/kth-smallest-element-in-a-bst/
230. Kth Smallest Element in a BST

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
    vector<int> val;
    
    void inorder(TreeNode* root)
    {
        if(!root)
            return;
        inorder(root->left);
            val.push_back(root->val);
        inorder(root->right);
    }
    
    void inorder2(TreeNode* root, int& k, int &ans)
    {
        if(!root)
            return;
        inorder2(root->left, k, ans);
            if(--k == 0)
            {
                ans = root->val;
                return;
            }
        inorder2(root->right, k, ans);
    }
    
    int kthSmallest(TreeNode* root, int k) {
        // inorder(root);
        // return val[k-1];
        
        int ans=-1;
         inorder2(root, k, ans);
        return ans;
    }
};