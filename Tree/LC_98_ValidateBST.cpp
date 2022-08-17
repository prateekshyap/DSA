/*
https://leetcode.com/problems/validate-binary-search-tree/
98. Validate Binary Search Tree
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
    
    // ITERATIVE APPROACH INORDER
     bool isValidBST(TreeNode* root) {
         TreeNode* prev = nullptr;
         stack<TreeNode*> predecessors;
         while(root || !predecessors.empty())
         {
             while(root)
             {
                 predecessors.push(root);
                 root=root->left;
             }
             root = predecessors.top(); predecessors.pop();
             if(prev && prev->val >= root->val) return false;
             prev = root;
             root = root->right;
             
         }// while predecssor
         return true;
     }// end
    
    // min and max are bound of the node value it can take as we enter into tree
    /*
    bool checkValidity(TreeNode* t, int min, int max)
    {
        if(!t) return true;
        
        if(t->val <= min || t->val >= max)
            return false;
        return checkValidity(t->left,  min,  t->val) && checkValidity(t->right,  t->val,  max);
    }
    
    bool isValidBST(TreeNode* root) {
      if(!root) return true;
        
        return checkValidity(root, INT_MIN, INT_MAX);
    }// end
    */
    /****** USING EXTRA SPACE OF VECTOR ********/
//     void inorder(TreeNode* t, vector<int>&v)
//     {
//         if(!t)
//             return;
//         inorder(t->left, v);
//         v.push_back(t->val);
//         inorder(t->right, v);
//     }
    
//     bool isValidBST(TreeNode* root) {
        
//         if(!root) return true;
//         vector<int> v;
//         inorder(root,v);
//         for(int i = 1; i<v.size(); i++)
//         {
//             if(v[i] <= v[i-1]) return false;
//         }
//         return true;
        
//     }// end
};