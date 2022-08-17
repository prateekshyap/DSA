/* https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 * 103. Binary Tree Zigzag Level Order Traversal
 *
 /

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
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        
        if(!root) return {};
        
        vector<vector<int>> ans;
        queue<TreeNode*> q;
        
        q.push(root);
        bool leftToR = true;
        
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
             
          }//end while size
            if(!leftToR) 
            reverse(lnodes.begin(), lnodes.end()); 
            
            leftToR = !leftToR;
            ans.push_back(lnodes);
        }//end while
        
        
        return ans;
    }// end
};