/* https://leetcode.com/problems/invert-binary-tree/
 * Given the root of a binary tree, invert the tree, and return its root.
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
    TreeNode* invertTree(TreeNode* t) {

        if(!t)
            return t;

        if(!t->left && !t->right) return t;
        else
        {
            TreeNode* temp = t->left;
            t->left = invertTree(t->right);
            t->right = invertTree(temp);
            return t;
        }

    }

};