/* 
 * https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 102. Binary Tree Level Order Traversal

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
    vector<vector<int>> levelOrder(TreeNode* root) {
        
        if(!root) return {};
        
        queue<TreeNode *> q;
        vector<vector<int>> ans;
        int l=0;
        
        q.push(root);
        
        
        while(!q.empty())
        {
            int size = q.size();
            vector<int> lnodes;
            
            while(size--)
            {
                TreeNode *t = q.front(); q.pop();
                lnodes.push_back(t->val);
                 
                if(t->left) q.push(t->left);
                if(t->right) q.push(t->right);
            }
            
            ans.push_back(lnodes);
            
        }//while q
        
        return ans;
    }//end
};