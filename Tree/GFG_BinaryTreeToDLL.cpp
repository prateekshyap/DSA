/*
https://practice.geeksforgeeks.org/problems/binary-tree-to-dll/1
Binary Tree to DLL
*/

class Solution
{
    public: 
    /*
    vector<Node*> in;
    void inorder(Node* root)
    {
        if(!root) return;
        inorder(root->left);
        in.push_back(root);
        inorder(root->right);
    }
    //Function to convert binary tree to doubly linked list and return it.
    Node * bToDLL_outplace(Node *root)
    {
        if(!root) return nullptr;
        inorder(root);
        if(in.size()==1) return in[0];
        in[0]->left = nullptr;
        in[0]->right = in[1];
        in[in.size()-1]->right = nullptr;
        in[in.size()-1]->left = in[in.size()-2];
        for(int i=1; i<in.size()-1; i++)
        {
            in[i]->right = in[i+1];
            in[i]->left = in[i-1];
        }
        return in[0];
    }
    */
    Node* newhead = nullptr;
    Node* prev = nullptr;
    
    void inorderRec(Node* root)
    {
        if(!root) return;
        inorderRec(root->left);
        
        if(newhead == nullptr)
            newhead = root;
        else
        {
            root->left = prev;
            prev->right = root;
        }
        prev = root;
        inorderRec(root->right);
    }
    
    Node * bToDLL(Node *root)
    {
        // return bToDLL_outplace(root);
        inorderRec(root);
        return newhead;
    }
};