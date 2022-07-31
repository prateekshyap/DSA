/*
https://practice.geeksforgeeks.org/problems/diagonal-traversal-of-binary-tree/1#
Diagonal Traversal of Binary Tree 
*/

// { Driver Code Starts
#include <bits/stdc++.h>
using namespace std;
#define MAX_HEIGHT 100000

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


vector<int> diagonal(Node *root);

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
        string s ,ch;
        getline(cin, s);
        Node* root = buildTree(s);

        vector<int> diagonalNode = diagonal(root);
        for(int i = 0;i<diagonalNode.size();i++)
        cout<<diagonalNode[i]<<" ";
        cout<<endl;
    }
    return 0;
}

// } Driver Code Ends


/* A binary tree node
struct Node
{
    int data;
    Node* left, * right;
}; */

vector<int> diagonalBFS(Node *root)
{
    queue<Node*> q;
    q.push(root); 
    vector<int> ans;
    
    while(!q.empty())
    {
        Node* node = q.front(); q.pop();
        while(node)
        {
            ans.push_back(node->data);
            if(node->left) q.push(node->left);
            node = node->right;
        }
    }
    return ans;
}

void diagonalDFS(Node* root, int dist, map<int, vector<int>>& mp)
{
    if(!root)
        return;
    mp[dist].push_back(root->data); //replace the data with less height
    
    diagonalDFS(root->left, dist+1, mp);
    diagonalDFS(root->right, dist, mp);
}

vector<int> diagonal(Node *root)
{
  return diagonalBFS(root);
/*
  map<int, vector<int>> mp;
    diagonalDFS(root, 0, mp);
    vector<int> ans;
    for(auto x: mp)
        ans.insert(ans.end(), x.second.begin(), x.second.end());
    return ans;
*/
}
