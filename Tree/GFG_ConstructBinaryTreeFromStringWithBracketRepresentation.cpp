/*
https://leetcode.com/problems/construct-binary-tree-from-string/
https://practice.geeksforgeeks.org/problems/construct-binary-tree-from-string-with-bracket-representation/0/
https://www.lintcode.com/problem/880/
*/

//GFG ---------------------------------------

// { Driver Code Starts
//Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

/* A binary tree node has data, pointer to left
child and a pointer to right child */
class Node
{
public:
    int data;
    Node *left, *right;
    Node(int data)
    {
        this->data = data;
        this->left = this->right = NULL;
    }
};

/* This function is to print the inorder of the tree  */
void inorder(Node *root)
{
    if (root == NULL)
        return;
    inorder(root->left);
    printf("%d ", root->data);
    inorder(root->right);
}



 // } Driver Code Ends
//User function Template for C++

class Solution
{
public:
    
    Node *treeFromString(string str, int idx=0)
    {
        if(str.empty())
            return nullptr;
        int i = 0;
        return str2tree(str, i);
    }
    
    Node* str2tree(string& s, int& idx)
    {
        if(idx >= s.length())
            return nullptr;
        
        string num="";
        while(idx<s.length() and s[idx]!='(' and s[idx] != ')')
        {
            num+=s[idx];
            idx++;
        }
        
        Node* node = new Node(stoi(num));
        if(idx < s.length() and s[idx] == '(')
        {
            idx++; // remove (
            node->left = str2tree(s, idx);
            idx++; // remove )
            // cout<<node->data<<" "<<idx<<endl;
            // if again ( then it is right subtree
            if(idx < s.size() and s[idx] == '(')
            {
                idx++;
                node->right = str2tree(s, idx);
                idx++;
            }
        }
        return node;
    }
};

// { Driver Code Starts.

// Driver Code
int main()
{
    int t;
    cin >> t;
    while (t--)
    {
        string str;
        cin >> str;
        Solution obj;
        Node *root = obj.treeFromString(str);
        inorder(root);
        cout << "\n";
    }
    return 0;
}
  // } Driver Code Ends

// LintCode -----------------------------------------------------------
/**
 * Definition of TreeNode:
 * class TreeNode {
 * public:
 *     int val;
 *     TreeNode *left, *right;
 *     TreeNode(int val) {
 *         this->val = val;
 *         this->left = this->right = NULL;
 *     }
 * }
 */

class Solution {
public:
    /**
     * @param s: a string
     * @return: a root of this tree
     */
    TreeNode* str2tree(string &s) {
        // write your code here
        if(s=="")
            return nullptr;
            
        int open = 0;
        while(open<s.size() and s[open] != '(' and s[open] != ')')
            open++;
        int data = stoi(s.substr(0, open));
        TreeNode *node = new TreeNode(data);
        s.erase(0, open);
        // cout<<node->val<<" L "<<s<<endl;

        if(s[0] == '(')
        {
            s.erase(0, 1);
            node->left = str2tree(s);
        }
        if(s[0] == ')')
        {
            s.erase(0, 1);
            return node;
        }
            
        
        // cout<<node->val<<" R "<<s<<endl;
        if(s[0] == '(')
        {
            s.erase(0, 1);
            node->right = str2tree(s);
        }
        if(s[0] == ')')
        {
            s.erase(0, 1);
            return node;
        }

        return node;
    }
};

//"1(2(3(4(5(6(7(8)))))))(9(10(11(12(13(14(15)))))))"