/* https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
 * Leaf at same level  Easy
 * Given a Binary Tree, check if all leaves are at same level or not.
 */

// { Driver Code Starts
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
/* The structure of the binary tree is as follows
struct Node
{
    int data;
    Node* left;
    Node* right;
};
*/

class Solution{
  public:
    /*You are required to complete this method*/
    bool check(Node *root)
    {
       bool flag = true;
       int root_level = -1;
       checkLeafDepth(root, 1, root_level, flag);
       return flag;
       
    }
    
    void checkLeafDepth(Node *t, int curr_level, int &root_level, bool &flag){
        if(!t) return;
        if(!flag) return;
        if(!t->left && !t->right){
            if(root_level == -1) root_level = curr_level;
            else if(root_level != curr_level) flag=false;
            return;
        }
        checkLeafDepth(t->left, curr_level+1, root_level, flag);
        checkLeafDepth(t->right, curr_level+1, root_level, flag);
        
    }//checkLeafDepth
    
    // using vector to store the height of each leaf node and then checking if all values are same
    bool check1(Node *root)
    {
       vector<int> depth;
       
       LeafDepth(root, 1, depth);
       
       for(int i=1; i<depth.size(); i++){
           if(depth[0] != depth[i])
            return false;
       }
       return true;
       
       
    }
    void LeafDepth(Node *t, int level, vector<int> &d ){
        if(t==nullptr) return;
        
        if(!t->left && !t->right){
          d.push_back(level);
          return;
        } 
        
        LeafDepth(t->left, level+1, d);
        LeafDepth(t->right, level+1, d);
    }//LeafDepth
};

// { Driver Code Starts.
// Driver program to test size function
int main()
{
    int t;
    cin>> t;
    getchar();
    while (t--)
    {
        string s;
        getline( cin, s );
        Node* head = buildTree( s );
        Solution obj;
        cout << obj.check(head) << endl;
    }
    return 0;
}
  // } Driver Code Ends