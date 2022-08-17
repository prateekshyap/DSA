/*
https://leetcode.com/problems/find-unique-binary-string/
1980. Find Unique Binary String

*/

class Solution {
public:
    string findDifferentBinaryString_1(vector<string>& nums) {
        string ans(nums.size(), '0');
        
        for(int i=0; i<nums.size(); i++)
        {
            if(nums[i][i]=='0')
                ans[i]='1';
            else
                ans[i]='0';
        }
        
        return ans;
    }
    
    string findDifferentBinaryString_2(vector<string>& nums) {
        string ans;
        unordered_map<int,int> um;
        int temp;
        int max_num=0;
        for(int i=0; i<nums.size(); i++)
        {
            temp = stoi(nums[i], 0, 2);
            um[temp]++;
            if(temp > max_num)
                max_num = temp;
        }
        max_num = max_num+1;
        for(int i=0; i<=max_num; i++)
        {
            if(um[i]!=1)
            {
                ans = bitset<16>(i).to_string();
                ans = ans.substr(16-nums.size());
                return ans;
            }
        }
        
        return ans;
    }
    
    int size;
    string outans;
    unordered_map<string,int> umap;
    string findDifferentBinaryString(vector<string>& nums) {
        size=nums.size();
        for(int i=0; i<size; i++)
            umap[nums[i]]++;
        
        recursion(0, "");
        return outans;
    }
    
    bool recursion(int ind, string out)
    {
        if(ind == size)
        {
            if(umap[out] != 1)
            {
                outans = out;
                return true;
            }
            return false;
        }
        
        bool flag1 = recursion(ind+1, out+'0');
        if(flag1) return true;
        bool flag2 = recursion(ind+1, out+'1');
        return flag1 || flag2;
    }
};