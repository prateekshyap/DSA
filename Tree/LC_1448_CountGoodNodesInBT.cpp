/*
https://leetcode.com/problems/count-good-nodes-in-binary-tree/
1448. Count Good Nodes in Binary Tree

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
    void myprint(vector<int> vec) { for(int x: vec)  cout<<x<<" "; cout<<endl; }
    
    int cnt=0;
    int goodNodes(TreeNode* root) {
        
        countGN(root, INT_MIN);
        return cnt;
    }
    
    void countGN(TreeNode* root, int mxval)
    {
        if(!root)
            return;
        if(!root->left and !root->right)
        {
            if(root->val >= mxval)
                cnt++;
            return;
        }
        
        if(root->val >= mxval)
        {
            cnt++;
            mxval = root->val;
        }
        countGN(root->left, mxval);
        countGN(root->right, mxval);
    }
    
    int count(TreeNode* root, int mxval)
    {
        if(!root)
            return 0;
        if(!root->left and !root->right)
            return (root->val >= mxval);
        
        int val = 0;
        if(root->val >= mxval)
        {
            val = 1;
            mxval = root->val;
        }
        // myprint({root->val, mxval, val});
        return  val + count(root->left, mxval) + count(root->right, mxval);
        
    }
};