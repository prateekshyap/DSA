/*
https://leetcode.com/problems/max-sum-of-a-pair-with-equal-sum-of-digits/
2342. Max Sum of a Pair With Equal Sum of Digits
*/
class Solution {
public:
    int maximumSum(vector<int>& nums) {
        int n = nums.size();
        
        auto count=[&](int num)
        {
            int sum=0;
            while(num)
            {
                sum+=num%10;
                num/=10;
            }
            return sum;
        };
        
        sort(rbegin(nums), rend(nums));
        
        unordered_map<int, vector<int>> um;
        for(auto x: nums)
            um[count(x)].push_back(x);
        
        int max_sum=0;
        for(auto &[s, v]: um)
        {
            if(v.size()>=2)
                max_sum = max(max_sum, v[0]+v[1]);
        }
        
        return max_sum == 0? -1: max_sum;
    }
};