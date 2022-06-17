/*
https://leetcode.com/problems/3sum-closest/
16. 3Sum Closest

*/
class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int n = nums.size();
        sort(nums.begin(), nums.end());
        
        if(n<3) return 0;
        
        int l, r, ans = 0, sum, diff, min_diff=INT_MAX;
        for(int i=0; i<n-2; i++)
        {
            l = i+1;
            r = n-1;
            while(l<r)
            {
                sum = nums[i]+nums[l]+nums[r];
                
                diff = abs(target-sum);
                    if(diff < min_diff)
                    {
                        min_diff = diff;
                        ans = sum;
                    }
                
                // if(sum == target) 
                //     return sum;
                else if(sum > target)
                {
                    // diff = (sum-target);
                    // if(diff < min_diff)
                    // {
                    //     min_diff = diff;
                    //     ans = sum;
                    // }
                    r--;
                }
                else if(sum < target)
                {
                    // diff = (target-sum);
                    // if(diff < min_diff)
                    // {
                    //     min_diff = diff;
                    //     ans = sum;
                    // }
                    l++;                  

                }
                else
                   return ans;
                    
            }
        }//for i
            
        return ans;
    }//end
};