/*
https://leetcode.com/problems/cousins-in-binary-tree/
993. Cousins in Binary Tree

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
    int levelx = 0;
    int levely = 0;
    TreeNode* parx = nullptr, * pary = nullptr;
    
    void preorder(TreeNode* root, int x, int y, int level, TreeNode* pre)
    {
        if(!root)
            return;
        
        if(root->val == x && levelx==0)
        {
            parx = pre;   
            levelx = level;
        }
        if(root->val == y && levely ==0)
        {
            pary = pre;   
            levely = level;
        }
        
        preorder(root->left, x, y, level+1, root);
        preorder(root->right, x, y, level+1, root);
            
    }
    
    bool isCousins(TreeNode* root, int x, int y) {
        // int level = 0;
        // preorder(root, x, y, level, nullptr);
        // return (levelx == levely && parx != pary);
        
        TreeNode* parx=nullptr, *pary=nullptr;
        queue<TreeNode*> q;
        q.push(root);
        
        while(!q.empty())
        {
            int size = q.size();
            while(size--)
            {
                TreeNode* t = q.front(); q.pop();
                if(t->left)
                {
                    if(t->left->val == x)
                        parx = t;
                    else if(t->left->val == y)
                        pary = t;
                    else
                        q.push(t->left);
                }
                if(t->right)
                {
                    if(t->right->val == x)
                        parx = t;
                    else if(t->right->val == y)
                        pary = t;
                    else
                        q.push(t->right);
                }
                
                    
            }
            if(parx && pary)
                if(parx != pary)
                    return true;
                else 
                    return false;
                
            if(parx || pary)
                return false;
        }//while qempty
        return false;
    }//end
};