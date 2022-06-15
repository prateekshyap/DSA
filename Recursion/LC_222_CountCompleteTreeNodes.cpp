/*
https://leetcode.com/problems/count-complete-tree-nodes/
222. Count Complete Tree Nodes
https://binarysearch.com/problems/Count-Nodes-in-Complete-Binary-Tree
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
    int countNodes(TreeNode* root) {
    
    if(!root) return 0;

    TreeNode* ptr = root;

    int left_ht = 1, right_ht = 1;
    while(ptr->left)
    {
        left_ht++;
        ptr=ptr->left;
    }   

    ptr = root;
    while(ptr->right)
    {
        right_ht++;
        ptr=ptr->right;
    }   

    if(left_ht == right_ht) 
         // return (1<<left_ht) - 1; 
        return pow(2, left_ht) - 1;

    return 1 + countNodes(root->left) + countNodes(root->right);
    }
};