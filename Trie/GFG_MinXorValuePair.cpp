/*
https://practice.geeksforgeeks.org/problems/minimum-xor-value-pair/1
Minimum XOR value pair
*/

struct TrieNode{
    TrieNode* children[2];
    bool isEnd;
};

class Solution{   
public:
    TrieNode *root;
    void insert(int num)
    {
        TrieNode* ptr = root;
        // bitset<32> bt(num);
        for(int i=31; i>=0; i--)
        {
            int bit = (num>>i)&1;
            if(ptr->children[bit] == nullptr)
                ptr->children[bit] = new TrieNode();
            ptr = ptr->children[bit];
        }
    }
    
    int findmin(int num)
    {
        int xr=0;
        TrieNode* ptr = root;
        // bitset<32> bt(num);
        for(int i=31; i>=0; i--)
        {
            int bit = (num>>i)&1;
            if(ptr->children[bit])
                ptr = ptr->children[bit];
            else{
                xr |= 1<<i;
                ptr = ptr->children[!bit];
            }
        }
        return xr;
    }

    int minxorpair(int n, int arr[]){ 
        // Approach 1
        // sort(arr, arr+n); //if a<b<c then a^c must be greater either than a^b or b^c
        // int ans=INT_MAX;
        // for(int i=1; i<n; i++)
        //     ans = min(ans, arr[i-1]^arr[i]);
        // return ans;
           
        root = new TrieNode();
        int ans = INT_MAX;
        insert(arr[0]);
        for(int i=1; i<n; i++)
        {
            ans = min(ans, findmin(arr[i]));
            insert(arr[i]);
        }
        return ans;
    }   
};