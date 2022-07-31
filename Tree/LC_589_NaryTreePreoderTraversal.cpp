/*
https://leetcode.com/problems/n-ary-tree-preorder-traversal/
589. N-ary Tree Preorder Traversal
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
    vector<int> order;
    
    void traversalPreorder(Node* root)
    {
        if(!root)
            return;
        
        order.push_back(root->val);
        
        for(Node* c: root->children)
            traversalPreorder(c);
        
    }
    vector<int> preorder(Node* root) {
        
        if(!root)
            return order;
        traversalPreorder(root);
        
        return order;
    }
};