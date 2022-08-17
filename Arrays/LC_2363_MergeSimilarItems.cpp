/*
2363. Merge Similar Items
https://leetcode.com/problems/merge-similar-items/
*/

class Solution {
public:
    vector<vector<int>> mergeSimilarItems(vector<vector<int>>& items1, vector<vector<int>>& items2) {
        vector<vector<int>> ans;
        
        map<int,int> um;
        for(auto x: items1)
        {
            um[x[0]] = x[1];
        }
        for(auto x: items2)
        {
            um[x[0]] += x[1];
        }
        
        for(auto x: um)
            ans.push_back({x.first, x.second});
        
        
        return ans;
    }
};