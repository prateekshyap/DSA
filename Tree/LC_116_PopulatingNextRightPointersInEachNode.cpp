/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
116. Populating Next Right Pointers in Each Node
*/

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* left;
    Node* right;
    Node* next;

    Node() : val(0), left(NULL), right(NULL), next(NULL) {}

    Node(int _val) : val(_val), left(NULL), right(NULL), next(NULL) {}

    Node(int _val, Node* _left, Node* _right, Node* _next)
        : val(_val), left(_left), right(_right), next(_next) {}
};
*/

class Solution {
public:
    Node* connect(Node* root) {
        Node* pre = root;
        Node* cur;
        
        while(pre)
        {
            cur = pre;
            while(cur && cur->left) // travelling nodes of particular level
            {
                cur->left->next = cur->right;
                if(cur->next)
                    cur->right->next = cur->next->left;
                cur = cur->next;
            }
            pre = pre->left; // go to next level;
        }
        return root;
    }
    Node* connect_Rec(Node* root) {
        
        if(!root)
            return root;
        
        if(root && root->left)
        {
            root->left->next = root->right;
            connect_Rec(root->left);
            
            if(root->next)
                root->right->next = root->next->left;
            connect_Rec(root->right);
        }
        
        return root;
        //return connect_BFS(root);
    }//
    
    Node* connect_BFS(Node* root) {
        
        if(!root)
            return root;
        
        queue<Node*> q;
        q.push(root);
        
        while(!q.empty())
        {
            int size = q.size();
            Node* prev = nullptr;
            while(size--)
            {
                Node *curNode = q.front(); q.pop();
            

                if(curNode->left) 
                    q.push(curNode->left);
                if(curNode->right)
                    q.push(curNode->right);
                
                if(prev)
                    prev->next = curNode;
                prev = curNode;
            }
            prev->next = nullptr;
        }//while
        
        return root;
    }//
};