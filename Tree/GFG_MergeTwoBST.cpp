/*
https://practice.geeksforgeeks.org/problems/merge-two-bst-s/1
Merge two BST 's
*/
class Solution
{
    public:
    //Function to return a list of integers denoting the node 
    //values of both the BST in a sorted order.
    
    void goleft(Node* root, stack<Node*> &st)
    {
        while(root)
        {
            st.push(root);
            root = root->left;
        }
    }
    
    vector<int> merge(Node *root1, Node *root2)
    {
       stack<Node*> s1, s2;
       vector<int> ans;
       goleft(root1, s1);
       goleft(root2, s2);
       while(!s1.empty() || !s2.empty())
       {
            int a = s1.size() ? s1.top()->data : INT_MAX;  
            int b = s2.size() ? s2.top()->data : INT_MAX;  
            if(a<=b){
                ans.push_back(a);
                Node* t = s1.top(); s1.pop();
                if(t->right) goleft(t->right, s1);
            }
            else{
                ans.push_back(b);
                Node* t = s2.top(); s2.pop();
                if(t->right) goleft(t->right, s2);
            }
       }
       return ans;
    }//
};