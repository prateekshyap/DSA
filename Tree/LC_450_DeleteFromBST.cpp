/*
https://leetcode.com/problems/delete-node-in-a-bst/
450. Delete Node in a BST

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
    
    TreeNode* parCurr = nullptr; // parent of current node
    TreeNode* locCurr = nullptr; // location of current node
    TreeNode* prev = nullptr; 
    
    // Search the location of node in the BST
    int searchBST(TreeNode* t, int x)
    {
        parCurr = nullptr;
        locCurr = nullptr;
        prev = nullptr;
        
        while(t)
        {
            if(x == t->val)
            {
                locCurr = t;
                parCurr = prev;
                return 1;
            }
            prev = t;
            if(x < t->val){
                t = t->left;
            }
            else{ 
                t = t->right;
            }
        }// while
        
        // if node not found
        parCurr = prev;
        locCurr = nullptr;
        return -1;
    }// end search BST
    
    void caseA(TreeNode *par, TreeNode* loc, TreeNode** troot) // single or no children exists
    {
        TreeNode* child;
        if(!loc->left && !loc->right)
            child = nullptr;
        else if(loc->left)
            child = loc->left;
        else 
            child = loc->right;
        
        if(!par) // if parent is null
            *troot = child;  // single node, single node with either child
        else
        {
            if(loc == par->left)
                par->left = child;
            else
                par->right = child;
        }
        
    }// caseA
    
    void caseB(TreeNode *par, TreeNode* loc, TreeNode** troot) // single or no children exists
    {
        TreeNode* suc, *parsuc, *ptr;
        
        parsuc = loc;
        suc = loc->right;
        
        while(suc->left)
        {
            parsuc = suc;
            suc = suc->left;
        }
        
        // delete successor node
        if(suc->left && suc->right)
            caseB(parsuc, suc, troot);
        else
            caseA(parsuc, suc, troot);
     
        if(!par) // if parent is null
            *troot = suc;  // single node, single node with either child
        else
        {
            if(loc == par->left)
                par->left = suc;
            else
                par->right = suc;
        }
        suc->left = loc->left;
        suc->right= loc->right;
    }// caseB
    
    TreeNode* deleteNode1(TreeNode* root, int key) {
        if(!root) return root;
        
        //Now Searching the location of Node to Delete.
        int res = searchBST(root, key);
        if(res == -1) return root;
        
        if(locCurr->left && locCurr->right)
            caseB(parCurr, locCurr, &root); // both the children exists
        else
            caseA(parCurr, locCurr, &root); // single or no children exists
        
        locCurr = nullptr;
        
        return root;
    }// end
    
    TreeNode* deleteNode(TreeNode* root, int key)
    {
        if(!root) return root;
        if(key < root->val)
            root->left = deleteNode(root->left, key);
        else if(key > root->val)
            root->right = deleteNode(root->right, key);
        else
        {
            if(!root->left && !root->right) return nullptr;
            if(!root->left) return root->right;
            if(!root->right) return root->left;
            else
            {
                TreeNode* p = root->right;
                while(p->left)
                    p = p->left;
                root->val = p->val;
                root->right = deleteNode(root->right, root->val); // crawl right side with root val which is successors value also
            }
        }
        return root;
    }// end
    
};