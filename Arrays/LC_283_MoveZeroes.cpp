/*
https://leetcode.com/problems/move-zeroes/
283. Move Zeroes

*/
class Solution {
public:
    
    void moveZeroes(vector<int>& nums) {
        
        int n=nums.size();
        if(n <=1 )return;
        /*
        int i=0, j=0;
        while(j<n)
        {
            if(nums[j] != 0) 
            {
                swap(nums[j], nums[i]);
                i++;
            }
            
            j++;
        }
        */
        int z=-1;
        for(int i=0; i<n; i++)
        {
            if(z==-1 and nums[i]==0)
                z=i; //first zero
            else if(z>=0 and nums[i] != 0)
            {
                nums[z] = nums[i];
                z++;
            }
            
        }
        
        if(z==-1)
            return;
        
        for(int i=z; i<n; i++)
            nums[i] = 0;
        
        
    }//
};