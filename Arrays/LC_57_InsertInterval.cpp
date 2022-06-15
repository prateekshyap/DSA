/*
https://leetcode.com/problems/insert-interval/
57. Insert Interval

*/
class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
    
        vector<vector<int>> ans;
        
        int ins=0;
        
        while(ins < intervals.size() && intervals[ins][0] < newInterval[0])
            ins++;
        
        intervals.insert(intervals.begin()+ins, newInterval);
        // for(auto x: intervals)
        //     cout<<x[0]<<" "<<x[1]<<" ";
        ans.push_back(intervals[0]);
        
        for(int i=1; i<intervals.size(); i++)
        {
            
            if(intervals[i][0] <= ans.back()[1])
            {
                if(intervals[i][1] >= ans.back()[1])
                    ans.back()[1] = intervals[i][1];
            }
            else
                ans.push_back(intervals[i]);
            
        }
        
        return ans;
    }//
    
};