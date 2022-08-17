/*
https://leetcode.com/problems/binary-tree-postorder-traversal/
https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/0/#
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
    vector<int> postorderTraversal_1(TreeNode* root) {
        stack<TreeNode*> st;
        vector<int> ans;
        TreeNode* pre=nullptr, *cur = root;
        
        while(cur || !st.empty())
        {
          if(cur != nullptr)
          {
              st.push(cur);
              cur = cur->left;
          }
          else
          {
              cur = st.top();
              if(cur->right == nullptr || cur->right == pre)
              {
                  ans.push_back(cur->val);
                  st.pop();
                  pre = cur;
                  cur = nullptr;
              }
              else
                cur = cur->right;
          }
        }//while
        
        return ans;
    }
    
    vector<int> postorderTraversal(TreeNode* root) {
        if(!root)
            return {};
        stack<TreeNode*> st;
        vector<int> ans;
        st.push(root);
        
        while(!st.empty())
        {
            TreeNode* t = st.top(); 
            
            if(t->left)
            {    
                st.push(t->left);
                t->left=nullptr;
                continue;
            }
            if(t->right)
            {
                st.push(t->right);
                t->right = nullptr;
                continue;
            }
            ans.push_back(t->val);
            st.pop();
        }
    
        return ans;
    }
};

//GFG_ -------------------------------------------

// { Driver Code Starts
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
// User function Template for C++

/* Tree Node
struct Node {
    int data;
    Node* left;
    Node* right;
};*/
class Solution{
    public:
    vector<int> postOrder(Node* node) {
        // return postOrderReverse(node);
        // return postOrderReverseUsingStack(node);
        
        stack<Node*> st;
        vector<int> ans;
        Node* pre=nullptr, *cur = node;
        
        while(cur || !st.empty())
        {
          if(cur != nullptr)
          {
              st.push(cur);
              cur = cur->left;
          }
          else
          {
              cur = st.top();
              if(cur->right == nullptr || cur->right == pre)
              {
                  ans.push_back(cur->data);
                  st.pop();
                  pre = cur;
                  cur = nullptr;
              }
              else
                cur = cur->right;
          }
        }//while
        
        return ans;
    }
    
    vector<int> postOrderReverseUsingStack(Node* node) {
        
        stack<Node*> st1, st2;
        vector<int> ans;
        st1.push(node);
        
        while(!st1.empty())
        {
           Node* t = st1.top(); st1.pop();
           st2.push(t);
           if(t->left)
                st1.push(t->left);
           if(t->right)
                st1.push(t->right);
                
        }
        
        while(!st2.empty())
        {
            ans.push_back(st2.top()->data);
            st2.pop();
        }
        
        return ans;
    }
    
    vector<int> postOrderReverse(Node* node) {
        stack<Node*> st;
        vector<int> ans;
        st.push(node);
        
        while(!st.empty())
        {
            Node* t = st.top(); st.pop();
            ans.push_back(t->data);
            if(t->left)
                st.push(t->left);
            if(t->right)
                st.push(t->right);
        }
        
        reverse(ans.begin(), ans.end());
        return ans;
    }
};

// { Driver Code Starts.

/* Driver program to test size function*/

  

int main() {

   
    int t;
    scanf("%d ", &t);
    while (t--) {
        string s, ch;
        getline(cin, s);
        
        Node* root = buildTree(s);

        vector<int> ans;
        Solution ob;
        ans = ob.postOrder(root) ;

        for (int i = 0; i < ans.size(); i++)
            cout << ans[i] << " ";

        cout << endl;
     
    }
    return 0;
}
  // } Driver Code Ends