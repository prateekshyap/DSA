/*
https://leetcode.com/problems/maximum-xor-of-two-numbers-in-an-array/
421. Maximum XOR of Two Numbers in an Array
*/

struct TrieNode{
  TrieNode* children[26];
  bool isLeaf;
};

class Solution {
public:
    TrieNode* root;
    
    void insert(int num)
    {
        TrieNode* ptr = root;
        for(int i=31; i>=0; i--)
        {
            int bit =(num>>i)&1;
            if(ptr->children[bit] == nullptr)
                ptr->children[bit] = new TrieNode();
            ptr = ptr->children[bit];
        }
    }
	int findxor(int num)
    {
        trace1(num);
        int xr=0;
        TrieNode* ptr = root;
        for(int i=31; i>=0; i--)
        {
            int bit =(num>>i)&1;
            if(ptr->children[!bit])
            {
                xr |= 1<<i;
                ptr = ptr->children[!bit];
            }
            else{
                ptr = ptr->children[bit];
            }
            // cout<<bit<<"->"<<bitset<5>(xr)<<" ";
        }
        // cout<<num<<" "<<xr<<endl;
        return xr;
    }
    
    int findMaximumXOR(vector<int>& nums) {
        root = new TrieNode();
        int ans = 0;
        
        for(const int &x: nums)
            insert(x);
        
        for(const int &x: nums)
        {
            ans = max(ans, findxor(x));
        }
        return ans;
    }
};