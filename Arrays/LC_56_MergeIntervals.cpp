/*
https://leetcode.com/problems/merge-intervals/
56. Merge Intervals
https://practice.geeksforgeeks.org/problems/8a644e94faaa94968d8665ba9e0a80d1ae3e0a2d/1/#
*/
class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        if(intervals.size() <=1 )return intervals;
        
        sort(intervals.begin(), intervals.end());
        vector<vector<int>> ans;
        
        ans.push_back(intervals[0]);
        
        for(int i=1; i< intervals.size(); i++)
        {
            if(intervals[i][0] <= ans.back()[1])
            {
                if(intervals[i][1] > ans.back()[1])
                    ans.back()[1] = intervals[i][1];
            }
                
            else
               ans.push_back(intervals[i]);
        }
        
        // for(auto x: ans)
        // {
        //     cout<<"["<<x[0]<<","<<x[1] <<"], ";
        // }
        
        return ans;
    }//end
};