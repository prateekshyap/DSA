/* https://practice.geeksforgeeks.org/problems/sum-of-the-longest-bloodline-of-a-tree/1#
 * Given a binary tree of size N. Your task is to complete the function sumOfLongRootToLeafPath(), 
	that find the sum of all nodes on the longest path from root to leaf node.
	If two or more paths compete for the longest path, then the path having maximum sum of nodes is being considered.
 */




// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

struct Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x)
    {
        data = x;
        left = NULL;
        right = NULL;
    }
};

void printInorder(Node *node)
{
    if (node == NULL)
    {
        return;
    }
    printInorder(node->left);
    cout << node->data << " ";
    printInorder(node->right);
}
Node *buildTree(string str)
{
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
    while (!queue.empty() && i < ip.size())
    {

        // Get and remove the front of the queue
        Node *currNode = queue.front();
        queue.pop();

        // Get the current node's value from the string
        string currVal = ip[i];

        // If the left child is not null
        if (currVal != "N")
        {

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
        if (currVal != "N")
        {

            // Create the right child for the current node
            currNode->right = new Node(stoi(currVal));

            // Push it to the queue
            queue.push(currNode->right);
        }
        i++;
    }

    return root;
}


 // } Driver Code Ends
//User function Template for C++

/*
structure of the node of the binary tree is as
struct Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x)
    {
        data = x;
        left = NULL;
        right = NULL;
    }
};
*/
class Solution
{
public:
    int ans = INT_MIN;  //path sum
    int max_level_reached=0; //max level in tree reached so far
    // root, current level, current level path sum (from root)
    void calculate_sum(Node *t, int curr_level, int cl_path_sum){
        if(!t) return;
        cl_path_sum += t->data;
        
        if(curr_level > max_level_reached){
            max_level_reached = curr_level;
            ans = cl_path_sum;
        }
        else if (curr_level == max_level_reached){
            ans = max(ans, cl_path_sum);
        }
        
        calculate_sum(t->left,curr_level+1,cl_path_sum);
        calculate_sum(t->right,curr_level+1,cl_path_sum);
    }//calculate_sum
    
    int sumOfLongRootToLeafPath(Node *root)
    {
       calculate_sum(root,1,0);
       return ans;
    } //sumOfLongRootToLeafPath
    
};

// { Driver Code Starts.

int main()
{

    int t;
    scanf("%d", &t);
    cin.ignore();
    while (t--)
    {
        string treeString;
        getline(cin, treeString);
        Node *root = buildTree(treeString);
        Solution obj;
        int res = obj.sumOfLongRootToLeafPath(root);
        cout << res << "\n";
    }
    return 0;
}  // } Driver Code Ends