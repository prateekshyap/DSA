/*
https://leetcode.com/problems/binary-search-tree-iterator/
173. Binary Search Tree Iterator

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
class BSTIterator {
public:
    stack<TreeNode*> st;
    void pushleft(TreeNode* cur)
    {
       while(cur)
       {
           st.push(cur);
           cur = cur->left;
       }
    }
    
    BSTIterator(TreeNode* root) {
        pushleft(root);
    }
    
    int next() {
        TreeNode* cur = st.top();
        st.pop();
        
        pushleft(cur->right);
        
        return cur->val;
    }
    
    bool hasNext() {
        return !st.empty();
    }
    
    /*
    vector<int> ino;
    int i;
    void inorder(TreeNode* root)
    {
        if(!root)
            return;
        inorder(root->left);
        ino.push_back(root->val);
        inorder(root->right);
    }
    
    BSTIterator(TreeNode* root) {
        inorder(root);
        i=0;
    }
    
    int next() {
        if(i<ino.size())
            return ino[i++];
        return -1;
    }
    
    bool hasNext() {
        return i<ino.size();   
    }
    */
};

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator* obj = new BSTIterator(root);
 * int param_1 = obj->next();
 * bool param_2 = obj->hasNext();
 */