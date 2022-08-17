/*
https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
297. Serialize and Deserialize Binary Tree
https://practice.geeksforgeeks.org/problems/serialize-and-deserialize-a-binary-tree/1
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
class Codec {
public:

// Approach 1 ---------------------------------------------------------------
    string tree2str(TreeNode* root)
    {
        string s;
        if(!root)
        {
            s = "#,";
            return s;
        }
        s = to_string(root->val) + ",";
        s += tree2str(root->left) + tree2str(root->right) ;
        return s;
    }
    
    TreeNode* str2tree(string& s, int& idx) {
        if(idx>=s.length())
            return nullptr;
        string num=""; TreeNode* node = nullptr;
        while(idx<s.length() and s[idx] != ',' )
        {
            num+=s[idx];
            idx++;
        }
        if(num == "#") return nullptr;
        node = new TreeNode(stoi(num));
        idx++;
        node->left = str2tree(s, idx);
        idx++;
        node->right = str2tree(s, idx);
        return node;
    }
    
// Approach 2 ---------------------------------------------------
    string tree2strBFS(TreeNode* root)
    {
        if(!root)
            return "";
        string s = "";
        queue<TreeNode*> q; q.push(root);
        while(!q.empty())
        {
            TreeNode* root = q.front(); q.pop();
            if(root == nullptr)
            {    
                s += "#,"; // null -> #
                continue;
            }
                
            s += to_string(root->val) + ",";
            q.push(root->left);
            q.push(root->right);
        }
        return s;
    }
    
    TreeNode* str2treeBFS(string data)
    {
        if(data.size() == 0) return nullptr;
        stringstream ss(data);
        string num;
        getline(ss, num, ',');
        
        TreeNode* root = new TreeNode(stoi(num));
        queue<TreeNode*> q; q.push(root);
        while(!q.empty())
        {
            TreeNode* node = q.front(); q.pop();
            getline(ss, num, ',');
            if(num == "#")
                node->left = nullptr;
            else{
                TreeNode* leftn = new TreeNode(stoi(num));
                q.push(leftn);
                node->left = leftn;
            }
            getline(ss, num, ',');
            if(num == "#")
                node->right = nullptr;
            else{
                TreeNode* rightn = new TreeNode(stoi(num));
                q.push(rightn);
                node->right = rightn;
            }
        }
        return root;
    }
  
// Approach 3
    void ss_serial(TreeNode* root, ostringstream& out)
    {
        if(!root)
        {
            out<<"# ";
            return ;
        }
        
        out<< root->val<<' ';
        ss_serial(root->left, out);
        ss_serial(root->right, out);
        
    }
    
    TreeNode* ss_deserial(istringstream& in)
    {
        string num;
        in >> num;
        if(num == "#")
            return nullptr;
        TreeNode* node = new TreeNode(stoi(num));
        node->left = ss_deserial(in);
        node->right = ss_deserial(in);
        return node;
        
    }
    
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        // return tree2str(root); // approach 1
        // return tree2strBFS(root); // approach 2
        ostringstream out;
        ss_serial(root, out);
        return out.str();
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        // int i=0; 
        // cout<<data<<endl;
        // return str2tree(data, i); // approach 1
        // cout<<data<<endl;
        // return str2treeBFS(data); // approach 2
        istringstream in(data);
        return ss_deserial(in);
    }
};

// Your Codec object will be instantiated and called as such:
// Codec ser, deser;
// TreeNode* ans = deser.deserialize(ser.serialize(root));


//GFG--------------------------
//{ Driver Code Starts
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
    if (str.length() == 0 || str[0] == 'N')
        return NULL;

    // Creating vector of strings from input
    // string after spliting by space
    vector<string> ip;

    istringstream iss(str);
    for (string str; iss >> str;)
        ip.push_back(str);

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
        if (i >= ip.size())
            break;
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
/* A binary tree node has data, pointer to left child
   and a pointer to right child  
struct Node
{
    int data;
    Node* left;
    Node* right;
}; */


class Solution
{
    vector<int> tree;
    int idx=0;
    
    public:
    //Function to serialize a tree and return a list containing nodes of tree.
    vector<int> serialize(Node *root) 
    {
        if(!root)
        {
            tree.push_back(-1);
            return tree;
        }
        tree.push_back(root->data);
        serialize(root->left);
        serialize(root->right);
        return tree;
    }
    
    //Function to deserialize a list and construct the tree.
    Node * deSerialize(vector<int> &A)
    {
        if(idx >= A.size()) return nullptr;
        if(A[idx] == -1) return nullptr;
        Node* root = new Node(A[idx]);
        idx++;
        root->left = deSerialize(A);
        idx++;
        root->right = deSerialize(A);
        return root;
    }

};

//{ Driver Code Starts.

void inorder(Node *root) {
    if (root == NULL)
        return;
    inorder(root->left);
    cout << root->data << " ";
    inorder(root->right);
}

void _deleteTree(Node* node)  
{  
    if (node == NULL) return;  
  
    /* first delete both subtrees */
    _deleteTree(node->left);  
    _deleteTree(node->right);  
  
    /* then delete the node */
    //cout << "Deleting node: " << node->data << endl;  
    delete node;  
}  
  
/* Deletes a tree and sets the root as NULL */
void deleteTree(Node** node_ref)  
{  
    _deleteTree(*node_ref);  
    *node_ref = NULL;  
}  

int main() {
    int tc;
    scanf("%d ", &tc);
    while (tc--) {
        string treeString;
        getline(cin, treeString);
        Node *root = buildTree(treeString);
        
        Solution serial, deserial;
        vector<int> A = serial.serialize(root);
        deleteTree(&root);
        Node *getRoot = deserial.deSerialize(A);
        inorder(getRoot);
        cout << "\n";

    }


    return 0;
}
// } Driver Code Ends