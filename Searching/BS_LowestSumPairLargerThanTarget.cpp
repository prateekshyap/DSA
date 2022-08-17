/*
https://binarysearch.com/problems/Lowest-Sum-of-Pair-Larger-than-Target

*/

int solve(vector<int>& nums, int target) {
    
    sort(nums.begin(), nums.end());

    int i=0;
    int j=nums.size()-1;
    int minsum=INT_MAX;
    
    while(i<j)
    {
        int cursum = nums[i]+nums[j];
        if(cursum > target)
        {
            minsum = min(minsum, cursum);
            j--;
        }
        else
            i++;
    }

    return minsum;
}