/*
https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
1373. Maximum Sum BST in Binary Tree

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
class NodeValue
{
    public:
    int minval, maxval, sum;
    NodeValue(int mini, int maxi, int s)
    {
        minval = mini;
        maxval = maxi;
        sum = s;
    }
};

class Solution {
public:
    
    int ans=0;
    int maxSumBST(TreeNode* root) {
        if(!root)
            return 0;
        checkMaxSumBST(root);
        return ans;
    }
    
    NodeValue checkMaxSumBST(TreeNode* root)
    {
        if(!root)
            return NodeValue(INT_MAX, INT_MIN, 0);
        if(!root->left and !root->right)
        {
            ans = max(ans, root->val);
            return NodeValue(root->val, root->val, root->val);
        }
        
        auto left = checkMaxSumBST(root->left);
        auto right = checkMaxSumBST(root->right);
        
        NodeValue retnode(INT_MIN, INT_MAX, 0);
        
        if(left.maxval >= root->val or right.minval <= root->val)
            return retnode;
        
        retnode.sum = root->val + left.sum + right.sum;
        retnode.minval = min(left.minval, root->val);
        retnode.maxval = max(right.maxval, root->val);
        ans = max(ans, retnode.sum);
        
        return retnode;
    }
    
    // typedef vector<int> vi;
    // // minval and maxval is to check for bst while sum is to calculate for bst key sum
    // enum ids {minval, maxval, sum};
//     vi checkMaxSumBST(TreeNode* root)
//     {
//         if(!root)
//             return {INT_MAX, INT_MIN, 0};
//         if(!root->left and !root->right)
//         {
//             ans = max(ans, root->val);
//             return {root->val, root->val, root->val};
//         }
        
//         auto left = checkMaxSumBST(root->left);
//         auto right = checkMaxSumBST(root->right);
        
//         vi retvec = {INT_MIN, INT_MAX, 0};
        
//         if(left[maxval] >= root->val or right[minval] <= root->val)
//             return retvec;
        
//         retvec[sum] = root->val + left[sum] + right[sum];
//         retvec[minval] = min(left[minval], root->val);
//         retvec[maxval] = max(right[maxval], root->val);
//         ans = max(ans, retvec[sum]);
        
//         return retvec;
//     }
};