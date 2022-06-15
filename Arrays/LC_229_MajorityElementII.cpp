/*
229. Majority Element II
https://leetcode.com/problems/majority-element-ii/
*/
class Solution {
public:
    //Using Extra Space O(n)
    vector<int> majorityElement1(vector<int>& nums) {
        
        vector<int> ans;
        unordered_map<int,int> count;
        int th = nums.size()/3;
        
        for(int i=0; i<nums.size(); i++)
        {
            count[nums[i]]++;
            if(count[nums[i]]>th)
            {    
                ans.push_back(nums[i]);
                 count[nums[i]]=-1;
            }
            
        }
        for(auto x: count)
            cout<<x.first<<" "<<x.second<<endl;
        
        return ans;
    }//end
    
    vector<int> majorityElement(vector<int>& nums) {
        
        vector<int> ans;
        //for n/3 there are two candidate
        int cand1 = -1, cand2 = -1;
        int cnt1=0, cnt2=0;
        
        for(int i=0; i<nums.size(); i++)
        {
            if(cand1 == nums[i])
                cnt1++;
            else if(cand2 == nums[i])
                cnt2++;
            else
            {
                if(cnt1==0)
                {
                    cand1=nums[i];
                    cnt1=1;
                }
                else if(cnt2==0)
                {
                    cand2 = nums[i];
                    cnt2=1;
                }
                else
                {
                    cnt1--;
                    cnt2--;
                }
            }
        }
        
        cnt1=0;
        cnt2=0;
        for(auto x: nums)
        {
            if(cand1 == x)cnt1++;
            else if(cand2 == x)cnt2++;
        }
        
        if(cnt1 > nums.size()/3) ans.push_back(cand1);
        if(cnt2 > nums.size()/3) ans.push_back(cand2);
        
        return ans;
    }//end
};