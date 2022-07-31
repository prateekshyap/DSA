/*
https://leetcode.com/problems/unique-binary-search-trees-ii/
95. Unique Binary Search Trees II

*/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

typedef vector<TreeNode*> vtn;
class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        // return buildTree(1, n);
        return buildTreeTopDownDP(1, n);
    }
    
    vtn dp[9][9];
    
    vtn buildTreeTopDownDP(int l, int r)
    {
        if(l>r)
            return {nullptr};
        
        if(!dp[l][r].empty())
            return dp[l][r];
        
        vtn ans;
        
        // cout<<"\t ("<<l<<"->"<<r<<") \n";
        
        for(int rootval=l; rootval<=r; rootval++)
        {
            vtn left, right;
            // left = buildTree(l, rootval-1); //set of bst's using l to i-1
            // right = buildTree(rootval+1, r); // set of bst's using i+1 to r
            
            if(l==rootval-1) //left side only single node with value = l
                left = {new TreeNode(l)};
            else if(l>rootval-1)
                left = {nullptr};
            else
                left = buildTreeTopDownDP(l, rootval-1);
            
            if(r==rootval+1)
                right = {new TreeNode(r)};
            else if(rootval+1>r)
                right = {nullptr};
            else
                right = buildTreeTopDownDP(rootval+1, r);
            
            //creating all possible different combinations using left and right 
            for(int li=0; li<left.size(); li++)
            {
                for(int ri=0; ri<right.size(); ri++)
                {
                    ans.push_back(new TreeNode(rootval, left[li], right[ri]));
                }
            }
            // cout<<rootval<<"root ("<<l<<"->"<<r<<") = ";
            // for(auto x: left)
            //     cout<<(x?x->val:0)<<"L ";
            // for(auto x: right)
            //     cout<<(x?x->val:0)<<"R ";
            // cout<<endl;
        }
        return dp[l][r]=ans;
    }
    
    vtn buildTree(int l, int r)
    {
        if(l>r)
            return {nullptr};
        vtn ans;
        
        // cout<<"\t ("<<l<<"->"<<r<<") \n";
        
        for(int rootval=l; rootval<=r; rootval++)
        {
            vtn left, right;
            // left = buildTree(l, rootval-1); //set of bst's using l to i-1
            // right = buildTree(rootval+1, r); // set of bst's using i+1 to r
            
            if(l==rootval-1) //left side only single node with value = l
                left = {new TreeNode(l)};
            else if(l>rootval-1)
                left = {nullptr};
            else
                left = buildTree(l, rootval-1);
            
            if(r==rootval+1)
                right = {new TreeNode(r)};
            else if(rootval+1>r)
                right = {nullptr};
            else
                right = buildTree(rootval+1, r);
            
            //creating all possible different combinations using left and right 
            for(int li=0; li<left.size(); li++)
            {
                for(int ri=0; ri<right.size(); ri++)
                {
                    ans.push_back(new TreeNode(rootval, left[li], right[ri]));
                }
            }
            // cout<<rootval<<"root ("<<l<<"->"<<r<<") = ";
            // for(auto x: left)
            //     cout<<(x?x->val:0)<<"L ";
            // for(auto x: right)
            //     cout<<(x?x->val:0)<<"R ";
            // cout<<endl;
        }
        return ans;
    }
};