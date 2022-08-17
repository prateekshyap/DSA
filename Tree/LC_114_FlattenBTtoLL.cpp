/*
https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
114. Flatten Binary Tree to Linked List

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
    
    TreeNode* prev = nullptr;
    void flatten(TreeNode* root) {
        if(!root) return;
        /*
        stack<TreeNode*> st; 
        st.push(root);
        while(!st.empty())
        {
            TreeNode* t = st.top(); st.pop();
            if(t->right) st.push(t->right);
            if(t->left) st.push(t->left);
            // cout<<t->val<<" "<<st.top()->val<<"| ";
            t->right = st.size()>0 ? st.top() : nullptr;
            t->left = nullptr;
        }
        */
        /*
        if(root->right) flatten(root->right);
        if(root->left) flatten(root->left);
        root->right = prev;
        root->left = nullptr;
        prev = root;
        */
        
        // flattenRec(root);
        TreeNode* cur = root;
        while(cur)
        {
            if(cur->left)
            {
                TreeNode* pre = cur->left;
                while(pre->right)
                    pre = pre->right;
                pre->right = cur->right;
                cur->right = cur->left;
                cur->left = nullptr;
            }
            cur = cur->right;
        }
        return;
    }
    
    void flattenRec(TreeNode* root, TreeNode* nextptr = nullptr)
    {
        if(!root) return;
        if(root->left and root->right)
        {
            flattenRec(root->left, root->right);
            flattenRec(root->right, nextptr);
            root->right = root->left;
            root->left = nullptr;
        }
        else if(root->left)
        {
            flattenRec(root->left, nextptr);
            root->right = root->left;
            root->left = nullptr;
        }
        else if(root->right)
        {
            flattenRec(root->right, nextptr);
        }
        else
        {
            root->right = nextptr;
        }
            
    }//
    
    
};