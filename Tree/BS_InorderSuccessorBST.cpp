/*
Inorder Successor
https://binarysearch.com/problems/Inorder-Successor
*/

/**
 * class Tree {
 *     public:
 *         int val;
 *         Tree *left;
 *         Tree *right;
 * };
 */

/*
int T;
Tree* par;
Tree* search(Tree* root)
{
    if(root->val == T)
        return root;
    else if(T < root->val)
    {
        par = root;
        return search(root->left);
    }
    else 
        return search(root->right);
}

int solve(Tree* root, int t) {
    T=t;
    par = nullptr;

    Tree* node = search(root);

    if(par != nullptr && !node->right)
        return par->val;
    
    Tree* rightChild = node->right;

    while(rightChild->left)
        rightChild = rightChild->left;

    return rightChild->val;
}
*/

int solve(Tree* root, int t) {
    int ans=-1;
    while(root)
    {
        if(t < root->val)
        {
            ans = root->val;
            root = root->left;
        }
        else
        {
            root = root->right;
        }
    }
    return ans;
}