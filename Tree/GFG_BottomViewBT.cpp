/*
https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1#
Bottom View of Binary Tree 
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


vector <int> bottomView(Node *root);

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


 // } Driver Code Ends
//Function to return a list containing the bottom view of the given tree.

class Solution {
  public:
    vector <int> bottomView(Node *root) {
        // return bottomViewBFS(root);
        map<int, pair<int, int>> mp;
        bottomViewDFS(root, 0, 0, mp);
        vector<int> ans;
        for(auto x: mp)
            ans.push_back(x.second.second);
        return ans;
    }
    
    void bottomViewDFS(Node* root, int dist, int height, map<int, pair<int, int>>& mp)
    {
        if(!root)
            return;
        
        if(mp.find(dist) == mp.end())
            mp[dist] = {height, root->data};
        else //if(mp.find(dist) != mp.end())
        {
            if(height >= mp[dist].first)
                mp[dist] = {height, root->data}; //replace the data with less height
        }
        
        // if(root->left)
            bottomViewDFS(root->left, dist-1, height+1, mp);
        // if(root->right)
            bottomViewDFS(root->right, dist+1, height+1, mp);
    }
    
    vector<int> bottomViewBFS(Node *root)
    {
        map<int,int> um; // to map the nodes
        //BFS Level Order Traversal
        queue<pair<Node*, int>> q;
        q.push({root, 0}); // vertical distance
        
        int sz, dist;
        Node * node;
        while(!q.empty())
        {
            sz = q.size();
            while(sz--)
            {
                node = q.front().first;
                dist = q.front().second; q.pop();
                // cout<<node->data<<" ";
                if(node->left)
                    q.push({node->left, dist-1});
                if(node->right)
                    q.push({node->right, dist+1});
                
                um[dist] = node->data;
            }
            // cout<<endl;
        }
        vector<int> ans;
        for(auto x: um)
            ans.push_back(x.second);
        return ans;
    }
};

// { Driver Code Starts.

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
        Solution ob;
        vector <int> res = ob.bottomView(root);
        for (int i : res) cout << i << " ";
        cout << endl;
    }
    return 0;
}


  // } Driver Code Ends