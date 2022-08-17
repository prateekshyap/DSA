/*
https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
1026. Maximum Difference Between Node and Ancestor
https://practice.geeksforgeeks.org/problems/maximum-difference-between-node-and-its-ancestor/1
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
    
    void myprint(vector<int> vec) { for(int x: vec)  cout<<x<<" "; cout<<endl; }
    
    int mxdiff=0;
    int maxAncestorDiff(TreeNode* root) {
        // postorder(root); // Approach 1
        // preorder(root, root->val, root->val); // Aproach 2
        // return mxdiff;
        return preordermax(root, INT_MAX, INT_MIN);
        
    }
    
    pair<int,int> postorder(TreeNode* root)
    {
        if(!root)
            return {INT_MAX, INT_MIN};
        if(!root->left and !root->right)
            return {root->val, root->val};
        auto [lmin, lmax] = postorder(root->left);
        auto [rmin, rmax] = postorder(root->right);
        int curmin = min({lmin, rmin, root->val});
        int curmax = max({lmax, rmax, root->val});
        // myprint({root->val, curmin, curmax});
        mxdiff = max({mxdiff, root->val - curmin, curmax - root->val});
        return {curmin, curmax};
    }
    
    void preorder(TreeNode* root, int curmin, int curmax)
    {
        if(!root)  return;
        mxdiff = max({mxdiff, root->val - curmin, curmax - root->val});
        // myprint({root->val, curmin, curmax});
        if(!root->left and !root->right) return;
        curmin = min(curmin, root->val);
        curmax = max(curmax, root->val);
        preorder(root->left, curmin, curmax);
        preorder(root->right, curmin, curmax);
    }
    
    int preordermax(TreeNode* root, int curmin, int curmax)
    {
        if(!root)  return curmax-curmin;
        curmin = min(curmin, root->val);
        curmax = max(curmax, root->val);
        // myprint({root->val, curmin, curmax});
        return max (preordermax(root->left, curmin, curmax),
                        preordermax(root->right, curmin, curmax));
    }
    
};


// GFG ----------------------------------------------------
//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Tree Node
struct Node
{
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val)
{
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}


int maxDiff(Node *root);

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
    Node* root = newNode(stoi(ip[0]));

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
            currNode->left = newNode(stoi(currVal));

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
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


int main() {
    int t;
    string tc;
    getline(cin, tc);
    t=stoi(tc);
    while(t--)
    {
        string s ;
        getline(cin, s);
        Node* root = buildTree(s);
        
        cout<<maxDiff(root)<<endl;
    }
    return 0;
}


// } Driver Code Ends


/* A binary tree node

struct Node
{
    int data;
    struct Node* left;
    struct Node* right;
    
    Node(int x){
        data = x;
        left = right = NULL;
    }
};
 */

void myprint(vector<int> vec) { for(int x: vec)  cout<<x<<" "; cout<<endl; } 

int mxdiff=INT_MIN;
int postorder(Node* root)
{
    if(!root) return INT_MAX;
    if(!root->left and !root->right) return root->data;
    
    int lval = postorder(root->left);
    int rval = postorder(root->right);
    int curmin = min(lval, rval);

    // myprint({root->data, curmin});
    mxdiff = max(mxdiff, root->data - curmin); // calculate the result of root from its children
    return min(curmin, root->data); // min value for next ancestor
}

void preorder(Node* root, int curmax)
{
    if(!root) return;
    mxdiff = max(mxdiff, curmax - root->data);
    
    if(!root->left and !root->right) return;
    
    curmax = max(curmax, root->data);
    preorder(root->left, curmax);
    preorder(root->right, curmax);
}
//Function to return the maximum difference between any node and its ancestor.
int maxDiff(Node* root)
{  
    mxdiff=INT_MIN;
    // postorder(root); // Approach 1
    preorder(root, -1e9);
    return mxdiff;
}
