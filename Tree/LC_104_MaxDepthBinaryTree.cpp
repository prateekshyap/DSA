/* https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
    // Recursive Approach
    int maxDepth(TreeNode* root) {
        int left_ht=0, right_ht=0;

        if(root == nullptr) return 0;

        if(root->left == nullptr && root->right == nullptr)
            return 1;   // As We have to Count number of nodes along the path
        else{
            left_ht = maxDepth(root->left);     // Left Subtree Height
            right_ht = maxDepth(root->right);   // Right Subtree Height

            return (1 + (left_ht>right_ht? left_ht:right_ht));
        }



    }
};