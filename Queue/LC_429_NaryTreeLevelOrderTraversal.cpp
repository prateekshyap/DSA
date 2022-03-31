/*
	https://leetcode.com/problems/n-ary-tree-level-order-traversal/
	429. N-ary Tree Level Order Traversal

*/

/*
// Definition for a Node.
class Node {
public:
    int val;
    vector<Node*> children;

    Node() {}

    Node(int _val) {
        val = _val;
    }

    Node(int _val, vector<Node*> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
public:
    vector<vector<int>> levelOrder(Node* root) {
        
        if(!root) return {};
        
        vector<vector<int>> ans;
        queue<Node*> q;
        q.push(root);
        
        while(!q.empty())
        {
            int size = q.size();
            vector<int> lnodes;
            
            while(size--)
            {
              Node* t = q.front(); q.pop();
              lnodes.push_back(t->val);
              
              for(Node * c: t->children)
                  if(c) q.push(c);
            }
            
            ans.push_back(lnodes);
        }//
        
        
        return ans;
    }// end
};