 /*
	https://leetcode.com/problems/merge-intervals/
	56. Merge Intervals
*/

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        
        sort(intervals.begin(), intervals.end());
        
        vector<vector<int>> ans ;
        
        ans.push_back(intervals[0]);
        
        for(int i=1; i<intervals.size(); i++)
        {
            if(ans.back()[1] >= intervals[i][0])
            {
                if(intervals[i][1] >  ans.back()[1])
                    ans.back()[1] = intervals[i][1];
                
            }
            else
                    ans.push_back(intervals[i]);
        }
        
         return ans;
    }// end
};