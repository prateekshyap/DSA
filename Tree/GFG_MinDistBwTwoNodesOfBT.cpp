/*
https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1
Min distance between two given nodes of a Binary Tree
*/

//{ Driver Code Starts
//Initial Template for C++


#include <bits/stdc++.h>
using namespace std;
#define MAX_HEIGHT 100000

// Tree Node
struct Node {
    int data;
    Node* left;
    Node* right;
};

// Utility function to create a new Tree Node
Node* newNode(int val) {
    Node* temp = new Node;
    temp->data = val;
    temp->left = NULL;
    temp->right = NULL;

    return temp;
}


// Function to Build Tree
Node* buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N') return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;) ip.push_back(str);

    // Create the root of the tree
    Node* root = newNode(stoi(ip[0]));

    // Push the root to the queue
    queue<Node*> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node* currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current node
            currNode->left = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size()) break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current node
            currNode->right = newNode(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


// } Driver Code Ends
/* A binary tree node
struct Node
{
    int data;
    Node* left, * right;
}; */

class Solution{
    public:
    /* Should return minimum distance between a and b
    in a tree with given root*/
    /*
    Node* lca(Node* root ,int n1 ,int n2 )
    {
       if(!root)
         return root;
       
       if(root->data == n1 or root->data == n2)
          return root;
        
        Node* left = lca(root->left, n1, n2);
        Node* right = lca(root->right, n1, n2);
        
        if(left and right)
            return root;
        
        return left ? left : right;
    }
    
    int findDistFromRoot(Node* root, int d)
    {
        if(!root)
            return 1e7;
        if(root->data == d)
            return 0;
        int l = findDistFromRoot(root->left, d);
        int r = findDistFromRoot(root->right, d);
        if(l == 1e7 and r == 1e7)
            return 1e7;
        // if(l == -1)
        //     return r+1;
        // if(r == -1)
        //     return l+1;
        // return r+1;
        return 1 + min(l, r);
    }
    
    int findDist(Node* root, int a, int b) {
        if(!root || a==b)
            return 0;
        Node* lcaNode = lca(root, a, b);
        
        // int dist_a = findDistFromRoot(root, a);
        // int dist_b = findDistFromRoot(root, b);
        // int dist_lca = findDistFromRoot(root, lcaNode->data);
        // // cout<<dist_a<<" "<<dist_b<<" "<<dist_lca<<endl;
        // return (dist_a + dist_b - (2*dist_lca));
        
        
        int dist_a = findDistFromRoot(lcaNode, a);
        int dist_b = findDistFromRoot(lcaNode, b);
        cout<<dist_a<<" "<<dist_b<<" "<<lcaNode->data<<endl;;
        return (dist_a + dist_b );
    }
    */
    
    int traverse(Node* root, int a, int b)
    {
        if(!root || ans>0)
            return 0;
        int l = traverse(root->left, a, b);
        int r = traverse(root->right, a, b);
        if(root->data == a || root->data == b)
        {
            if(l != 0)
                ans = l;
            else if(r != 0)
                ans = r;
            else 
                return 1;
        }
        
        if(l!=0 and r!=0)
            ans = l+r;
        else if(l!=0)
            return l+1;
        else if(r!=0)
            return r+1;
        return 0;
    }
    
    int ans=0;
    int findDist(Node* root, int a, int b) {
        if(!root || a==b)
            return 0;
        traverse(root, a, b);
        return ans;
    }
};

//{ Driver Code Starts.

/* Driver program to test size function*/

  

int main() {

   
    int t;
    scanf("%d ", &t);
    while (t--) {
        string s, ch;
        getline(cin, s);
        
        Node* root = buildTree(s);
        int n1, n2;
        scanf("%d %d ", &n1, &n2);
        Solution ob;
        cout << ob.findDist(root, n1, n2) << endl;
     
    }
    return 0;
}

// } Driver Code Ends