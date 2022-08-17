/*
https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1/
Is Binary Tree Heap
*/

#include <bits/stdc++.h>
using namespace std;

// Tree Node
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
Node *buildTree(string str) {
    // Corner Case
    if (str.length() == 0 || str[0] == 'N') return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;) ip.push_back(str);

    // Create the root of the tree
    Node *root = new Node(stoi(ip[0]));

    // Push the root to the queue
    queue<Node *> queue;
    queue.push(root);

    // Starting from the second element
    int i = 1;
    while (!queue.empty() && i < ip.size()) {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current Node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N") {

            // Create the left child for the current Node
            currNode->left = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->left);
        }

        // For the right child
        i++;
        if (i >= ip.size()) break;
        currVal = ip[i];

        // If the right child is not null
        if (currVal != "N") {

            // Create the right child for the current Node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


 // } Driver Code Ends
// User Function template for C++

// Structure of node
/*struct Node {
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = NULL;
    }
};*/

class Solution {
  public:
    bool isHeap(struct Node* tree) {
        
        // return isHeapRecursive(tree);
        if(!tree)
            return true;
        
        queue<Node*> q;
        q.push(tree);
        bool isnull= false;
        while(!q.empty())
        {
            Node* t = q.front(); q.pop();
            
            if(t->left)
            {
                if(isnull || t->left->data > t->data)
                    return false;
                q.push(t->left);
            }
            else
                isnull = true;
            
            if(t->right)
            {
                if(isnull || t->right->data > t->data)
                    return false;
                q.push(t->right);
            }
            else
                isnull = true;
            
            /*
            Node* t = q.front(); q.pop();
            if(!t || (!t->left && !t->right)) // null or leaf node
                return true;
            else if(!t->left && t->right) // right side exist, not left
                return false;
            else if(t->right && !t->left->right && t->right->left)
                return false;
                
            if(t->left->data > t->data)
                return false;
            q.push(t->left);
            
            if(t->right)
            {
                if(t->right->data > t->data)
                    return false;
                q.push(t->right);
            }
            */
        }
        
        
        return true;
    }
    
    bool isHeapRecursive(struct Node* root)
    {
        if(!root || (!root->left && !root->right)) // null or leaf node
            return true;
        else if(!root->left && root->right) // right side exist, not left
            return false;
        else if(root->right && !root->left->right && root->right->left)
            return false;
            
        if(root->left->data > root->data) //if minheap
            return false;
        if(root->right && root->right->data > root->data)
            return false;
        
        return isHeapRecursive(root->left)&&isHeapRecursive(root->right);
    }
};

// { Driver Code Starts.

int main() {
    int tc;
    scanf("%d ", &tc);
    while (tc--) {
        string treeString;
        getline(cin, treeString);
        Solution ob;
        Node *root = buildTree(treeString);
        if (ob.isHeap(root))
            cout << 1 << endl;
        else
            cout << 0 << endl;
    }

    return 0;
}  // } Driver Code Ends