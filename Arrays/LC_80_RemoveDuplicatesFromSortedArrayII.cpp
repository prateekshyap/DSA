/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/
80. Remove Duplicates from Sorted Array II

https://binarysearch.com/problems/Remove-Duplicates-Occurring-More-Than-Twice
*/

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        
        if(nums.size()==1) return 1;
        
//         int i=0, j=1;
//         bool flag = true;
        
//         while(j<nums.size())
//         {
//             while(nums[i]==nums[j])
//             {
//                 if(flag)
//                 {
//                     i++;
//                     swap(nums[i], nums[j]);
//                     flag = false;
//                 }
//                 j++;
//                 if(j>=nums.size()) return i+1;
//             }
            
//             i++;
//             swap(nums[i], nums[j]);
//             j++;
//             flag=true;
//         }
//         return i+1;
        
        
        int left=0, right=1;
        int count = 1;
        
        for( ; right<nums.size(); right++)
        {
            if(nums[left] == nums[right])
                count +=1;
            else
                count = 1;
            
            if(count<=2)
            {
                left++;
                nums[left] = nums[right];
            }
            
            
        }
        return left+1; // because zero indexing
    }//end
};