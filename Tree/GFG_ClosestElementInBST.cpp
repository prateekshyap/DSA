/*
https://practice.geeksforgeeks.org/problems/find-the-closest-element-in-bst/1
Find the Closest Element in BST
*/

class Solution
{
    public:
    //Function to find the least absolute difference between any node
	//value of the BST and the given integer.
    int minDiff(Node *root, int K)
    {
        if(!root) return 0;
        // solve(root, K);
        
        while(root)
        {
            diff = min(diff, abs(root->data - K));
            if(K>root->data)
                root = root->right;
            else
                root = root->left;
        }
        
        return diff;
    }
    
    int diff=INT_MAX;
    void solve(Node* root, int k)
    {
        if(!root) return;
        if(!root->left and !root->right)
        {
            diff = min(diff, abs(root->data - k));
            return;
        }
        diff = min(diff, abs(root->data - k));
        if(k>root->data)
            solve(root->right, k);
        else
            solve(root->left, k);
    }
};