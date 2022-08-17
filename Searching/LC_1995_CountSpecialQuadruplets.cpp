/*
1995. Count Special Quadruplets

https://leetcode.com/problems/count-special-quadruplets/
*/
class Solution {
public:
    int countQuadruplets(vector<int>& nums) {
        // sort(nums.begin(), nums.end());
        int n = nums.size();
        int ans=0;
        // for(int i=0; i<n-3; i++)
        // {
        //     for(int j=i+1; j<n-2; j++)
        //     {
        //         for(int k=j+1; k<n-1; k++)
        //         {
        //             for(int d=k+1; d<n; d++)
        //                 if(nums[i] + nums[j] + nums[k] == nums[d])
        //                     ans++;
        //         }
        //     }
        // }
        unordered_map<int,int> hash;
        
        hash[nums[n-1]-nums[n-2]]++; 
        for(int b=n-3; b>=1; b--)
        {
            for(int a=b-1; a>=0; a--)
            {
                // if(hash.count(nums[i]+nums[j]))
                    ans+=hash[nums[a]+nums[b]];
            }
            for(int c=b+1; c<n ; c++)
                hash[nums[c]-nums[b]]++;
        }
        
        //  for(int b=1; b<=n-3; b++)
        // {
        //     for(int a=0; a<b; a++)
        //         hash[nums[a]+nums[b]]++;
        //     int c = b+1;
        //     for(int d=b+2; d<n; d++)
        //         ans += hash[nums[d] - nums[c]];
        // }
        return ans;
    }
};