/*
https://leetcode.com/problems/query-kth-smallest-trimmed-number/
2343. Query Kth Smallest Trimmed Number

*/

class Solution {
public:
    vector<int> smallestTrimmedNumbers(vector<string>& nums, vector<vector<int>>& queries) {
        int n = nums.size();
        int nq = queries.size();
        int len = nums[0].size();
        vector<int> ans;
        for(auto &q: queries)
        {
            int k = q[0];
            int trim = q[1];
            vector<pair<string,int>> vec;
            for(int i=0; i<n; i++)
                vec.push_back({nums[i].substr(len-trim), i});
            sort(vec.begin(), vec.end());
            ans.push_back(vec[k-1].second);
        }
        
        return ans;
    }
};