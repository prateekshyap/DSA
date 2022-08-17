/*
https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
235. Lowest Common Ancestor of a Binary Search Tree

https://practice.geeksforgeeks.org/problems/lowest-common-ancestor-in-a-bst/1
Lowest Common Ancestor in a BST
*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */

class Solution {
public:
    TreeNode* lowestCommonAncestor(TreeNode* root, TreeNode* p, TreeNode* q) {
        if(!root)
            return nullptr;
        if(root->val > p->val and root->val > q->val)
            return lowestCommonAncestor(root->left, p, q);
        if(root->val < p->val and root->val < q->val)
            return lowestCommonAncestor(root->right, p, q);
        
        return root;
    }
};

/*

*/
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};
// Function to Build Tree
Node* buildTree(string str)
{   
    // Corner Case
    if(str.length() == 0 || str[0] == 'N')
            return NULL;
    
    // Creating vector of strings from input 
    // string after spliting by space
    vector<string> ip;
    
    istringstream iss(str);
    for(string str; iss >> str; )
        ip.push_back(str);
        
    // Create the root of the tree
    Node* root = new Node(stoi(ip[0]));
        
    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);
        
    // Starting from the second element
    int i = 1;
    while(!queue.empty() && i < ip.size()) {
            
        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();
            
        // Get the current node's value from the string
        string currVal = ip[i];
            
        // If the left child is not null
        if(currVal != "N") {
                
            // Create the left child for the current node
            currNode->left = new Node(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->left);
        }
            
        // For the right child
        i++;
        if(i >= ip.size())
            break;
        currVal = ip[i];
            
        // If the right child is not null
        if(currVal != "N") {
                
            // Create the right child for the current node
            currNode->right = new Node(stoi(currVal));
                
            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }
    
    return root;
}

Node* LCA(Node * root , int l , int h);

int main()
{

    int t;
	scanf("%d ",&t);
    while(t--)
    {
        string s;
        int l , h;
		getline(cin,s);
		scanf("%d ",&l);
		scanf("%d ",&h);
        Node* root = buildTree(s);
        cout<<LCA(root ,  l ,  h)->data<<endl;
    }
    return 1;
}
// } Driver Code Ends




//Function to find the lowest common ancestor in a BST. 
Node* LCA(Node *root, int n1, int n2)
{
    if(!root)
        return root;
       
    if(n1 > root->data and n2 > root->data)
        return LCA(root->right, n1, n2);
    if(n1 < root->data and n2 < root->data)
        return LCA(root->left, n1, n2);
    
    // n1 or n2 == root;
    // n1 and n2 on other sides
    // both case ans is root
    return root;
}


