/*
https://leetcode.com/problems/serialize-and-deserialize-bst/
449. Serialize and Deserialize BST

*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Codec {
public:
    /*
    string tree2str(TreeNode* root) {
        if(!root) return "";
        string ans = to_string(root->val);
        
        if(!root->left and !root->right) return ans;
        
        ans+= "(" + tree2str(root->left) + ")";
    
        if(root->right) ans+= "(" + tree2str(root->right) + ")";
        
        return ans;
    } //tree2str
    
    TreeNode* str2tree(string& s, int& idx)
    {
        if(idx >= s.length()) return nullptr;
        
        string num="";  TreeNode* node = nullptr;
        while(idx<s.length() and s[idx]!='(' and s[idx] != ')'){
            num+=s[idx];
            idx++;
        }
        
        if(num=="")  return node;
        node = new TreeNode(stoi(num));
        if(idx < s.length() and s[idx] == '(')
        {
            idx++;  node->left = str2tree(s, idx);  idx++; // remove )
            if(idx < s.size() and s[idx] == '(')
            {
                idx++; node->right = str2tree(s, idx); idx++;
            }
        }
        return node;
    } //str2tree
    */
    
    string convertToPre(TreeNode* root)
    {
        if(!root) return "";
        string s = to_string(root->val) + ",";
        s += convertToPre(root->left);
        s += convertToPre(root->right);
        return s;
    }
    
    TreeNode* convertFromPreMin(int& idx, int mxval, vector<int>& pre)
    {
        if(idx >= pre.size())
            return nullptr;
        if(pre[idx] > mxval)
            return nullptr;
        
        TreeNode* root = new TreeNode(pre[idx++]);
        root->left = convertFromPreMin(idx, root->val, pre);
        root->right = convertFromPreMin(idx, mxval, pre);
        return root;
    }
        
    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        // return tree2str(root); //Using BT to string concept
        
        return convertToPre(root); // using Preorder concept of BST
    }

    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        // int i=0; return str2tree(data, i); //using string to BT code
        int n = data.size();
        vector<int> pre;
        string buf;
        for(int i=0; i<n; i++)
        {
            if(data[i] == ',')
            {
                pre.push_back(stoi(buf));
                buf="";
            }
            else
                buf+=data[i];
        }
        int i=0;
        return convertFromPreMin(i, INT_MAX, pre);
        
    }
};

// Your Codec object will be instantiated and called as such:
// Codec* ser = new Codec();
// Codec* deser = new Codec();
// string tree = ser->serialize(root);
// TreeNode* ans = deser->deserialize(tree);
// return ans;