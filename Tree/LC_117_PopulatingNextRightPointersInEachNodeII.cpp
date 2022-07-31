/*
https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
117. Populating Next Right Pointers in Each Node II
https://practice.geeksforgeeks.org/problems/connect-nodes-at-same-level/1
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
        if(!root)
            return root;
        // return connect_BFS(root);
        // return connect_Rec(root);
        Node* curLevel = root;
        Node* nxtfirstNode, *prev, *ptr;
        
        while(curLevel)
        {
            ptr = curLevel; // for traversing in the current level
            prev = nxtfirstNode = nullptr;
            while(ptr) // travel that particular level
            {
                if(ptr->left)
                {
                    if(!nxtfirstNode)
                        nxtfirstNode = ptr->left;
                    else
                        prev->next = ptr->left;
                    prev = ptr->left;
                        
                }
                if(ptr->right)
                {
                    if(!nxtfirstNode)
                        nxtfirstNode = ptr->right;
                    else
                        prev->next = ptr->right;
                    prev = ptr->right;
                }
                ptr = ptr->next;
            }//while ptr
            curLevel = nxtfirstNode;
        }
        
        return root;
    }
    
	// DoestNot Work
//      Node* connect_Rec(Node* root) {
//         if(!root)
//             return root;
        
//          if(root && root->left) // cur and next level exist;
//          {
//              root->left->next = root->right;
//              connect_Rec(root->left);
             
//              if(root->next)
//              {
//                  if(root->next->left)
//                      root->right->next = root->next->left;
//                  else
//                      root->right->next = root->next->right;
//              }
//              connect_Rec(root->right);
//          }
//         return root;
//     }
    
    Node* connect_BFS(Node* root) {
        queue<Node*> q;
        q.push(root);
        
        while(!q.empty())
        {
            int size = q.size();
            Node* prev = nullptr;
            while(size--)
            {
                Node* curNode = q.front(); q.pop();
            
                if(curNode->left)
                    q.push(curNode->left);
                if(curNode->right)
                    q.push(curNode->right);
                
                if(prev)
                    prev->next = curNode;
                prev = curNode;
            }
            prev->next = nullptr;
            
        }
        
        return root;
    }
};


//GFG ---------------------------------------------
class Solution
{
    public:
    //Function to connect nodes at same level.
    void connect(Node *root)
    {
    //   root=connectBFS(root);
          connectDFS(root);
    }  
    
    Node* getRight(Node* node)
    {
        while(node)
        {
            if(node->left)
                return node->left;
            if(node->right)
                return node->right;
            node = node->nextRight;
        }
        return node;
    }
    
    void connectDFS(Node* root)
    {
        if(!root) return;
        
        Node* rootKaNextRight = getRight(root->nextRight); 
        if(root->left)
            root->left->nextRight =  root->right? root->right : rootKaNextRight;
        if(root->right)
            root->right->nextRight =  rootKaNextRight;    
        
        connectDFS(root->left);
        connectDFS(root->right);
    }
    
    Node* connectBFS(Node* root)
    {
        if(!root) return nullptr;
        queue<Node*> q; q.push(root);
        
        while(!q.empty())
        {
            int sz = q.size();
            Node* prev = nullptr;
            while(sz--)
            {
                Node* cur = q.front(); q.pop();
                if(cur->left) q.push(cur->left);
                if(cur->right) q.push(cur->right);
                if(prev) prev->nextRight = cur;
                prev = cur;
            }
            prev->nextRight = nullptr;
        }
        return root;
    }
      
};