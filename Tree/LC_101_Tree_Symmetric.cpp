/* https://leetcode.com/problems/symmetric-tree/
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
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
    bool isSymmetric(TreeNode* root) {

        if(!root) return true;

        //return (isSym(root->left, root->right));  // recursive solution

        return isSym_BFS(root);     // iterative solution


    }

    bool isSym(TreeNode* t1, TreeNode* t2){
        if (t1 == nullptr && t2 == nullptr)
            return true;

        if(t1 == nullptr || t2 ==nullptr)
            return false;

        if(t1->val == t2->val)
            return (isSym(t1->left, t2->right) && isSym(t1->right, t2->left));
        else
            return false;
    }

    bool isSym_BFS(TreeNode *t){
        if (t->left == nullptr && t->right == nullptr)
            return true;

        queue<TreeNode *> q;
        q.push(t->left);
        q.push(t->right);

        while(!q.empty())
        {
            TreeNode *leftc = q.front(); q.pop();
            TreeNode *rightc = q.front(); q.pop();

            if(!leftc && !rightc) continue;
            if(!leftc || !rightc) return false;
            if(leftc->val != rightc->val) return false;

            q.push(leftc->left);
            q.push(rightc->right);

            q.push(leftc->right);
            q.push(rightc->left);
        }
        return true;
    }


};