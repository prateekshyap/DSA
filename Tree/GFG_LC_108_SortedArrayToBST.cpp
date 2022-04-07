/*
https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
108. Convert Sorted Array to Binary Search Tree
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
 
 // LEETCODE require to construct the tree.
class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        int n = nums.size();
        if(n==0) return nullptr;
        TreeNode* root = insertIntoBST(nums, 0, n-1);
        
        return root;
    }// end
    
    TreeNode* insertIntoBST(vector<int>& nums, int l, int r)
    {
        if(l>r) return nullptr;
        int mid = l+(r-l)/2;
        TreeNode* root = new TreeNode(nums[mid]);
        root->left = insertIntoBST(nums, l, mid-1);
        
        root->right = insertIntoBST(nums, mid+1, r);
        return root;
    }
};

// GFG, Doesn't require to construct the tree.

// { Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

 // } Driver Code Ends
class Solution {
public:
    vector<int> ans;
    vector<int> sortedArrayToBST(vector<int>& nums) {
        // Code here
        int n = nums.size();
        preorder(nums, 0, n-1);
        return ans;
    }
    
    void preorder(vector<int>& nums, int s, int e)
    {
        if(s>e) return;
        int mid = s + (e-s)/2;
        ans.push_back(nums[mid]);
        preorder(nums, s, mid-1);
        preorder(nums, mid+1, e);
    }
};

// { Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < n; i++)cin >> nums[i];
		Solution obj;
		vector<int>ans = obj.sortedArrayToBST(nums);
		for(auto i: ans)
			cout << i <<" ";
		cout << "\n";
	}
	return 0;
}  // } Driver Code Ends