/*
https://leetcode.com/problems/n-ary-tree-postorder-traversal/
590. N-ary Tree Postorder Traversal

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
    
    void traversalpostorder(Node* root)
    {
        if(!root)
            return;
        
        for(Node* c: root->children)
            traversalpostorder(c);
        
        order.push_back(root->val);
        
    }
    vector<int> postorder(Node* root) {
        
        if(!root)
            return order;
        traversalpostorder(root);
        
        return order;
    }
    
};