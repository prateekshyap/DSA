/*
https://leetcode.com/problems/maximum-xor-with-an-element-from-array/
1707. Maximum XOR With an Element From Array

*/

struct TrieNode{
    TrieNode* children[2];
    bool isEnd;
};

class Trie{
    TrieNode *root;
    public:
    Trie()
    {
        root = new TrieNode();
    }
    void insert(int num)
    {
        TrieNode* ptr = root; 
        for(int i=31; i>=0; i--)
        {
            int bit = (num>>i)&1;
            if(ptr->children[bit] == nullptr)
                ptr->children[bit] = new TrieNode();
            ptr = ptr->children[bit];
        }
    }
	int findxor(int num)
    {
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
};

class Solution {
public:
    
    
    static bool sortbysecond(vector<int>& a, vector<int>& b){
        return a[1]<b[1];
    }
    vector<int> maximizeXor(vector<int>& nums, vector<vector<int>>& queries) {
        Trie tr;
        int n = nums.size(), nq = queries.size();
        vector<int> ans(nq, -1);
        
        /*
        int i=0;
        for(auto &vec: queries) vec.push_back(i++);
        sort(queries.begin(), queries.end(), sortbysecond);
        priority_queue<int, vector<int>, greater<int>> pq(nums.begin(), nums.end()); 
        
        
        bool smallExist = false;
        for(auto& vec: queries)
        {
            int xi = vec[0];
            int mi = vec[1];
            int idx = vec[2];
            while(!pq.empty() and pq.top()<= mi)
            {
                smallExist = true;
                // cout<<pq.top()<<" ";
                insert(pq.top()); // insert all elements less than m_i
                pq.pop();
            }
            if(smallExist)
                ans[idx] = findxor(xi);
        }
        */
        sort(nums.begin(), nums.end());
        vector<pair<int, pair<int, int>>> offlineq;
        int idx=0;
        for(auto &vec: queries)
            offlineq.push_back({vec[1],{vec[0], idx++}});
        sort(offlineq.begin(), offlineq.end());
        idx=0;
        for(auto &oq : offlineq)
        {
            int mi = oq.first;
            int xi = oq.second.first;
            int ins = oq.second.second;
            while(idx<n and nums[idx] <= mi)
            {
                // cout<<nums[idx]<<" ";
                tr.insert(nums[idx]);
                idx++;
            }
            
            if(idx != 0)
                ans[ins] = tr.findxor(xi);
        }
        
        return ans;
    }
};