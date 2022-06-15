/*
https://leetcode.com/problems/minimum-size-subarray-sum/
209. Minimum Size Subarray Sum

*/
class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        
       // Using Sliding Window
        int sum = 0;
        int minlen = INT_MAX; //max len is this
        
        int start=0, end=0;
        
        while(end < nums.size())
        {
            sum += nums[end];
            
            // if sum is greater than target then update len and move sliding window
            while(sum>=target)
            {
                minlen = min(minlen, end-start+1);
                sum -= nums[start];
                start++;
            }
            
            // cout<<"  len "<<minlen;
            // cout<<"  sum "<<sum;
            // cout<<" s"<<start<<" "<<" e"<<end<<endl;
            end++;
        }
        
        
        return minlen == INT_MAX ? 0 : minlen;
    }// end
};