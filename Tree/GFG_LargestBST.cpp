/*
https://practice.geeksforgeeks.org/problems/largest-bst/1
Largest BST
https://leetcode.com/problems/largest-bst-subtree/
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
/* Tree node structure  used in the program

struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};*/
// #define minid 0
// #define maxid 1
// #define size 2
enum ids {minval, maxval, size};
class Solution{
    public:
    /*You are required to complete this method */
    // Return the size of the largest sub-tree which is also a BST
    int ans=1;
    int largestBst(Node *root)
    {
    	if(!root)
    	    return 0;
    	checkLargestBST(root);
    	return ans;
    }

    vector<int> checkLargestBST(Node* root)
    {
        // min_value, max_value, size of bst;
        
        if(!root)
            return {INT_MAX, INT_MIN, 0};
        if(!root->left and !root->right)
            return {root->data, root->data, 1};
        
        auto left = checkLargestBST(root->left);
        auto right = checkLargestBST(root->right);
        
        // cout<<root->data<<" = ";
        // for(int x: left)
        //     cout<<x<<"L "; cout<<"|| ";
        // for(int x: right)
        //     cout<<x<<"R "; cout<<"|| ";
            
        vector<int> retvec = {INT_MIN, INT_MAX, 0};
        //if not a bst tree
        if(left[maxval] >= root->data or right[minval] <= root->data)
            return retvec;
        
        retvec[size] = 1 + left[size]+right[size];
        retvec[minval] = min(left[minval],  root->data);
        retvec[maxval] = max(right[maxval],  root->data);
        ans = max(ans, retvec[size]);
        
        // for(int x: retvec)
        //     cout<<x<<"A ";
        // cout<<endl;
        
        return retvec;
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
        Solution ob;
        cout << ob.largestBst(root) << endl;
    }
    return 0;
}

// } Driver Code Ends