/*
https://leetcode.com/problems/sort-colors/
75. Sort Colors

*/
class Solution {
public:
    void sortColors(vector<int>& nums) {
        
        // sort(nums.begin(), nums.end());
        
        /*
        int count[3]={0};
        
        for(int x: nums)
            count[x]++ ;
        
        
        for(int i=0; i<nums.size(); i++)
        {
            if(count[0])
            {   
                nums[i]=0;
                count[0]--;
            }
            else if(count[1])
            {    nums[i]=1;
                count[1]--;
            }
            else if(count[2])
            {  nums[i]=2;
                count[2]--;
            }
        }
        */
        
        //Second approach DUTCH National Flag
        int low = 0, mid=0, high=nums.size()-1;
        
        while(mid<=high)
        {
           switch(nums[mid])
           {
               case 0: swap(nums[low++], nums[mid++]);
                   break;
               case 1: mid++;
                   break;
               case 2: swap(nums[mid], nums[high--]);
                   break;
           }
        }//while
        
    }//end
};