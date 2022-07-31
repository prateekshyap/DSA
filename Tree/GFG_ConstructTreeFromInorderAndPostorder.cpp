/*
https://practice.geeksforgeeks.org/problems/tree-from-postorder-and-inorder/1
Tree from Postorder and Inorder
*/

//{ Driver Code Starts
/* program to construct tree using inorder and postorder traversals */
#include <bits/stdc++.h>
using namespace std;

/* A binary tree node has data, pointer to left child
   and a pointer to right child */
struct Node {
    int data;
    struct Node* left;
    struct Node* right;

    Node(int x) {
        data = x;
        left = right = NULL;
    }
};

/* This funtcion is here just to test buildTreeUtil() */
void preOrder(Node* node) {
    if (node == NULL) return;

    /* then print the data of node */
    printf("%d ", node->data);

    /* first recur on left child */
    preOrder(node->left);

    /* now recur on right child */
    preOrder(node->right);
}

Node* buildTree(int in[], int post[], int n);

int main() {
    int t, n;
    cin >> t;
    while (t--) {
        cin >> n;
        int in[n], post[n];
        for (int i = 0; i < n; i++) cin >> in[i];
        for (int i = 0; i < n; i++) cin >> post[i];
        Node* root = buildTree(in, post, n);
        preOrder(root);
        cout << endl;
    }
    return 0;
}

// } Driver Code Ends


/* Tree node structure

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;

    Node(int x){
        data = x;
        left = right = NULL;
    }
};*/

int p;
Node* bt(int in[],int post[], int s, int e)
{
    if(s>e) return nullptr;
    
    Node* root = new Node(post[p--]);
    
    int idx = 0;
    for(idx=s; idx<=e; idx++){
        if(in[idx] == root->data)
            break;
    }
    // cout<<idx<<". "<<root->data<<endl;
    root->right = bt(in, post, idx+1, e); 
    root->left = bt(in, post, s, idx-1);
    return root;
}
    
//Function to return a tree created from postorder and inoreder traversals.
Node *buildTree(int in[], int post[], int n) {
    if(n==0)
        return nullptr;
    // p=n-1;
    // return bt(in, post, 0, n-1);
    
    Node* root = new Node(post[n-1]);
        
    int idx = 0;
    for(; idx<n; idx++)
    {
        if(in[idx] == root->data)
            break;
        
    }
    // cout<<idx<<". "<<root->data<<endl;
    root->left = buildTree(in, post, idx);
    root->right = buildTree(in+idx+1, post+idx, n-idx-1); 
    return root;
}


