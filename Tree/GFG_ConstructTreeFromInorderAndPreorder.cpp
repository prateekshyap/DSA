/*
https://practice.geeksforgeeks.org/problems/construct-tree-1/1
Construct Tree from Inorder & Preorder

*/

//{ Driver Code Starts
//

#include<bits/stdc++.h>
using namespace std;

struct Node
{
	int data;
	struct Node *left;
	struct Node *right;
	
	Node(int x){
	    data = x;
	    left = NULL;
	    right = NULL;
	}
};


void printPostOrder(Node *root)
{
	if(root==NULL)
		return;
	printPostOrder(root->left);
	printPostOrder(root->right);
	cout<<root->data<<" ";
}

// } Driver Code Ends


/*Complete the code here.
Node is as follows:
struct Node
{
  int data;
  Node* left;
  Node* right;
};
*/
class Solution{
    public:
    Node* buildTree(int in[],int pre[], int n)
    {
        if(n==0)
            return nullptr;
        // return bt(in, pre, 0, n-1);
        
        Node* root = new Node(pre[0]);
        
        int idx = 0;
        for(; idx<n; idx++)
        {
            if(in[idx] == root->data)
                break;
            
        }
        // cout<<idx<<". "<<root->data<<endl;
        root->left = buildTree(in, pre+1, idx);
        root->right = buildTree(in+idx+1, pre+1+idx, n-idx-1); 
        return root;
    }
    int p=0;
    Node* bt(int in[],int pre[], int s, int e)
    {
        if(s>e)
            return nullptr;
        
        Node* root = new Node(pre[p++]);
        
        int idx = 0;
        for(idx=s; idx<=e; idx++)
        {
            if(in[idx] == root->data)
                break;
            
        }
        // cout<<idx<<". "<<root->data<<endl;
        root->left = bt(in, pre, s, idx-1);
        root->right = bt(in, pre, idx+1, e); 
        return root;
    }
};

//{ Driver Code Starts.
int main()
{
	int t;
	cin>>t;
	while(t--)
	{
		int n;
		cin>>n;
		
		int inorder[n], preorder[n];
		for(int i=0; i<n; i++)
			cin>> inorder[i];
		for(int i=0; i<n; i++)
			cin>> preorder[i];
		Solution obj;
		Node *root = obj.buildTree(inorder, preorder, n);
		printPostOrder(root);
		cout<< endl;
	}
}

// } Driver Code Ends