/*
1008. Construct Binary Search Tree from Preorder Traversal
https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
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
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int n = preorder.size();
        /*
        vector<int> inorder = preorder;
        sort(inorder.begin(), inorder.end());
        return constructBySort(0, n-1, preorder, inorder);
        */
        
        // return constructFromPre(preorder, 0, n-1); 
        
        
        int maxval = INT_MAX;
        int idx = 0;
        // int minval = INT_MIN;
        // return makeBSTminmax(minval, maxval, idx, preorder);
        return makeBSTmax(maxval, idx, preorder);
        
    }
    
    TreeNode* makeBSTmax(int maxval, int& idx, vector<int>& preorder)
    {
        if(idx >= preorder.size())
            return nullptr;
        if(preorder[idx]>maxval)
            return nullptr;
        TreeNode* root = new TreeNode(preorder[idx++]);
        root->left = makeBSTmax(root->val, idx, preorder);
        root->right = makeBSTmax(maxval, idx, preorder);
        return root;
    }
    
    TreeNode* makeBSTminmax(int minval, int maxval, int& idx, vector<int>& preorder)
    {
        if(idx >= preorder.size())
            return nullptr;
        if(preorder[idx] < minval or preorder[idx]>maxval)
            return nullptr;
        TreeNode* root = new TreeNode(preorder[idx++]);
        root->left = makeBSTminmax(minval, root->val, idx, preorder);
        root->right = makeBSTminmax(root->val, maxval, idx, preorder);
        return root;
    }
    
    TreeNode* constructFromPre(vector<int>& pre, int s, int e)
    {
        if(s>e)
            return nullptr;
        TreeNode* root = new TreeNode(pre[s]);
        int rn = s+1;
        while(rn<=e and pre[rn] < pre[s]) //rightside bigger node
            rn++;
        root->left = constructFromPre(pre, s+1, rn-1);
        root->right = constructFromPre(pre, rn, e);
        return root;
    }
    
    /*
    
    int p=0;
    TreeNode* constructBySort(int s, int e, vector<int>& pre, vector<int>& in)
    {
        if(s>e)
            return nullptr;
        TreeNode* root = new TreeNode(pre[p++]);
        int idx = lower_bound(in.begin(), in.end(), root->val) - in.begin();
        root->left = constructBySort(s, idx-1, pre, in);
        root->right = constructBySort(idx+1, e, pre, in);
        return root;
    }
    */
};