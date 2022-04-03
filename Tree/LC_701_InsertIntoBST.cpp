/*
https://leetcode.com/problems/insert-into-a-binary-search-tree/
701. Insert into a Binary Search Tree
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
    
    //iterative version
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        if(!root)
            return  new TreeNode(val);
        
        TreeNode* curr = root;
        while(curr)
        {
            if(val < curr->val)
            {   if(!curr->left)
                {
                    curr->left = new TreeNode(val);
                    break;
                }
                else
                    curr = curr->left;
            }
            else
            {   if(!curr->right)
                {
                    curr->right = new TreeNode(val);
                    break;
                }
                else
                    curr = curr->right;
            }
        }
        
        return root;
    }// end
    
    // shorter recursive version
    TreeNode* insertIntoBSTRec(TreeNode* root, int val) {
        if(!root)
            return  new TreeNode(val);
        if(val > root->val)
            root->right = insertIntoBST(root->right, val);
        else
            root->left = insertIntoBST(root->left, val);
        
        return root;
    }// end
    
    /*
    int v = INT_MIN;
    void search(TreeNode* t)
    {
        if(v > t->val)
        { // right side
            if(!t->right)  // if tree right not exist
                t->right = new TreeNode(v);
            else
                search(t->right);
        }
        else
        {
            //left side
            if(!t->left)
                t->left = new TreeNode(v);
            else
                search(t->left);
        }
    }
    
    TreeNode* insertIntoBST(TreeNode* root, int val) {
        v = val;
        if(!root)
            root = new TreeNode(val);
        else
            search(root);
        
        return root;
    }// end
    */
    
};